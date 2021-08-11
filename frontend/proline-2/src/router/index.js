import Vue from 'vue'
import Router from 'vue-router'

const TheContainer = () => import('@/containers/TheContainer')
const NewEmployee = () => import('@/views/NewEmployee')
const EmployeeTable = () => import('@/views/EmployeeTable')
const EmployeeView = () => import('@/views/EmployeeView')
const CreateTeam = () => import('@/views/CreateTeam')
const VueTest = () => import('@/views/VueTest')
const CreateSocial = () => import('@/views/CreateSocial')


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
            component: TheContainer,
            children: [
                {
                    path: 'new',
                    name: 'NewEmployee',
                    component: NewEmployee
                },{
                    path: 'table',
                    name: 'EmployeeTable',
                    component: EmployeeTable
                },
                {
                    path: 'view/:id',
                    name: 'EmployeeView',
                    component: EmployeeView
                },
                {
                    path: 'teams',
                    name: 'CreateTeam',
                    component: CreateTeam
                },
                {
                    path: 'test',
                    name: 'VueTest',
                    component: VueTest
                },
                ,
                {
                    path: 'social',
                    name: 'CreateSocial',
                    component: CreateSocial
                }
            ]
        }
    ]
}