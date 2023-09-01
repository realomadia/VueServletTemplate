<template>
  <section class="wrapper">
    <div class="register-logo">
      <LogoVue></LogoVue>
    </div>
    <div class="input-box">
      <div class="input-set">
        <span class="set-title">아이디</span>
        <span class="set-content">
          <div class="id-div">
            <input v-model="id" type="text" placeholder="8~16자 영문/숫자 조합" class="id">
            <input @click="idCheckMethod" type="button" value="중복확인" class="id-check-btn">
          </div>
        </span>
        <div class="message-set">
          <span class="message-blank"></span>
          <span class="message" :class="{ 'green-text': idCheck, 'red-text': !idCheck }">{{ idMessage }}</span>
        </div>
      </div>
      <div class="input-set">
        <span class="set-title">비밀번호</span>
        <span class="set-content">
          <div class="id-div">
            <input v-model="password" type="password" placeholder="8자이상 영문 대소문자/숫자/특수문자 조합" class="inputs">
          </div>
        </span>
        <div class="message-set">
          <span class="message-blank"></span>
          <span class="message" :class="{ 'green-text': passwordCheck, 'red-text': !passwordCheck }">{{ passwordMessage }}</span>
        </div>
      </div>
      <div class="input-set">
        <span class="set-title">이름</span>
        <span class="set-content">
          <div class="id-div">
            <input v-model="name" type="text" placeholder="이름을 입력하세요." class="inputs">
          </div>
        </span>
        <div class="message-set">
          <span class="message-blank"></span>
          <span class="message"></span>
        </div>
      </div>
      <div class="input-set">
        <span class="set-title">닉네임</span>
        <span class="set-content">
          <div class="id-div">
            <input v-model="nickname" type="text" placeholder="닉네임을 입력 하세요." class="inputs">
          </div>
        </span>
        <div class="message-set">
          <span class="message-blank"></span>
          <span class="message">{{ nicknameMessage }}</span>
        </div>
      </div>
      <div class="input-set">
        <span class="set-title">E-mail</span>
        <span class="set-content">
          <div class="id-div">
            <input v-model="email" type="text" placeholder="이메일을 입력 하세요." class="inputs">
          </div>
        </span>
        <div class="message-set">
          <span class="message-blank"></span>
          <span class="message" :class="{ 'green-text': emailCheck, 'red-text': !emailCheck }">{{ emailMessage }}</span>
        </div>
      </div>
      <div class="input-set">
        <span class="set-title">생년월일</span>
        <span class="set-content">
          <div class="id-div">
            <input v-model="birth" type="date" placeholder="이메일을 입력 하세요." class="inputs">
          </div>
        </span>
        <div class="message-set">
          <span class="message-blank"></span>
          <span class="message"></span>
        </div>
      </div>
      <div class="input-set">
        <span class="set-title">성별</span>
        <span class="set-content">
          남 <input v-model="gender" type="radio" name="gender" value="남"> 여 <input type="radio" name="gender" value="여">
        </span>
      </div>
    </div>
    <div class="btn_wrapper">
      <button class="custom-button inputs" @click="register">회원가입</button>
    </div>
  </section>




</template>

<script>
import LogoVue from "@/components/LogoView.vue";

export default {
  data() {
    return {
      id : "",
      password : "",
      name : "",
      nickname : "",
      email : "",
      birth : "",
      gender : "",
      idCheck : false,
      nicknameCheck : false,
      emailCheck : false,
      passwordCheck : false,
      idMessage : "",
      passwordMessage : "",
      nicknameMessage : "",
      emailMessage : "",
    }
  },
  components: {
    LogoVue
  },
  inject: ['$http'],
  methods: {
    async idCheckMethod() {
      let data = {};
      data.id = this.id;
      if(!this.$validator.isAlphanumeric(data.id)){
        this.idCheck = false;
        this.idMessage = "영어와 숫자만 입력하세요.";
        return;
      }
      const responseData = await this.$http.post('checkId',data);
      if(responseData.data.code == 200){
        this.idCheck = true;
        this.idMessage = responseData.data.message;
      }
    },
    async register() {
      let data = {};
      data.id = this.id;
      data.password = this.password;
      data.name = this.name;
      data.nickname = this.nickname;
      data.email = this.email;
      data.birth = this.birth;
      data.gender = this.gender;
      let validCheck = await this.checkRegisterData(data);
      if(validCheck){
        const responseData = await this.$http.post('register',data);
        if(responseData.data.code == 200){
          location.href = "/";
        }else{
          alert(responseData.data.message)
        }
      }
    },
    async checkRegisterData(data) {
          if(!this.$validator.isEmail(data.email)){
            this.emailMessage = "틀린 이메일 형식 입니다.";
            this.emailCheck = false;
          }else{
            this.emailCheck = true;
        this.emailMessage = "";
      }
      if(!this.$validator.isAlphanumeric(data.id)){
        this.idCheck = false;
        this.idMessage = "영어와 숫자만 입력하세요.";
      }else{
        this.idCheck = true;
        this.idMessage = "사용 가능한 아이디 입니다.";
      }
      if(!this.$validator.isLength(data.password, { min: 8 })){
        this.passwordCheck = false;
        this.passwordMessage = "8~16자 영문 대소문자/숫자/특수문자 조합"
      }
      if(!this.passwordCheck){
        let hasUppercase = /[A-Z]/.test(data.password);
        let hasLowercase = /[a-z]/.test(data.password);
        let hasNumber = /[0-9]/.test(data.password);
        let hasSpecialCharacter = /[!@#$%^&*()_+{}[\]:;<>,.?~\\/-]/.test(data.password);
        let isPasswordValid = hasUppercase && hasLowercase && hasNumber && hasSpecialCharacter;

        if(!isPasswordValid){
          this.passwordCheck = false;
          this.passwordMessage = "8~16자 영문 대소문자/숫자/특수문자 조합"
        }else{
          this.passwordCheck = true;
          this.passwordMessage = "";
        }
      }

      let emptyValidator = false;
      for(let i in data){
        emptyValidator = this.$validator.isEmpty(data[i]);
        emptyValidator = !emptyValidator;
        if(!emptyValidator)break;
      }

      data.id = this.id;
      data.password = this.password;
      data.name = this.name;
      data.nickname = this.nickname;
      data.email = this.email;
      data.birth = this.birth;
      data.gender = this.gender;
      if(this.idCheck && this.passwordCheck && this.emailCheck && emptyValidator){
        return true;
      }else{
        return false;
      }


    }
  }

}
</script>
<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.register-logo{
  margin-top: 70px;
  margin-bottom: 70px;
  font-size: 85px;
  font-weight: bolder;

}
.wrapper{
  width: 100%;
  margin:auto;
}
.wrapper>.register-logo{
  font-size: 55px;
  font-weight: bolder;
}

.wrapper>.input-box{
  width: 80%;
  margin: auto;
}
.wrapper>.input-box>.input-set{
  width: 80%;
  margin: auto;
}
.wrapper>.input-box>.input-set>.set-title{
  display: inline-block;
  text-align: left;
  font-weight: bolder;
  width: 30%;
}
.wrapper>.input-box>.input-set>.set-content{
  display: inline-block;
  width: 70%;
  height: 25px;
}

.id-div {
  width: 100%;
  display: inline-block;
  border: solid 1px black;
  font-size: 9pt;
  border-radius: 3px;
}
.id {
  background-color: transparent;
  padding: 5px;
  border: 0;
  font-size: 9pt;
  width: 75%;
  border-radius: 3px;
}
.id:focus{
  outline: none;
}

.id::placeholder{
  color: lightgray;
}
.inputs::placeholder{
  color: lightgray;
}
.id-check-btn {
  float: right;
  border-radius: 3px;
  background-color: #FF4500;
  width: 25%;
  height: 100%;
  padding: 5px 0px;
  border: solid 1px #6699ff;
  color: white;
  font-size: 5pt;
  cursor: pointer;
}

.inputs{
  background-color: transparent;
  padding: 5px;
  border: 0;
  font-size: 9pt;
  width: 100%;
  border-radius: 3px;
}
.btn_wrapper{
  text-align: center;
  margin-top:100px;
}
.btn_wrapper>.custom-button{
  background: #FF4500;
  color: white;
  border-radius: 5px;
  border:1px solid rgba(38, 38, 38, 0.49);
  font-size: 18px;
  width: 65%;
  cursor: pointer;
}
.message-set{
  width: 100%;
}
.message{
  font-size: 10px;
  width: 70%;
  display: inline-block;
}
.message-blank{
  width: 30%;
  display: inline-block;
}
.red-text {
  color: red;
}

.green-text {
  color: green;
}
</style>