import { createApp } from "vue";
import { Quasar } from "quasar";
// Import icon libraries
import "@quasar/extras/material-icons/material-icons.css";
// Import Quasar css
import "quasar/src/css/index.sass";

import App from "./App.vue";
import router from "./router";
import store from "@/store";

const myApp = createApp(App);
myApp.use(router);

myApp.use(Quasar, {
  plugins: {}, // import Quasar plugins and add here
});

myApp.use(store);

// Assumes you have a <div id="app"></div> in your index.html
myApp.mount("#app");
