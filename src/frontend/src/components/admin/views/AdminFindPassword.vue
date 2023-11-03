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
            outlined
          />
          <q-input
            v-model="memberEmail"
            class="member-pw-input"
            type="email"
            label="이메일"
            outlined
          />
          <q-btn
            label="인증번호 전송"
            outline
            style="color: #149473; height: 50px; margin-bottom: 10px"
            @click="findPassword"
          />
        </div>
      </div>
    </div>
    <q-dialog v-model="medium">
      <q-card style="width: 700px; max-width: 80vw">
        <q-card-section>
          <div class="q-pa-md">
            <div class="text-h6">이메일 인증번호 입력</div>
          </div>
        </q-card-section>

        <q-card-section>
          <div class="q-pa-md">
            <input
              v-model="verificationInput"
              class="notice-title-input"
              placeholder="인증번호를 입력하세요."
            />
          </div>
        </q-card-section>
        <q-card-actions align="right" class="bg-white text-teal">
          <q-btn
            flat
            color="red"
            label="취소"
            v-close-popup
            @click="verificationCancle"
          />
          <q-btn flat label="등록" @click="verificationCheck" />
        </q-card-actions>
      </q-card>
    </q-dialog>
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

    const findId = ref("");
    const memberEmail = ref("");
    const medium = ref(false);
    const verificationCode = ref("");
    const verificationInput = ref("");

    const checkEnterKey = (event) => {
      // keyCode 13은 엔터 키를 의미
      if (event.keyCode === 13) {
        findPassword();
      }
    };

    onMounted(() => {
      window.addEventListener("keyup", checkEnterKey);
    });

    onBeforeUnmount(() => {
      window.removeEventListener("keyup", checkEnterKey);
    });

    const findPassword = async () => {
      const data = {
        username: findId.value,
        email: memberEmail.value,
      };

      const response = await axios.post("/memberFindPassword", data);

      const message = response.data.message;

      verificationCode.value = response.data.verificationCode;

      if (message === "1") {
        alert("아이디가 존재하지 않습니다.");
      } else if (message === "2") {
        alert("회원가입시 등록한 이메일 주소와 다릅니다.");
      } else if (message === "3") {
        medium.value = true;
        const response = await axios.post("/emailSend", {
          email: memberEmail.value,
          verificationCode: verificationCode.value,
        });
      }
    };

    const verificationCancle = () => {
      verificationInput.value = "";
    };

    const verificationCheck = () => {
      if (verificationInput.value == verificationCode.value) {
        sessionStorage.setItem("username", findId.value);
        router.push("/changePassword");
      } else {
        alert("인증번호가 틀렸습니다.");
      }
    };

    return {
      findId,
      memberEmail,
      findPassword,
      medium,
      verificationInput,
      verificationCode,
      verificationCancle,
      verificationCheck,
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
