/**
 * 获取URL中的参数
 * @param key
 * @returns {string|null}
 */
function getUrlParam(key) {
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    return null;
}


/**
 * 更改对象属性名
 * @param obj 更改的对象
 * @param typeArr 属性名映射数组,如将属性名为 "list" 更改为 "array" , [{ key: 'list', value: 'array' },{...}]
 * @returns {{}|*}
 */
function copyTransFunc(obj, typeArr) {
    let result;
    let toString = Object.prototype.toString;
    if (toString.call(obj) === '[object Array]') {
        result = [];
        for (let i = 0; i < obj.length; i++) {
            result[i] = copyTransFunc(obj[i], arguments[1])
        }
    } else if (toString.call(obj) === '[object Object]') {
        result = {};
        for (let _key in obj) {
            if (obj.hasOwnProperty(_key)) {
                let flag = 0, _value = null;
                for (let j = 0; j < arguments[1].length; j++) {
                    if (arguments[1][j].key === _key) {
                        flag = 1;
                        _value = arguments[1][j].value
                    }
                }
                if (flag)
                    result[_value] = copyTransFunc(obj[_key], arguments[1]);
                else
                    result[_key] = copyTransFunc(obj[_key], arguments[1])
            }
        }
    } else {
        return obj
    }
    return result
}


/**
 *
 * @param a
 * @param b
 * @param prop
 * @param typeConstraint
 * @returns {boolean}
 */

/**
 * 判断两个对象属性值是否相同
 * userConfig.prop 为字符串数组，指定 a和b 比较哪些属性
 * userConfig.typeConstraint 设置类型是否强制，如果为false，则将数据转为String后比较
 * @param a
 * @param b
 * @param userConfig
 * @returns {boolean}
 */
function isObjectValueEqual(a, b, userConfig) {
    if (a === b) return true
    let config = {
        prop:[],
        typeConstraint:true
    };

    if(typeof(userConfig) !== 'undefined') {
        if(typeof(userConfig.prop) !== 'undefined') {
            config.prop = userConfig.prop;
        }
        if(typeof(userConfig.typeConstraint) !== 'undefined') {
            config.typeConstraint = userConfig.typeConstraint;
        }
    }

    //判断是否指定比较的属性
    if (config.prop.length === 0) {
        for (var pro in a) {
            //如果为false说明类型不强制
            if (config.typeConstraint === false) {
                if (String(a[pro]) !== String(b[pro])) {
                    return false;
                }
            } else {
                if (a[pro] !== b[pro]) {
                    return false;
                }
            }
        }
    } else {
        for (let i = 0; i < config.prop.length; i++) {
            if (config.typeConstraint === false) {
                if (String(a[config.prop[i]]) !== String(b[config.prop[i]])) {
                    return false;
                }
            } else {
                if (a[config.prop[i]] !== b[config.prop[i]]) {
                    return false;
                }
            }
        }
    }
    return true;
}
