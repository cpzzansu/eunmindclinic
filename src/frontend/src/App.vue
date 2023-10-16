<template>
  <q-layout view="hHh lpR fFf">

    <header-component>
      <toolbar @toggle-drawer="toggleLeftDrawer"/>
    </header-component>

    <drawer v-model="leftDrawerOpen"/>

    <page-container>
      <router-view/>
      <UserLogin />
    </page-container>

  </q-layout>
</template>

<script>
import { ref } from 'vue'
import HeaderComponent from '@/components/Header.vue'
import Toolbar from '@/components/Toolbar.vue'
import Drawer from '@/components/Drawer.vue'
import PageContainer from '@/components/PageContainer.vue'
import UserLogin from "@/components/UserLogin.vue";

export default {
  components: {
    HeaderComponent,
    Toolbar,
    Drawer,
    PageContainer,
    UserLogin
  },
  setup() {
    const leftDrawerOpen = ref(false)
    return {
      leftDrawerOpen,
      toggleLeftDrawer() {
        leftDrawerOpen.value = !leftDrawerOpen.value
      }
    }
  }
}
</script>
