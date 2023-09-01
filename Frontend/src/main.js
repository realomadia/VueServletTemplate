import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import axios from '@/api/http';
import validator from 'validator';

const app = createApp(App);

app.config.productionTip = false;

app.provide('$http', axios); // axios 인스턴스를 할당

app.config.globalProperties.$validator = validator;

app.use(router);

app.mount('#app');
