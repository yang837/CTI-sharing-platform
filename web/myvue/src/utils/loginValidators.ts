import { reactive } from 'vue'

// 登录数据类型匹配
interface User {
    username: string;
    password: string;
}

// 登录表单
export const loginUser = reactive<User>({
    username: '',
    password: ''
})

// 校验规则数据类型匹配
interface Rules {
    username: {
        required: boolean;
        message: string;
        trigger: string;
    }[];
    password: ({
        required: boolean;
        message: string;
        trigger: string;
        min?: undefined;
        max?: undefined;
    } | {
        min: number;
        max: number;
        message: string;
        trigger: string;
        required?: undefined;
    })[];
}

// 校验规则
export const rules = reactive<Rules>({
    username: [
        {
            required: true,
            message: '用户名不能为空',
            trigger: 'blur'
        }
    ],
    password: [
        { required: true, message: '密码不能为空', trigger: 'blur' },
        { min: 6, max: 30, message: '密码长度必须在6到30之间', trigger: 'blur' }
    ]
})