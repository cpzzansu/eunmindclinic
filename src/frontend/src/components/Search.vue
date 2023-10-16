<template>
  <div class="q-pa-md">
    <div class="q-gutter-md row items-start">
      <q-input v-model="email" filled type="email" hint="Email" />

      <q-input v-model="search" filled type="search" hint="Search">
        <template v-slot:append>
          <q-icon name="search" />
        </template>
      </q-input>

      <q-input v-model="tel" filled type="tel" hint="Telephone number" />

      <q-input v-model="url" filled type="url" hint="URL" />

      <q-input v-model="time" filled type="time" hint="Native time" />

      <q-input v-model="date" filled type="date" hint="Native date" />
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  props: {
    searchQuery: {
      type: String,
      default: ''
    }
  },
  setup (props) {
    return {
      email: ref(''),
      search: ref(''),
      tel: ref(''),
      url: ref(''),
      time: ref(''),
      date: ref('')
    }
  }
}
</script>
