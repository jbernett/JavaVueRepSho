import Vue from 'vue';
import App from './App.vue';
import {BootstrapVue, BootstrapVueIcons} from 'bootstrap-vue';
import { ValidationProvider, ValidationObserver  } from 'vee-validate/dist/vee-validate.full.esm';
import store from './store';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import router from './router'

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.component('validation-provider', ValidationProvider );
Vue.component('ValidationObserver', ValidationObserver );
Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
