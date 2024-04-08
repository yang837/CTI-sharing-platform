<template>
    <div class="container">
        <h1 class="title">首页</h1>
        <br>
        <div class="title1">
            <span>威胁情报共享数据类型</span>
        </div>
        <br>
        <div class="table">
            <el-table :data="tableData" stripe style="width: 100%">
                <el-table-column prop="id" label="序号" width="180" />
                <el-table-column prop="number" label="数据编码" width="300" />
                <el-table-column prop="name" label="数据名称" width="300" />
                <el-table-column prop="type" label="数据类型" />
            </el-table>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Home',
    data() {
        return {
            tableData: [
                {
                    id: "01",
                    number: "CCTGA-BL-PHISHINGURL",
                    name: "钓鱼网站地址",
                    type: "URL"
                },
                {
                    id: "02",
                    number: "CCTGA-BL-PHISHINGIP",
                    name: "钓鱼网站服务器IP地址",
                    type: "IP"
                },
                {
                    id: "03",
                    number: "CCTGA-BL-PMALWARE",
                    name: "计算机恶意程序",
                    type: "File"
                },
                {
                    id: "04",
                    number: "CCTGA-BL-MMALWARE",
                    name: "移动恶意程序",
                    type: "File"
                },
                {
                    id: "05",
                    number: "CCTGA-BL-PMURL",
                    name: "计算机放马地址",
                    type: "URL"
                },
                {
                    id: "06",
                    number: "CCTGA-BL-MMURL",
                    name: "移动恶意程序传播地址",
                    type: "URL"
                },
                {
                    id: "07",
                    number: "CCTGA-BL-MMIP",
                    name: "移动恶意程序传播服务器IP地址",
                    type: "IP"
                },
                {
                    id: "08",
                    number: "CCTGA-BL-EMAIL",
                    name: "恶意邮箱账户",
                    type: "Email"
                },
                {
                    id: "9",
                    number: "CCTGA-BL-PHONENUM",
                    name: "恶意手机号",
                    type: "PhoneNum"
                },
                {
                    id: "10",
                    number: "CCTGA-BL-DDoSIP",
                    name: "DDoS攻击主机服务器地址",
                    type: "DDoSIP"
                },
                {
                    id: "11",
                    number: "CCTGA-BL-DRDoSIP",
                    name: "反射型DDoS攻击服务器地址",
                    type: "DRDoSIP"
                },
                {
                    id: "12",
                    number: "CCTGA-BL-OSINT",
                    name: "开源情报",
                    type: "Intelligence"
                },
            ],
        };
    },
}
</script>

<style scoped>
.container {
    background-image: url('../assets/login.svg');
}

.title {
    padding-top: 2%;
    /* text-align: center; */
    font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
    font-size: x-large;
    font-weight: 500;
    color: black;
}

.title1 {
    font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
    font-size: larger;
    font-weight: 500;
    color: black;
}

.example-pagination-block+.example-pagination-block {
    margin-top: 10px;
}

.example-pagination-block .example-demonstration {
    margin-bottom: 16px;
}
</style>