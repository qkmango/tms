/**
 * 获取URL中的参数
 * @param key
 * @returns {string|null}
 */
function getUrlParam(key) {
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) return decodeURI(r[2]);
    return null;
}


/**
 * 更改对象属性名
 * @param obj 更改的对象
 * @param typeArr 属性名映射数组,如将属性名为 "list" 更改为 "array" , [{ key: 'list', value: 'array' },{...}]
 * @returns {{}|*}
 */
function copyTransFunc (obj, typeArr) {
    let result;
    let toString = Object.prototype.toString;
    if (toString.call (obj) === '[object Array]') {
        result = [];
        for (let i = 0; i < obj.length; i++) {
            result[i] = copyTransFunc (obj[i], arguments[1])
        }
    } else if (toString.call (obj) === '[object Object]') {
        result = {};
        for (let _key in obj) {
            if (obj.hasOwnProperty (_key)) {
                let flag = 0, _value = null;
                for (let j = 0; j < arguments[1].length; j++) {
                    if (arguments[1][j].key === _key) {
                        flag = 1;
                        _value = arguments[1][j].value
                    }
                }
                if (flag)
                    result[_value] = copyTransFunc (obj[_key], arguments[1]);
                else
                    result[_key] = copyTransFunc (obj[_key], arguments[1])
            }
        }
    } else {
        return obj
    }
    return result
}
