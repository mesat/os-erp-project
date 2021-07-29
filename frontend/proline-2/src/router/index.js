import Vue from 'vue'
import Router from 'vue-router'

const TheContainer = () => import('@/containers/TheContainer')

export default new Router({
    mode: 'hash', // https://router.vuejs.org/api/#mode
    linkActiveClass: 'active',
    scrollBehavior: () => ({ y: 0 }),
    routes: configRoutes()
})

Vue.use(Router)

function configRoutes () {
    return [
        {
            path: '/',
            name: 'Home',
            component: TheContainer
        }
    ]
}