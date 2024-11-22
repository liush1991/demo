/**
 * 插件
 * @type {{}}
 */
const myPlugin={}
myPlugin.install=function(Vue,options){
    Vue.component("MyComponent",{
        template:"<div :class='class1'>{{name}}<slot></slot></div>",
        data(){
            return{
                class1:"css-class"
            }
        },
        props:{
            name:{
                type:String,
                default:"ceshi"
            }
        },
        methods: {

        }

    })
}
Vue.use(myPlugin)
