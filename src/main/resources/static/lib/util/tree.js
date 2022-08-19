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
 * 获取树型列表选中的深度为3的子孙元素
 * @param checkedData
 */
function getTreeCheckedDataListDeep3(checkedData) {
    if (checkedData == null || checkedData.length === 0) {
        return [];
    }
    let arr = [];
    for (let deep1 of checkedData) {
        for (let deep2 of deep1.children) {
            for (let deep3 of deep2.children) {
                arr.push(deep3)
            }
        }
    }
    return arr;
}

/**
 * 获取树型列表选中的深度为3的子孙元素的ID
 * @param checkedData
 */
function getTreeCheckedDataIDListDeep3(checkedData) {
    if (checkedData == null || checkedData.length === 0) {
        return [];
    }
    let arr = [];
    for (let deep1 of checkedData) {
        for (let deep2 of deep1.children) {
            for (let deep3 of deep2.children) {
                arr.push(deep3.id)
            }
        }
    }
    return arr;
}


/**
 * 获取树型列表选中的深度为2的儿子元素
 * @param checkedData
 */
function getTreeCheckedDataListDeep2(checkedData) {
    if (checkedData == null || checkedData.length === 0) {
        return [];
    }
    let arr = [];
    for (let deep1 of checkedData) {
        for (let deep2 of deep1.children) {
            arr.push(deep2)
        }
    }
    return arr;
}

/**
 * 获取树型列表选中的深度为2的儿子元素的ID
 * @param checkedData
 */
function getTreeCheckedDataIDListDeep2(checkedData) {
    if (checkedData == null || checkedData.length === 0) {
        return [];
    }
    let arr = [];
    for (let deep1 of checkedData) {
        for (let deep2 of deep1.children) {
            arr.push(deep2.id)
        }
    }
    return arr;
}
