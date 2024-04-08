import time

import requests
from bs4 import BeautifulSoup
from ctidb import CtiDb


class Spider:
    def __init__(self):
        # 设置用户代理
        self.headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/111.0",
        }

    # 获取所有url
    @staticmethod
    def get_url(file) -> list:
        url_list = []
        with open(file, 'r', encoding='utf-8') as f:
            lines = f.readlines()
            for line in lines:
                value = line.strip('\n')
                url_list.append(value)
        return url_list

    # 获取post提交所需所有payload
    @staticmethod
    def get_payload(file) -> list:
        payload_list = []
        with open(file, 'r', encoding='utf-8') as f:
            lines = f.readlines()
            for line in lines:
                value = line.strip('\n')
                payload_list.append(value)
        return payload_list

    # 获取url与payload字典，url:dic[0],payload:dic[1]
    @staticmethod
    def get_post_data(url_list, payloads) -> list:
        dic = []
        data = []
        # 设置url对应payload开始与结束位置
        start = [0, 10, 20, 36, 41, 46, 56]
        end = [10, 20, 36, 41, 46, 56, 87]
        for i in range(len(url_list)):
            for j in range(start[i], end[i]):
                data.append(url_list[i])
                data.append(payloads[j])
                # 加入列表
                dic.append(data)
                data = []
        return dic

    # 发送post请求，并解析html，获取表格所有数据，并根据payload获取数据应存入表名称
    def parse_url(self, url, payload) -> [list, str]:
        # post提交数据，获取响应
        # resp = requests.get(url=url, headers=self.headers, params=payload)
        resp = requests.post(url=url, headers=self.headers, data=payload)
        if resp.status_code == requests.codes.ok:
            # 解码为html
            html = resp.content.decode('utf-8')
            # 解析网页内容
            soup = BeautifulSoup(html, 'html.parser')
            # 获取表格内容，以行划分
            table = soup.find('table').text.split('\n')
            # 获取表名称
            table_name = ''
            s = payload.get("dataTypeCode")
            start = s.find("-BL-") + 4
            for i in range(start, len(s)):
                if s[i] != ' ':
                    table_name += s[i]
                else:
                    break
            # 列表内存放表格所有内容
            values = []
            # 去掉空内容与内容前后空格
            for i in range(len(table)):
                # 去空
                value = table[i].strip()
                if value and value != '编号':
                    values.append(value)
            # print(values)
            # print(table_name.lower())
            return [values, table_name.lower()]
        else:
            print("错误请求：" + resp.status_code)

    # 表格一行为一个list，存放所有行到list of list，cnt为每行值个数
    @staticmethod
    def get_content(values, table_name) -> list:
        # 获取存储列数
        cnt_dict = {"phishingurl": 5, "phishingip": 4, "pmalware": 6, "mmalware": 6, "pmurl": 5, "pmip": 5, "mmurl": 5,
                    "mmip": 5, "email": 5, "phonenum": 5, "ddosip": 5, "drdosip": 4, "osint": 6
                    }
        cnt = cnt_dict.get(table_name)
        # 按行存储
        content = []
        # 每行内容
        row = []
        for i in range(len(values)):
            row.append(values[i])
            # 对表格每行内容进行划分
            # osint特殊处理， 发布者可能为空
            if table_name == 'osint':
                if values[i] == '详情' or values[i] == '操作':
                    if len(row) == 5:
                        row.insert(3, "匿名")
                    if row[0].isdigit():
                        content.append(row)
                    row = []
            elif (i + 1) % cnt == 0:
                # 去表头第一行中文
                if row[0].isdigit():
                    content.append(row)
                row = []
        return content

    # 运行
    def run(self):
        # 获取url列表
        url_list = self.get_url('url_list')
        # 获取payload列表
        payload = self.get_payload('payload_list')
        # 获取url对应payload
        dic = self.get_post_data(url_list, payload)
        # print(len(dic))
        # 总数据插入条数
        cnt = 0
        # 获取数据分组内容
        for n in range(len(dic)):
            url = dic[n][0]
            # 将payload转换为字典
            payload = eval(dic[n][1])
            # print(n)
            [values, table_name] = self.parse_url(url, payload)
            print(table_name)
            content = self.get_content(values, table_name)
            # print(content)
            for i in content:
                value = []
                # 数据库osint去除最后一列数据
                if table_name == 'osint':
                    length = len(i) - 1
                else:
                    length = len(i)
                # 去除第一列id
                for j in range(1, length):
                    value.append(i[j])
                # 通过编号查询数据库
                query = value[0]
                # print(value)
                # 转换为字符串，可以直接接入sql语句
                insert_data = str(value).replace('[', '(').replace(']', ')')
                # print(insert_data)
                # 查询数据是否已存在
                db = CtiDb()
                exist = db.mysql_query(table_name, query)
                # # # 数据不存在则插入数据库
                if exist is False:
                    db.mysql_insert(table_name, insert_data)
                    cnt += 1
            # print("数据库" + table_name + "共插入数据：" + str(cnt) + "条")
            time.sleep(1)
        print("本次插入数据：" + str(cnt) + "条")


if __name__ == '__main__':
    spider = Spider()
    spider.run()
