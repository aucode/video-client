/**
 * Ajax异步请求。
 * @param {*} method 请求类型，POST，GET。
 * @param {*} path 请求路径。
 * @param {*} data 请求参数。
 */
function AjaxParameterBase(method,path,data){
    return new Promise((resolve,reject) => {
        $.ajax({
            type:method,
            url: path,
            data:data,
            xhrFields: {withCredentials: true},     //跨域问题
            crossDomain: true,                      //跨域问题
            async:false,
            dataType:"json",
            success: msg => {
                resolve(msg);
            },
            error: e => {
                reject(e)
            }
        });
    })
}
/**
 * Ajax异步请求。
 * @param {*} method 请求类型，POST，GET。
 * @param {*} asynchronous 请求方式，true：异步请求，false：同步请求。
 * @param {*} backtype 数据返回类型。
 * @param {*} path 请求路径。
 * @param {*} data 请求参数。
 */
function AjaxParameter(method,asynchronous,backtype,path,data){
    return new Promise((resolve,reject) => {
        $.ajax({
            type: method,
            url:  path,
            data: data,
            async: asynchronous,
            xhrFields: {withCredentials: true},     //跨域问题
            crossDomain: true,                      //跨域问题
            dataType: backtype,
            success: msg => {
                resolve(msg);
            },
            error: e => {
                reject(e)
            }
        });
    })
}
