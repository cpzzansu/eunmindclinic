<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          비밀번호 찾기
        </div>
      </div>
    </div>
    <div class="main-content row justify-center">
      <div class="q-pa-md col-3">
        <div class="q-gutter-y-md column">
          <q-input
            v-model="findId"
            class="member-id-input"
            label="아이디"
            readonly
            outlined
          />
          <q-input
            v-model="changePasswordInput"
            class="member-pw-input"
            type="password"
            label="변경할 비밀번호를 입력하세요."
            outlined
          />
          <q-btn
            label="비밀번호 변경하기"
            outline
            style="color: #149473; height: 50px; margin-bottom: 10px"
            @click="changePassword"
          />
        </div>
      </div>
    </div>
    <FooterDiv></FooterDiv>
  </div>
</template>
<script>
import { defineComponent, onBeforeUnmount, onMounted, ref } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import axios from "axios";
import { useRouter } from "vue-router";

export default defineComponent({
  components: { NavigationBar, NavigationButtonDiv, FooterDiv },
  setup() {
    const router = useRouter();

    const findId = ref("");
    const changePasswordInput = ref("");

    const checkEnterKey = (event) => {
      // keyCode 13은 엔터 키를 의미
      if (event.keyCode === 13) {
        changePassword();
      }
    };

    onMounted(() => {
      window.addEventListener("keyup", checkEnterKey);
      findId.value = sessionStorage.getItem("username");
    });

    onBeforeUnmount(() => {
      window.removeEventListener("keyup", checkEnterKey);
    });

    const changePassword = async () => {
      const data = {
        username: findId.value,
        password: changePasswordInput.value,
      };

      const response = await axios.post("/memberChangePassword", data);

      router.push("/admin");

      response.catch((error) => {
        console.log(error);
      });
    };

    return {
      findId,
      changePasswordInput,
      changePassword,
    };
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
  height: 400px;
  color: #333333;
}
.main-banner-sentence {
  font-weight: 700;
  font-size: 38px;
  color: #ffffff;
  margin-top: 85px;
  margin-bottom: 27px;
}
.main-banner-div {
  background-image: url("/images/main-banner.png");
  background-position: center;
  background-size: cover;
  height: 330px;
}
.member-id-input {
  margin-bottom: 10px;
}
.member-pw-input {
  margin-bottom: 10px;
}
.side-bar {
  margin: 0px 10px;
}
.non-deco {
  text-decoration: none;
  color: #333333;
}
.notice-title-input {
  border: none;
  color: #333333;
  font-size: 25px;
  width: 100%;
  margin-bottom: 15px;
}
.notice-title-input:focus {
  outline: none;
}
@media (max-width: 580px) {
  .main-banner-div {
    height: 250px;
  }
  .main-banner-sentence {
    margin-top: 46px;
    margin-bottom: 8px;
  }
}
</style>
