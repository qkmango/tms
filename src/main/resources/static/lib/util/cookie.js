/**
 * 获取cookie
 * @param ckey cookie名
 * @returns {string|null} 存在则返回值，不存在则返回 null
 */
function getCookie(ckey) {
    let key = ckey + "=";
    let ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i].trim();
        if (c.indexOf(key) === 0) {
            return c.substring(key.length, c.length);
        }
    }
    return null;
}

/**
 * 添加cookie
 * @param key cookie名
 * @param value cookie值
 * @param maxAge 有效时长（秒），默认为 -1，即浏览器关闭失效
 */
function setCookie(key, value, maxAge) {
    if (maxAge === undefined) {
        document.cookie = key + '=' + value + '; Max-Age=-1';
    }
    document.cookie = key + '=' + value + '; Max-Age=' + maxAge;
}

/**
 * 判断cookie是否存在
 * @param key cookie名
 * @returns {boolean} true存在 false不存在
 */
function existCookie(key) {
    if (key === undefined) return false;
    const value = getCookie(key);
    if (value === null) {
        return false;
    }
    return true;
}
