import Vue from 'vue'
import Router from 'vue-router'

const TheContainer = () => import('@/containers/TheContainer')
const NewEmployee = () => import('@/views/NewEmployee')
const EmployeeTable = () => import('@/views/EmployeeTable')
const EmployeeView = () => import('@/views/EmployeeView')
const CreateTeam = () => import('@/views/CreateTeam')
const VueTest = () => import('@/views/VueTest')
const CreateSocial = () => import('@/views/CreateSocial')
const EditEmployee = () => import('@/views/EditEmployee')
const EmployeeContainer = () => import('@/containers/EmployeeContainer')
const Dashboard = () => import('@/views/Dashboard')


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
            redirect: 'home',
            name: 'Home',
            component: TheContainer,
            children: [
                {
                  path: 'home',
                  component: Dashboard
                },
                {
                    path: 'new',
                    name: 'NewEmployee',
                    component: NewEmployee
                },{
                    path: 'employees',
                    name: 'EmployeeTable',
                    redirect: 'employees/table',
                    component: EmployeeContainer,
                    children: [
                        {
                            path:'table',
                            component: EmployeeTable
                        },
                        {
                            path: 'edit/:id',
                            name: 'EditEmployee',
                            component: EditEmployee
                        },
                        {
                            path: 'view/:id',
                            name: 'EmployeeView',
                            component: EmployeeView
                        },
                    ]
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
                {
                    path: 'social',
                    name: 'CreateSocial',
                    component: CreateSocial
                }
            ]
        }
    ]
}