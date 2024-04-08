<template>
    <div class="logo">
        <img src="../assets/img/1.jpg">
    </div>
    <el-menu default-active="2" :collapse="props.isCollapse" :collapse-transition="false" @open="handleOpen"
        @close="handleClose" background-color="#ebf1f5" text-color="#606266" active-text-color="#2F74FF" class="menu"
        router>
        <!-- 首页 -->
        <el-menu-item index="home">
            <el-icon>
                <HomeFilled />
            </el-icon>
            <template #title>首页</template>
        </el-menu-item>
        <!-- 平台介绍 -->
        <el-menu-item index="introduce">
            <el-icon>
                <document />
            </el-icon>
            <template #title>平台介绍</template>
        </el-menu-item>
        <!-- 信息共享 -->
        <el-sub-menu index="information">
            <template #title>
                <el-icon>
                    <Reading />
                </el-icon>
                <span>信息共享</span>
            </template>
            <!-- 信息共享子目录 -->
            <el-scrollbar height="450px">
                <el-sub-menu index="phishing">
                    <template #title><span>钓鱼地址</span></template>
                    <el-menu-item index="phishingurl">钓鱼网站地址</el-menu-item>
                    <el-menu-item index="phishingip">钓鱼网站服务器IP地址</el-menu-item>
                </el-sub-menu>

                <el-sub-menu index="pmm">
                    <template #title><span>恶意程序</span></template>
                    <el-menu-item index="pmalware">计算机恶意程序</el-menu-item>
                    <el-menu-item index="mmalware">移动恶意程序</el-menu-item>
                </el-sub-menu>

                <el-menu-item index="pmurl">计算机放马地址</el-menu-item>

                <el-sub-menu index="mm">
                    <template #title><span>传播地址</span></template>
                    <el-menu-item index="mmurl">移动恶意程序传播地址</el-menu-item>
                    <el-menu-item index="mmip">移动恶意程序传播服务器IP地址</el-menu-item>
                </el-sub-menu>

                <el-menu-item index="email">恶意邮箱账户</el-menu-item>

                <el-menu-item index="phonenum">恶意手机号</el-menu-item>

                <el-sub-menu index="ddos">
                    <template #title><span>DDos数据</span></template>
                    <el-menu-item index="ddosip">DDoS攻击主机服务器地址</el-menu-item>
                    <el-menu-item index="drdosip">反射型DDoS攻击服务器地址</el-menu-item>
                </el-sub-menu>

                <el-menu-item index="osint">开源情报数据</el-menu-item>

            </el-scrollbar>
        </el-sub-menu>
        <!-- 数据统计 -->
        <el-menu-item index="statistics">
            <el-icon>
                <DataAnalysis />
            </el-icon>
            <template #title>数据统计</template>
        </el-menu-item>
    </el-menu>
</template>
  
<script lang="ts" setup>
import { ref } from 'vue'
import {
    DataAnalysis,
    DataLine,
    Document,
    HomeFilled,
    Menu as IconMenu,
    Location,
    Reading,
    Setting,
} from '@element-plus/icons-vue'

const props = defineProps(['isCollapse'])
const handleOpen = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
</script>
  
<style>
.logo {
    display: flex;
    height: 80px;
    background: #e1eaf4;
}

.menu {
    min-height: calc(100vh - 80px);
    background-image: url('../assets/login.svg');
}
</style>