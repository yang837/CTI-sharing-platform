import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8082';
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';

const app = createApp(App)
app.use(ElementPlus)
    .use(store)
    .use(router)
    .mount('#app')
app.config.globalProperties.$axios = axios
// createApp(App).use(ElementPlus).use(store).use(router).mount('#app')
