<template>
  <q-layout view="hHh lpR fFf">

    <page-container>
      <router-view />
    </page-container>

  </q-layout>
</template>

<script>
import UserLogin from "@/components/UserLogin.vue";
export default {
  components: {
    UserLogin
  },
  setup() {
    return {

    }
  }
}
</script>
<style>
body {
  font-family: "Noto Sans KR","Apple SD Gothic Neo", sans-serif ;
}
</style>
