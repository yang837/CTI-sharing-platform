<template>
    <div class="container">
        <div class="title">
            <span>恶意邮箱账户</span>
        </div>
        <br>
        <div class="table">
            <el-table :data="tableData" stripe style="width: 100%">
                <el-table-column prop="id" label="序号" width="150" />
                <el-table-column prop="number" label="CCTGA-BL-EMAIL 编号" width="230" />
                <el-table-column prop="account" label="邮箱账号" width="250" />
                <el-table-column prop="md5" label="样本MD5" width="280" />
                <el-table-column prop="time" label="发布时间" />
            </el-table>

            <!-- 分页 -->
            <div class="example-pagination-block">
                <el-pagination layout="prev, pager, next" :total="50" />
                <!-- <el-pagination :current-page="currentPage" :page-size="pageSize" :total="total" layout="prev, pager, next"
                @current-change="handleCurrentChange" /> -->
            </div>
            
        </div>
    </div>
</template>

<script>
export default {
    name: "Email",
    data() {
        return {
            tableData: [],
        };
    },
    mounted() {
        this.$axios({
            method: "get",
            url: "/email",
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