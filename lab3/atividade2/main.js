import Vue from 'vue';
import App from './App.vue';
import router from './router';

Vue.config.productionTip = false;

new Vue({
    render: h => h(App),
    router // Certifique-se de que o Vue Router está sendo usado aqui
}).$mount('#app');
