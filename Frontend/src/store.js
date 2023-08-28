import { createStore } from 'vuex';
import axios from 'axios';
const store = createStore({
    state() {
        return {

        }
    },
    mutations :{
        setMore(state) {
        },
    },
    actions : {
        getData(context) {
           axios.get('https://codingapple1.github.io/vue/more0.json').then((a) => {

           })
        }
    }

})
export default store;

