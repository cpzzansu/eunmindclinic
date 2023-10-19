<template>
  <div class="col-10 col-md-8 row publication-btn-div">
    <RouterLink class="menu-link col-3" to="/doctorProfile/academicPublication"
      ><div class="publication-btn row justify-center items-center">
        의학
      </div></RouterLink
    >
    <RouterLink
      class="menu-link col-3"
      to="/doctorProfile/academicPublication/overseasPresentation"
    >
      <div class="publication-btn col-3 row justify-center items-center">
        해외학회 논문 발표
      </div></RouterLink
    >
    <div class="publication-btn col-3 row justify-center items-center">
      경 영 학
    </div>
    <div class="publication-btn col-3 row justify-center items-center">
      저 술
    </div>
  </div>
  <div class="col-10 col-md-8 activities-div">
    <div class="q-pa-md activities-table">
      <q-table
        :columns="columns"
        :pagination="myInitialPagination"
        :rows="rows"
        :rows-per-page-options="[0]"
        hide-header
        hide-pagination
        row-key="id"
      />
    </div>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import DoctorProfileNavigation from "@/components/user/doctor_profile/DoctorProfileNavigation.vue";
const columns = [
  {
    name: "idx",
    align: "left",
    field: (row) => row.id,
    format: (val) => `${val}`,
    style: "width: 45px",
  },
  {
    name: "description",
    align: "left",
    field: (row) => row.description,
  },
];

const rows = [
  { id: 1, description: "대한의사협회(KMA) 정회원" },
  { id: 2, description: "대한의사협회(KMA) 정회원" },
  { id: 3, description: "대한의사협회(KMA) 정회원" },
];

export default defineComponent({
  components: {
    DoctorProfileNavigation,
    NavigationBar,
    NavigationButtonDiv,
    FooterDiv,
  },
  setup() {
    return {
      columns,
      rows,
      myInitialPagination: {
        rowsPerPage: 0,
      },
    };
  },
});
</script>
<style scoped>
.publication-btn-div {
  margin-top: 80px;
}
.activities-div {
  margin-bottom: 156px;
  margin-top: 0px;
  padding: 25px 15px;
  background-color: rgba(240, 246, 242, 1);
}
.activities-table {
  padding: 0px 0px;
  background-color: rgba(240, 246, 242, 1);
  max-height: 564px;
  overflow-y: auto;
}
.activities-table::-webkit-scrollbar {
  width: 7px;
  margin-right: 10px;
}
.activities-table::-webkit-scrollbar-track {
  background: rgba(240, 246, 242, 1);
}
.activities-table::-webkit-scrollbar-thumb {
  background: rgba(21, 71, 38, 0.3);
  border-radius: 8px;
}
.activities-table .q-table__card {
  border-bottom: none;
}
.activities-table .q-table tbody td {
  background-color: rgba(240, 246, 242, 1);
  font-size: 16px;
  font-weight: 400;
  height: 28px;
  padding: 0px 0px 0px 20px;
}
.activities-table .q-table td:first-child {
  font-size: 18px;
  font-weight: 700;
  padding-left: 0px;
}
.publication-btn {
  height: 46px;
  font-size: 18px;
  font-weight: 700;
  background-color: rgba(250, 243, 230, 1);
  color: #333333;
  border-right: 1px rgba(255, 255, 255, 1) solid;
}
.publication-btn:last-child {
  border-right: none;
}
.menu-link {
  text-decoration: none;
}
</style>
