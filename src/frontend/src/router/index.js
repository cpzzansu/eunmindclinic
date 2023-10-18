import { createRouter, createWebHistory } from "vue-router";
import Login from "@/components/OauthLogin.vue";
import Home from "@/components/user/views/Home.vue";
import UserLogin from "@/components/UserLogin.vue";
import AdminManagement from "@/components/admin/AdminManagement.vue";
import Greeting from "@/components/user/views/Greeting.vue";
import ClinicalDepartments from "@/components/user/views/ClinicalDepartments.vue";
import ClinicHours from "@/components/user/views/ClinicHours.vue";

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
    path: "/adminManagement",
    name: AdminManagement,
    component: AdminManagement,
  },
  // ... other routes if any
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
