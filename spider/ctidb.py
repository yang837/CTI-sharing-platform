import pymysql


class CtiDb:
    def __init__(self):
        # 初始化连接信息
        self.host = '127.0.0.1'
        self.user = 'root'
        self.passwd = '123456'
        self.port = 3306
        self.db = 'cti'
        self.charset = 'utf8'

        # 数据库表对应的列名
        self.column_dict = {
            "phishingurl": '(number, address, domain, time)',
            "phishingip": '(number, address, time)',
            "pmalware": '(number, name, os, md5, time)',
            "mmalware": '(number, name, os, md5, time)',
            "pmurl": '(number, address, md5, time)',
            "pmip": '(number, address, md5, time)',
            "mmurl": '(number, address, md5, time)',
            "mmip": '(number, address, md5, time)',
            "email": '(number, account, md5, time)',
            "phonenum": '(number, phone, md5, time)',
            "ddosip": '(number, address, type, time)',
            "drdosip": '(number, address, time)',
            "osint": '(number, tag, promulgator, time)',
            "test": '(name)'
        }

    # 数据库连接
    def get_connector(self):
        conn = pymysql.connect(
            host=self.host,  # 连接主机
            user=self.user,  # 用户名
            passwd=self.passwd,  # 密码
            port=self.port,  # 端口
            db=self.db,  # 数据库名称
            charset=self.charset  # 字符编码
        )
        return conn

    # 数据插入
    def mysql_insert(self, table_name, value):
        conn = self.get_connector()
        # 生成游标对象
        cursor = conn.cursor()
        # sql语句
        sql_data = "insert into " + table_name + self.column_dict.get(table_name) + " values" + value
        # print(sql_data)
        # 执行sql语句
        try:
            cursor.execute(sql_data)
        except Exception as e:
            print(e)
        conn.commit()
        # print("插入数据成功")
        # 关闭游标
        cursor.close()
        # 关闭数据库连接
        conn.close()

    # 数据查询
    def mysql_query(self, table_name, value) -> bool:
        conn = self.get_connector()
        cursor = conn.cursor()
        sql_data = "select * from " + table_name + " where number = " + '"' + value + '"'
        # print(sql_data)
        cursor.execute(sql_data)
        data = cursor.fetchone()
        if data:
            return True
        return False

    # 测试连接
    def test_conn(self):
        conn = self.get_connector()
        # 生成游标对象 cursor
        cursor = conn.cursor()

        # 查询数据库版本
        sql = "select version()"
        cursor.execute(sql)  # 返回值是查询到的数据数量
        # 通过 fetchall方法获得数据
        data = cursor.fetchone()
        print("Database Version:%s" % data)

        cursor.close()  # 关闭游标
        conn.close()  # 关闭连接


if __name__ == "__main__":
    pass
