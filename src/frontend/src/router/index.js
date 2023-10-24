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
import Detail from "@/components/user/notice/Detail.vue";
import Directions from "@/components/user/views/Directions.vue";
import store from "@/store";

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
          },
        ],
      },
    ],
  },
  { path: "/gallery", name: "Gallery", component: Gallery },
  { path: "/notice", name: "Notice", component: Notice },
  { path: "/detail", name: "detail", component: Detail },
  { path: "/directions", name: "directions", component: Directions },
  // ... other routes if any
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach(async (to, from, next) => {
  next();
});

export default router;
