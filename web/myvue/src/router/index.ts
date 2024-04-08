import { createRouter, createWebHashHistory, RouterView } from 'vue-router'
import AppLayout from '../layout/AppLayout.vue'

const routes = [
  {
    // 登录首页
    path: '/',
    name: 'Login',
    component: () =>
      import('../views/Login.vue'),
  },
  {
    // 错误界面
    path: '/:catchAll(.*)',
    name: '404',
    component: () =>
      import('../views/404.vue')
  },
  // 添加导航
  {
    path: '/',
    component: AppLayout,
    children: [
      // 首页
      {
        path: '/home',
        name: 'Home',
        component: () =>
          import('../views/Home.vue')
      },
      // 平台介绍
      {
        path: '/introduce',
        name: 'Introduce',
        component: () =>
          import('../views/Introduce.vue')
      },
      // 数据统计
      {
        path: '/statistics',
        name: 'Statistics',
        component: () =>
          import('../views/Statistics.vue')
      },
      // 信息共享
      // 钓鱼地址
      {
        path: '/phishingurl',
        name: 'Phishingurl',
        component: () =>
          import('../views/information/Phishingurl.vue')
      },
      {
        path: '/phishingip',
        name: 'Phishingip',
        component: () =>
          import('../views/information/Phishingip.vue')
      },
      // 恶意程序
      {
        path: '/pmalware',
        name: 'Pmalware',
        component: () =>
          import('../views/information/Pmalware.vue')
      },
      {
        path: '/mmalware',
        name: 'Mmalware',
        component: () =>
          import('../views/information/Mmalware.vue')
      },
      // 放马地址
      {
        path: '/pmurl',
        name: 'Pmurl',
        component: () =>
          import('../views/information/Pmurl.vue')
      },
      {
        path: '/pmip',
        name: 'Pmip',
        component: () =>
          import('../views/information/Pmip.vue')
      },
      // 传播地址
      {
        path: '/mmurl',
        name: 'Mmurl',
        component: () =>
          import('../views/information/Mmurl.vue')
      },
      {
        path: '/mmip',
        name: 'Mmip',
        component: () =>
          import('../views/information/Mmip.vue')
      },
      // 恶意邮箱账户
      {
        path: '/email',
        name: 'Email',
        component: () =>
          import('../views/information/Email.vue')
      },
      // 恶意手机号
      {
        path: '/phonenum',
        name: 'Phonenum',
        component: () =>
          import('../views/information/Phonenum.vue')
      },
      // DDos数据
      {
        path: '/ddosip',
        name: 'Ddosip',
        component: () =>
          import('../views/information/Ddosip.vue')
      },
      {
        path: '/drdosip',
        name: 'Drdosip',
        component: () =>
          import('../views/information/Drdosip.vue')
      },
      // 开源情报数据
      {
        path: '/osint',
        name: 'Osint',
        component: () =>
          import('../views/information/Osint.vue')
      },
    ]
  },
]

const router = createRouter({
  // history: createWebHistory(process.env.BASE_URL),
  history: createWebHashHistory(),
  routes
})

export default router