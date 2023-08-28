import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/components/HomeView.vue';

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
    path: '/'
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
