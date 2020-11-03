import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '@/views/User/Login.vue';
import Register from '@/views/User/Register.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () => import( '../views/About.vue')
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '/ingredients',
    name: 'Ingredients',
    component: () => import('../views/Ingredient/Ingredients.vue')
  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('@/views/User/Profile.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
