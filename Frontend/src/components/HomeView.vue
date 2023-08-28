<template>
    <h1>HomeView 웰컴</h1>
  <input v-model="id" type="text" placeholder="아이디"><br>
  <input v-model="password" type="password" placeholder="비밀번호"><br>
  <input v-model="phone" type="text" placeholder="전화번호"><br>
  <button type="button" @click="register">제출</button>
  </template>
  <style>

  </style>

  <script>
  export default {
    data(){
      return{
        id : "",
        password : "",
        phone : "",
      }
    },
    created(){
    },
    inject: ['$http'],
    methods: {
      async register() {
        let data = {};
        data.id = this.id;
        data.password = this.password;
        data.phone = this.phone;
        const registerData = await this.$http.post('register',data);
        console.log(registerData.data);
      },
    }
  }
</script>

