<template>
    <div class="common-layout">
        <el-container class="container">
            <!-- 侧边目录，引入AppMenu组件 -->
            <el-aside class="aside" :style="{ 'width': (isCollapse ? '63px' : '230px') }">
                <AppMenu :isCollapse="isCollapse" />
            </el-aside>
            <!-- 主容器 -->
            <el-container>
                <!-- 头部 -->
                <el-header class="header">
                    <el-row>
                        <el-col :span="1">
                            <!-- el-icon size:number -->
                            <el-button type="text" @click="toggle">
                                <el-icon :size="25">
                                    <fold />
                                </el-icon>
                            </el-button>
                        </el-col>
                    </el-row>
                    <div class="title">网络空间威胁情报共享平台</div>
                </el-header>
                <!-- 添加滚动条 -->
                <el-scrollbar max-height="800px">
                    <!-- 主要内容 -->
                    <el-main class="main"><router-view /></el-main>
                    <!-- 尾部 -->
                    <!-- <el-footer class="footer">footer</el-footer> -->
                </el-scrollbar>
            </el-container>
        </el-container>
    </div>
</template>
<script lang="ts" setup>
import AppMenu from '@/components/AppMenu.vue';
import { ref } from 'vue'
import { Fold } from '@element-plus/icons-vue';
let isCollapse = ref(false)
const toggle = (): void => {
    isCollapse.value = !isCollapse.value
}

</script>
<style scoped lang="scss">
.container {
    height: 100vh;

    .aside {
        overflow: hidden;
    }

    .header {
        background-color: #ebf1f5;
        background-image: url('../assets/login.svg');
        // 弹性布局
        display: flex;
        // 按钮居中
        align-items: center;
        height: 80px;
    }

    .title {
        font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
        font-size: x-large;
        font-weight: 500;
        color: black;
    }

    // .main {}
}
</style>