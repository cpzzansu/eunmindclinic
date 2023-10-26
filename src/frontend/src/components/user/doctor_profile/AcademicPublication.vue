<template>
  <div class="col-10 col-md-8">
    <div class="row publication-btn-div">
      <RouterLink
        class="menu-link col-3"
        to="/doctorProfile/academicPublication"
        ><div
          :class="{
            'active-link': $route.path === '/doctorProfile/academicPublication',
          }"
          class="publication-btn row justify-center items-center"
        >
          의학
        </div></RouterLink
      >
      <RouterLink
        v-slot="{ isActive }"
        class="menu-link col-3"
        to="/doctorProfile/academicPublication/overseasPresentation"
      >
        <div
          :class="{ 'active-link': isActive }"
          class="publication-btn col-3 row justify-center items-center"
        >
          해외학회 논문 발표
        </div></RouterLink
      >
      <RouterLink
        v-slot="{ isActive }"
        class="menu-link col-3"
        to="/doctorProfile/academicPublication/mba"
      >
        <div
          :class="{ 'active-link': isActive }"
          class="publication-btn col-3 row justify-center items-center"
        >
          경 영 학
        </div>
      </RouterLink>
      <RouterLink
        v-slot="{ isActive }"
        class="menu-link col-3"
        to="/doctorProfile/academicPublication/pubs"
      >
        <div
          :class="{ 'active-link': isActive }"
          class="publication-btn col-3 row justify-center items-center"
        >
          저 술
        </div>
      </RouterLink>
    </div>
    <div v-if="!hasChildRoute" class="col-10 col-md-8 activities-div">
      <div class="q-pa-md activities-table">
        <q-table
          :columns="columns"
          :pagination="myInitialPagination"
          :rows="rows"
          :rows-per-page-options="[0]"
          hide-header
          hide-pagination
          row-key="id"
        >
          <template v-slot:body-cell-medicalPublication="props">
            <q-td
              :props="props"
              style="word-wrap: break-word; white-space: normal"
            >
              {{ props.row.medicalPublication }}
            </q-td>
          </template>
        </q-table>
      </div>
    </div>
    <RouterView></RouterView>
  </div>
</template>
<script>
import { computed, defineComponent, onMounted, ref } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import DoctorProfileNavigation from "@/components/user/doctor_profile/DoctorProfileNavigation.vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

export default defineComponent({
  components: {
    DoctorProfileNavigation,
    NavigationBar,
    NavigationButtonDiv,
    FooterDiv,
  },
  setup() {
    const route = useRoute();
    const store = useStore();
    const medical = ref([]);

    const hasChildRoute = computed(() => {
      return route.path !== "/doctorProfile/academicPublication";
    });

    onMounted(() => {
      medical.value = store.state.medical;
    });

    const columns = [
      {
        name: "idx",
        align: "left",
        field: (row) => row.id,
        format: (val) => `${val}`,
        style: "width: 45px; vertical-align: top;",
      },
      {
        name: "medicalPublication",
        align: "left",
        field: (row) => row.medicalPublication,
      },
    ];

    const rows = computed(() => medical.value);

    return {
      medical,
      columns,
      rows,
      myInitialPagination: {
        rowsPerPage: 0,
      },
      hasChildRoute,
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
  color: #149473;
}
.publication-btn {
  height: 46px;
  font-size: 18px;
  font-weight: 700;
  background-color: rgba(250, 243, 230, 1);
  color: #333333;
  border-right: 1px rgba(255, 255, 255, 1) solid;
}
.active-link.publication-btn {
  background-color: #149473;
  color: #ffffff;
}
.publication-btn:last-child {
  border-right: none;
}
.menu-link {
  text-decoration: none;
}
</style>
