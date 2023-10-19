import { createRouter, createWebHistory } from "vue-router";
import Home from "@/components/user/views/Home.vue";
import Greeting from "@/components/user/views/Greeting.vue";
import ClinicalDepartments from "@/components/user/views/ClinicalDepartments.vue";
import ClinicHours from "@/components/user/views/ClinicHours.vue";
import DoctorProfile from "@/components/user/views/DoctorProfile.vue";
import AcademicActivities from "@/components/user/doctor_profile/AcademicActivities.vue";
import AcademicPublication from "@/components/user/doctor_profile/AcademicPublication.vue";
import OverseasPresentation from "@/components/user/doctor_profile/OverseasPresentation.vue";

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
      },
      {
        path: "academicPublication",
        name: "AcademicPublication",
        component: AcademicPublication,
        children: [
          {
            path: "overseasPresentation",
            name: "OverseasPresentation",
            component: OverseasPresentation,
          },
        ],
      },
    ],
  },
  // ... other routes if any
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
