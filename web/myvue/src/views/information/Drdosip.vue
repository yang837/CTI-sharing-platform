<template>
    <div class="container">
        <div class="title">
            <span>反射型DDoS攻击服务器地址</span>
        </div>
        <br>
        <div class="table">
            <el-table :data="tableData" stripe style="width: 100%">
                <el-table-column prop="id" label="序号" width="180" />
                <el-table-column prop="number" label="CCTGA-BL-DRDoSIP 编号" width="180" />
                <el-table-column prop="address" label="IP地址" width="180" />
                <el-table-column prop="time" label="发布时间" />
            </el-table>

            <!-- 分页 -->
            <div class="example-pagination-block">
                <el-pagination layout="prev, pager, next" :total="50" />
            </div>

        </div>
    </div>
</template>

<script>
export default {
    name: "Drdosip",
    data() {
        return {
            tableData: [],
        };
    },
    mounted() {
        this.$axios({
            method: "get",
            url: "/drdosip",
        }).then(res => {
            this.$data.tableData = res.data;
        });
    },
}
</script>

<style scoped>
.container {
    background: url('../../assets/login.svg');
}

.title {
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