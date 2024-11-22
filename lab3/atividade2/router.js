import Vue from 'vue';
import Router from 'vue-router';
import Create from './components/Create.vue';   // Importar o componente de Create
import Read from './components/Read.vue';       // Importar o componente de Read
import Update from './components/Update.vue';   // Importar o componente de Update
import Delete from './components/Delete.vue';   // Importar o componente de Delete

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'home',
            component: Create   // Página inicial (pode ser Create)
        },
        {
            path: '/create',
            name: 'create',
            component: Create   // Página de criação
        },
        {
            path: '/read',
            name: 'read',
            component: Read     // Página de leitura
        },
        {
            path: '/update',
            name: 'update',
            component: Update   // Página de atualização
        },
        {
            path: '/delete',
            name: 'delete',
            component: Delete   // Página de exclusão
        }
    ]
});
