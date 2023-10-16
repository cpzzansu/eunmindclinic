<template>
  <q-toolbar>
    <q-btn dense flat round icon="menu" @click="$emit('toggle-drawer')"/>
    <q-toolbar-title>
      <q-avatar>
        <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg">
      </q-avatar>
      Title
    </q-toolbar-title>
  </q-toolbar>
</template>
