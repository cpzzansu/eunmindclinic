<template>
  <q-drawer show-if-above v-model="drawerOpen" side="left" bordered>
    <q-list>
      <q-item-label header>Menu</q-item-label>

      <q-item clickable v-ripple to="/page1">
        <q-item-section avatar>
          <q-icon name="home"/>
        </q-item-section>
        <q-item-section>
          Page 1
        </q-item-section>
      </q-item>

      <q-item clickable v-ripple to="/adminManagement">
        <q-item-section avatar>
          <q-icon name="mail"/>
        </q-item-section>
        <q-item-section>
          Page 2
        </q-item-section>
      </q-item>

      <q-item clickable v-ripple to="/page3">
        <q-item-section avatar>
          <q-icon name="map"/>
        </q-item-section>
        <q-item-section>
          Page 3
        </q-item-section>
      </q-item>

      <!-- Add more q-item blocks as needed for additional menu items -->

    </q-list>
  </q-drawer>
</template>

<script>
import {ref, watch} from 'vue'

export default {
  props: {
    value: Boolean
  },
  setup(props, { emit }) {
    const drawerOpen = ref(props.value)

    watch(
        () => props.value,
        (val) => {
          drawerOpen.value = val
        }
    )

    watch(
        drawerOpen,
        (val) => {
          emit('update:value', val)
        }
    )

    return { drawerOpen }
  }
}
</script>
