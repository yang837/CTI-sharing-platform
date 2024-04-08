from main import Spider
from ctidb import CtiDb

value = ['1', '2', '4']
value.insert(2, '3')
print(value)

# cnt = 100
# print("插入数据:" + str(cnt) + "条")
#
# c = CtiDb()
# table_name = 'test'
# value = "('f')"
# query = '1233'
# print("数据库" + table_name + "共插入数据" + str(cnt) + "条")
# exist = c.mysql_query(table_name, query)
# if exist is False:
#     c.mysql_insert(table_name, value)


s = Spider()
# 获取url列表
# url_list = s.get_url('url_list')
# # 获取payload列表
# payload = s.get_payload('payload_list')
# # 获取url对应payload
# dic = s.get_post_data(url_list, payload)
# url = dic[51][0]
# payload = eval(dic[51][1])
# [values, table_name] = s.parse_url(url=url, payload=payload)
# print(values)
# content = s.get_content(values, table_name)
# print(content)
