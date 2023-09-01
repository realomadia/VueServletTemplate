import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/components/HomeView.vue';
import RegisterView from '@/components/RegisterView.vue';
const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    component: HomeView
    // children: [
    //   {
    //     path: '/class',
    //     component: classView
    //   }
    // ]
  },
  {
    path: '/register',
    component: RegisterView
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
