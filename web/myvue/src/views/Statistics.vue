<template>
    <div class="echart" id="mychart" :style="myChartStyle"></div>
</template>
  
<script>
import * as echarts from "echarts";

export default {
    name: 'Statistics',
    data() {
        return {
            myChart: {},
            pieData: [
                {
                    value: 100,
                    name: "钓鱼网站地址"
                },
                {
                    value: 100,
                    name: "钓鱼网站服务器IP地址"
                },
                {
                    value: 100,
                    name: "计算机恶意程序"
                },
                {
                    value: 100,
                    name: "移动恶意程序"
                },
                {
                    value: 100,
                    name: "计算机放马地址"
                },
                {
                    value: 100,
                    name: "移动恶意程序传播地址"
                },
                {
                    value: 100,
                    name: "移动恶意程序传播服务器IP地址"
                },
                {
                    value: 100,
                    name: "恶意邮箱账户",
                },
                {
                    value: 100,
                    name: "恶意手机号"
                },
                {
                    value: 100,
                    name: "DDoS攻击主机服务器地址"
                },
                {
                    value: 100,
                    name: "反射型DDoS攻击服务器地址"
                },
                {
                    value: 604,
                    name: "开源情报数据"
                }
            ],
            pieName: [],
            myChartStyle: { float: "left", width: "100%", height: "600px" } //图表样式
        };
    },
    mounted() {
        this.initDate(); //数据初始化
        this.initEcharts();
    },
    methods: {
        initDate() {
            for (let i = 0; i < this.pieData.length; i++) {
                this.pieName[i] = this.pieData[i].name;
            }
        },
        initEcharts() {
            // 饼图
            const option = {
                legend: {
                    // 图例
                    data: this.pieName,
                    right: "0%",
                    top: "20%",
                    orient: "vertical",
                    textStyle: {
                        fontSize: 15
                    }
                },
                title: {
                    // 设置饼图标题位置
                    text: "威胁情报数据统计",
                    top: "5%",
                    left: "center",
                    textStyle: {
                        fontSize: 20
                    }
                },
                series: [
                    {
                        type: "pie",
                        label: {
                            show: true,
                            // 格式化数据，b代表名称，c代表对应值，d代表百分比
                            formatter: "{b} : {c} ({d}%)",
                            textStyle: {
                                fontSize: 15
                            }
                        },
                        radius: "55%", //饼图半径
                        center: ['37%', '50%'],
                        data: this.pieData,
                    }
                ]
            };
            this.myChart = echarts.init(document.getElementById("mychart"));
            this.myChart.setOption(option);
            // 点击跳转页面
            this.myChart.on('click', function (param) {
                var map = new Map([
                    ["钓鱼网站地址", "#/phishingip"],
                    ["钓鱼网站服务器IP地址", "#/phishingurl"],
                    ["计算机恶意程序", "#/pmalware"],
                    ["移动恶意程序", "#/mmalware"],
                    ["计算机放马地址", "#/pmurl"],
                    ["移动恶意程序传播地址", "#/mmurl"],
                    ["移动恶意程序传播服务器IP地址", "#/mmip"],
                    ["恶意邮箱账户", "#/email"],
                    ["恶意手机号", "#/phonenum"],
                    ["DDoS攻击主机服务器地址", "#/ddosip"],
                    ["反射型DDoS攻击服务器地址", "#/drdosip"],
                    ["开源情报数据", "#/osint"]
                ])
                var value = map.get(param.name)
                if (value != '') {
                    window.location.href = value;
                }
            });
            //随着屏幕大小调节图表
            window.addEventListener("resize", () => {
                this.myChart.resize();
            });
        }
    },

};
</script>

<style scoped>
.echart {
    background-image: url('../assets/login.svg');
}
</style>