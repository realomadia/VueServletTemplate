<template>
  <p class="logo"><a href="/">yami</a></p>
</template>

<style scoped>

@font-face {
  font-family: 'KCCMurukmuruk';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCCMurukmuruk.woff2') format('woff2');
  font-weight: normal;
  font-style: normal;
}
.logo{
  font-family: KCCMurukmuruk;
  margin: auto;
  text-align: center;
}
.logo>a{
  text-decoration: none;
  color: #FF4500;
}
</style>

<script>
export default{
  name:"LogoVue"
}
</script>