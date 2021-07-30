import Vue from 'vue'
import App from './App.vue'
import CoreuiVue from '@coreui/vue'
import { iconsSet as icons } from './assets/icons/icons.js'
import router from './router'
Vue.use(CoreuiVue);

Vue.config.productionTip = false
Vue.prototype.$log = console.log.bind(console)

new Vue({
  el: '#app',
  router,
  icons,
  template: '<App/>',
  components: {
    App
  }
})
