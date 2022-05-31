const App = {
    name: 'APP',
    setup() {
        const data = Vue.reactive({
            menu: {
                index: 1,
                path: 'main.html',
                title: '首页'
            },
            menuList: [
                {
                    index: 1,
                    path: 'a.html',
                    title: 'a'
                },
                {
                    index: 2,
                    path: 'b.html',
                    title: 'b'
                }
            ]
        })
        /**
         * 页面切换
         * @param key 下标 index
         * @param keyPath 下标数组
         */
        const handleSelect = (key = 1, keyPath = []) => {
            data.menu = data.menuList.find( item => item.index === key)
        }
        return {
            handleSelect,
            ...Vue.toRefs(data)
        }
    }
}
const Home = { template: '#a.html' }
const About = { template: '#b.html' }
const routes = [
    { path: '/#a.html', component: Home },
    { path: '/#b.html', component: About },
]

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes
})
const app = Vue.createApp(App);

app.use(router);
app.use(ElementPlus);
app.mount("#app");
router.beforeEach((to, from) => {
    console.log(menu)
})