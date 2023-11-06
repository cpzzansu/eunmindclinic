<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          관리자 로그인
        </div>
      </div>
    </div>
    <div class="main-content row justify-center">
      <div class="q-pa-md col-3">
        <div class="q-gutter-y-md column">
          <q-input
            v-model="memberId"
            class="member-id-input"
            label="아이디"
            outlined
          />
          <q-input
            v-model="memberPw"
            class="member-pw-input"
            type="password"
            label="비밀번호"
            outlined
          />
          <q-btn
            label="로그인"
            outline
            style="color: #149473; height: 50px; margin-bottom: 10px"
            @click="login"
          />
          <div class="row justify-center">
            <RouterLink class="non-deco" to="/AdminAddMember">
              회원가입</RouterLink
            >
            <div class="side-bar">|</div>
            <div @click="findPassword">비밀번호찾기</div>
          </div>
        </div>
      </div>
    </div>
    <RouterView></RouterView>
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

    const memberId = ref("");
    const memberPw = ref("");

    const checkEnterKey = (event) => {
      // keyCode 13은 엔터 키를 의미
      if (event.keyCode === 13) {
        login();
      }
    };

    onMounted(() => {
      window.addEventListener("keyup", checkEnterKey);
    });

    onBeforeUnmount(() => {
      window.removeEventListener("keyup", checkEnterKey);
    });

    const login = () => {
      const data = {
        usernameOrEmail: memberId.value,
        password: memberPw.value,
      };

      axios
        // .post("http://localhost:8080/api/auth/login", data)
        .post("/api/auth/login", data)
        .then((response) => {
          const accessToken = response.data.accessToken;
          localStorage.setItem("accessToken", accessToken);
          sessionStorage.setItem("memberId", memberId.value);
          router.push("/adminHome");
        })
        .catch((error) => {
          console.log(error);
          localStorage.removeItem("accessToken");
        });
    };

    const findPassword = () => {
      router.push("/findPassword");
    };

    return {
      memberId,
      memberPw,
      login,
      findPassword,
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
