<template>
  <div class="home_logo">
    <LogoVue></LogoVue>
  </div>
  <div class="input-box">
    <input class="custom-input inputs" type="text" placeholder="아이디를 입력하세요.">
    <input class="custom-input inputs" type="password" placeholder="비밀번호를 입력하세요.">
    <button @click="register" class="custom-button inputs">로그인</button>
    <div class="custom-forgot inputs"> <a href="#">아이디 찾기</a> | <a href="#">비밀번호 찾기</a></div>

    <div class="custom-register inputs"><a href="register">계정이 없으신가요?</a></div>

  </div>

</template>

  <script>
    import LogoVue from "@/components/LogoView.vue";

    export default {
      components: {
        LogoVue
      },
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
          const registerData = await this.$http.get('register',data);
          console.log(registerData.data);
        },
      }
  }
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.home_logo{
  margin-top: 70px;
  margin-bottom: 70px;
  font-size: 85px;
  font-weight: bolder;
}
.input-box{
  margin: auto;
  width: 80%;
}
.input-box>.inputs{
  width: 100%;
}
.input-box>.custom-input{
  border: 1px solid darkgray;
  padding: 3px 3px 3px 30px;
  border-radius: 7px;
  margin-bottom: 10px;
}
.input-box>.custom-input:nth-child(1){
  background-image : url('../assets/img/user.png');
  background-repeat : no-repeat;
  background-size: 23px;
}
.input-box>.custom-input:nth-child(2){
  background-image : url('../assets/img/password.png');
  background-repeat : no-repeat;
  background-size: 18px;
}
.input-box>.custom-button{
  background: #FF4500;
  color: white;
  border-radius: 5px;
  border:1px solid rgba(38, 38, 38, 0.49);
  font-size: 18px;
  cursor: pointer;
}
.input-box>.custom-forgot{
  margin-top: 10px;
  font-size: 10px;
  text-align: center;
}
.input-box>.custom-forgot>a{
  text-decoration: none;
  color: black;
  cursor: pointer;
}

.input-box>.custom-register{
  margin-top: 50px;
  text-align: center;
}
.input-box>.custom-register>a{
  font-size: 15px;
  font-weight: 600;
  color: lightgray;
  cursor: pointer;
}


</style>


