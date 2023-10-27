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
            outlined
          />
          <q-input
            v-model="memberPw"
            class="member-pw-input"
            label="비밀번호"
            outlined
            type="password"
          />
          <q-input
            v-model="memberName"
            class="member-pw-input"
            label="이름"
            outlined
          />
          <q-input
            v-model="memberEmail"
            class="member-pw-input"
            label="이메일"
            outlined
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

export default defineComponent({
  components: { NavigationBar, NavigationButtonDiv, FooterDiv },
  setup() {
    const memberId = ref("");
    const memberPw = ref("");
    const memberName = ref("");
    const memberEmail = ref("");
    const addMember = () => {
      let username = memberId.value;
      let password = memberPw.value;
      let name = memberName.value;
      let email = memberEmail.value;

      const data = {
        username: username,
        password: password,
        name: name,
        email: email,
      };
      console.log(data);

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
  margin-bottom: 10px;
}
.member-pw-input {
  margin-bottom: 10px;
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
