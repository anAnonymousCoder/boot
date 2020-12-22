/**
 * 获取当前上下文路径
 * @returns {string}
 */
function getContextPath() {
    //获取服务器根路径后面的路径
    let pathName = document.location.pathname;
    let index = pathName.substr(1).indexOf("/");
    //获取项目路径
    return pathName.substr(0, index + 1);
}

/**
 * 获取url中的参数
 * @param variable
 * @returns {string}
 */
function getPathVariable(variable) {
    //获取地址栏中的参数，对中文解码
    let searchURL = decodeURI(window.location.search);
    let query = searchURL.substring(1);
    //获取所有参数，用'&'分割为数组
    let vars = query.split("&");
    for (let i = 0; i < vars.length; i++) {
        let params = vars[i].split("=");
        //获取"="后的部分，即参数的值
        if (params[0] === variable) {
            return params[1];
        }
    }
    return '';
}

/**
 * 判空
 * @param {Object} str
 */
function isEmpty(str) {
    if (str === null || typeof (str) === 'undefined' || str === 'null' || str === '(null)' || str === '<null>' || str === 'undefined' || str === 'NULL' || str === undefined || str.length === 0) {
        return true;
    }
    if (typeof (str) === 'string' && str.replace(/(^s*)|(s*$)/g, "").length === 0) {
        return true;
    }
    if (typeof (str) === 'number' && str === 0) {
        return true;
    }
    return false;
}