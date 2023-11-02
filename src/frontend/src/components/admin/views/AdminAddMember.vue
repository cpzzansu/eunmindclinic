<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          관리자 회원가입 신청
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
            lazy-rules
            :rules="[(val) => !!val || '아이디는 필수 입력사항입니다.']"
            outlined
          />
          <q-input
            v-model="memberPw"
            class="member-pw-input"
            label="비밀번호"
            outlined
            lazy-rules
            :rules="[(val) => !!val || '비밀번호는 필수 입력사항입니다.']"
            type="password"
          />
          <q-input
            v-model="memberName"
            class="member-pw-input"
            label="이름"
            lazy-rules
            :rules="[(val) => !!val || '이름은 필수 입력사항입니다.']"
            outlined
          />
          <q-input
            v-model="memberEmail"
            class="member-pw-input"
            label="이메일"
            outlined
            lazy-rules
            :rules="[(val) => !!val || '이메일은 필수 입력사항입니다.']"
            type="email"
          />
          <q-btn
            label="회원가입 신청"
            outline
            style="color: #149473; height: 50px; margin-bottom: 10px"
            @click="addMember"
          />
        </div>
      </div>
    </div>

    <FooterDiv></FooterDiv>
  </div>
</template>
<script>
import { defineComponent, ref } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import axios from "axios";
import { useQuasar } from "quasar";

export default defineComponent({
  components: { NavigationBar, NavigationButtonDiv, FooterDiv },
  setup() {
    const $q = useQuasar();
    const memberId = ref(null);
    const memberPw = ref(null);
    const memberName = ref(null);
    const memberEmail = ref(null);

    const validate = (input) => {
      if (input == "" || input == undefined || input == null) {
        return true;
      }
    };

    const addMember = () => {
      let username = memberId.value;
      let password = memberPw.value;
      let name = memberName.value;
      let email = memberEmail.value;

      const idValidate = validate(username);
      const passwordValidate = validate(password);
      const nameValidate = validate(name);
      const emailValidate = validate(email);

      if (idValidate || passwordValidate || nameValidate || emailValidate) {
        alert("모든 정보는 필수 입력사항입니다.");
        return;
      }

      const data = {
        username: username,
        password: password,
        name: name,
        email: email,
      };

      axios
        // .post("http://localhost:8080/adminAddMember", data)
        .post("/adminAddMember", data)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    };
    return {
      memberId,
      memberPw,
      memberName,
      memberEmail,
      addMember,
    };
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
  color: #333333;
  margin-bottom: 100px;
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
}
.member-pw-input {
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
