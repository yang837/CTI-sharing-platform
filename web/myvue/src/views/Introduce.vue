<template>
    <div class="container">
        <h1 class="title">平台介绍</h1>
        <br>
        <el-text class="text" size="large" type="info">
            <p>网络空间威胁情报共享平台是一个用于共享威胁情报的平台。
                该平台旨在促进网络安全领域内的信息共享，提高网络安全的整体水平。
                主要功能包括威胁情报的收集、整合、处理和共享，并通过数据可视化方式展示威胁情报的趋势和变化。
                用户还可以通过平台信息共享菜单查看各种类型的威胁情报，并可以在数据统计中清晰的查看各类威胁情报的占比。
            </p>
        </el-text>
    </div>
</template>

<script>
export default {
    name: 'Introduce'
}
</script>

<style scoped>
.container {
    padding-top: 2%;
    text-align: center;
    background-image: url('../assets/login.svg');
}

.title {
    font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
    font-size: x-large;
    font-weight: 500;
    color: black;
}

.text {
    text-indent: 30px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: large;
    font-weight: 500;
    color: black;
    text-align: justify;
    line-height: 45px;
}
</style>