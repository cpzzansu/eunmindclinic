import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/components/OauthLogin.vue'
import Home from "@/components/user/views/Home.vue";
import UserLogin from "@/components/UserLogin.vue";
import AdminManagement from "@/components/admin/AdminManagement.vue";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: Home,
    component: Home
  },
  {
    path: '/userLogin',
    name: UserLogin,
    component: UserLogin
  },
  {
    path: '/adminManagement',
    name: AdminManagement,
    component: AdminManagement
  }
  // ... other routes if any
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
