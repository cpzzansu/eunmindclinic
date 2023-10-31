import { createRouter, createWebHistory } from "vue-router";
import Home from "@/components/user/views/Home.vue";
import Greeting from "@/components/user/views/Greeting.vue";
import ClinicalDepartments from "@/components/user/views/ClinicalDepartments.vue";
import ClinicHours from "@/components/user/views/ClinicHours.vue";
import DoctorProfile from "@/components/user/views/DoctorProfile.vue";
import AcademicActivities from "@/components/user/doctor_profile/AcademicActivities.vue";
import AcademicPublication from "@/components/user/doctor_profile/AcademicPublication.vue";
import OverseasPresentation from "@/components/user/doctor_profile/OverseasPresentation.vue";
import MasterOfBusinessAdministration from "@/components/user/doctor_profile/MasterOfBusinessAdministration.vue";
import PublishedWorks from "@/components/user/doctor_profile/PublishedWorks.vue";
import Gallery from "@/components/user/views/Gallery.vue";
import Notice from "@/components/user/views/Notice.vue";
import Directions from "@/components/user/views/Directions.vue";
import store from "@/store";
import NoticeDetail from "@/components/user/views/NoticeDetail.vue";
import AdminLogin from "@/components/admin/views/AdminLogin.vue";
import AdminHome from "@/components/admin/views/AdminHome.vue";
import AdminAddMember from "@/components/admin/views/AdminAddMember.vue";
import axios from "axios";
import AdminGallery from "@/components/admin/views/AdminGallery.vue";
import AdminNotice from "@/components/admin/views/AdminNotice.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/greeting",
    name: "Greeting",
    component: Greeting,
  },
  {
    path: "/clinicalDepartments",
    name: "ClinicalDepartments",
    component: ClinicalDepartments,
  },
  {
    path: "/clinicHours",
    name: "ClinicHours",
    component: ClinicHours,
  },
  {
    path: "/doctorProfile",
    name: "DoctorProfile",
    component: DoctorProfile,
    children: [
      {
        path: "academicActivities",
        name: "AcademicActivities",
        component: AcademicActivities,
        beforeEnter: async (to, from, next) => {
          try {
            await store.dispatch("fetchActivities");
            next();
          } catch (error) {
            console.log("Error fetching data: ", error);
            next(false);
          }
        },
      },
      {
        path: "academicPublication",
        name: "AcademicPublication",
        component: AcademicPublication,
        beforeEnter: async (to, from, next) => {
          try {
            await store.dispatch("fetchMedical");
            next();
          } catch (error) {
            console.log("Error fetching data: ", error);
            next(false);
          }
        },
        children: [
          {
            path: "overseasPresentation",
            name: "OverseasPresentation",
            component: OverseasPresentation,
            beforeEnter: async (to, from, next) => {
              try {
                await store.dispatch("fetchOverseasPresent");
                next();
              } catch (error) {
                console.log("Error fetching data: ", error);
                next(false);
              }
            },
          },
          {
            path: "mba",
            name: "masterOfBusinessAdministration",
            component: MasterOfBusinessAdministration,
            beforeEnter: async (to, from, next) => {
              try {
                await store.dispatch("fetchMba");
                next();
              } catch (error) {
                console.log("Error fetching data: ", error);
                next(false);
              }
            },
          },
          {
            path: "pubs",
            name: "publishedWorks",
            component: PublishedWorks,
            beforeEnter: async (to, from, next) => {
              try {
                await store.dispatch("fetchPubs");
                next();
              } catch (error) {
                console.log("Error fetching data: ", error);
                next(false);
              }
            },
          },
        ],
      },
    ],
  },
  { path: "/gallery", name: "Gallery", component: Gallery },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
    beforeEnter: async (to, from, next) => {
      try {
        await store.dispatch("fetchNoticeBoardList");
        next();
      } catch (error) {
        console.log("Error fetching data: ", error);
        next(false);
      }
    },
  },
  { path: "/detail/:id", name: "detail", component: NoticeDetail },
  { path: "/directions", name: "directions", component: Directions },
  {
    path: "/admin",
    name: "adminLogin",
    component: AdminLogin,
  },
  {
    path: "/adminAddMember",
    name: "adminAddMember",
    component: AdminAddMember,
  },
  {
    path: "/adminHome",
    name: "adminHome",
    component: AdminHome,
    meta: { requiresAuth: true },
    children: [
      {
        path: "gallery",
        name: "adminGallery",
        component: AdminGallery,
        meta: { requiresAuth: true },
      },
      {
        path: "notice",
        name: "adminNotice",
        component: AdminNotice,
        meta: { requiresAuth: true },
      },
    ],
  },
  // ... other routes if any
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach(async (to, from, next) => {
  const token = localStorage.getItem("accessToken");

  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (token) {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;

      try {
        const response = await axios.get("/api/auth/private");

        console.log(response);
        if (response.status === 200) {
          next();
        } else {
          next("/admin");
        }
      } catch (error) {
        console.log(error);
        next("/admin");
      }
    } else {
      next("/admin");
    }
  } else {
  }

  next();
});

export default router;
