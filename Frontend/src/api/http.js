import axios from "axios";
const instance = axios.create({
    timeout: 5000,
    baseURL: '/api',
    headers: {
        'content-type': 'application/x-www-form-urlencoded'
    }
});
instance.interceptors.request.use(config => {
        console.log(config);
        return config
    },
    error => {
        console.log(error)
        return Promise.reject(error)
    }
)
export default instance;