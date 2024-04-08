<template>
    <div class="container" :class="{ 'sign-up-mode': signInMode }">
        <div class="login-logo">
            <!-- <svg-icon name="logo" :size="45" /> -->
            <img src="../assets/img/logo.jpg" width="45" />
            <h1 class="title">网络空间威胁情报共享平台</h1>
        </div>
        <!-- form表单容器 -->
        <div class="form-container">
            <div class="signin-signup">
                <LoginForm :login-user="loginUser" :rules="rules" />
            </div>
        </div>
    </div>
</template>
  
<script lang="ts">
import { ref } from 'vue'
// 登录
import { loginUser, rules } from '@/utils/loginValidators'
import LoginForm from '@/components/LoginForm.vue'

export default {
    name: 'Login',
    components: {
        LoginForm,
    },
    setup() {
        // 登录模式
        const signInMode = ref(false)
        return { signInMode, loginUser, rules }
    }
}
</script>

<style scoped>
.container {
    display: flex;
    width: 100vw;
    height: 100vh;
    padding-top: 240px;
    background: url('../assets/login.svg');
    background-size: 100%;
    flex-direction: column;
    align-items: center;
}

.login-logo {
    display: flex;
    margin-bottom: 30px;
    align-items: center;
}

.title {
    font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
    font-size: larger;
    font-weight: 500;
    color: black;
}
</style>