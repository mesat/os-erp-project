import Vue from 'vue'
import App from './App.vue'
import CoreuiVue from '@coreui/vue';
import router from './router'
Vue.use(CoreuiVue);

Vue.config.productionTip = false
Vue.prototype.$log = console.log.bind(console)

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {
    App
  }
})
