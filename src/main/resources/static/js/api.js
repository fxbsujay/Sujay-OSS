const request = axios.create({
    baseURL: 'http://localhost:8001' // 基础路径
})

/**
 * <p>Description: 请求拦截器</p>
 * @author sujay
 * @version 15:56 2022/2/24
 */
request.interceptors.request.use(
    config => {
        if (config.method === 'get') {
            config.params = {
                ...config.params,
                ...{ _t: new Date().getTime() }
            }
        }
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

/**
 * <p>Description: 响应拦截器</p>
 * @author sujay
 * @version 15:56 2022/2/24
 */
request.interceptors.response.use(
    response => {
        const res = response.data
        if (res.code !== 200) {
            ElementPlus.ElMessage.error({
                message: res.msg
            });
            return Promise.reject(new Error(res.msg || 'Error'))
        } else {
            return res.data
        }

    },
    err => {
        ElementPlus.ElMessage.error({
            message: '操作失败'
        });
        return Promise.reject(err)
    }
)

function uploadPage(data) {
    return request({
        url: '/upload/page',
        method: 'get',
        params: data
    })
}

function uploadList(data) {
    return request({
        url: '/upload/list',
        method: 'get',
        params: data
    })
}

function uploadInfo(id) {
    return request({
        url: '/upload/' + id,
        method: 'get'
    })
}

function uploadSave(data) {
    return request({
        url: '/upload',
        method: 'post',
        data
    })
}

function sourceUpdate(data) {
    return request({
        url: '/source',
        method: 'put',
        data
    })
}

function uploadDelete(data) {
    return request({
        url: '/upload',
        method: 'delete',
        data
    })
}
