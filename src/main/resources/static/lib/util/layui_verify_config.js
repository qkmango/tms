//layui表单验证配置对象

const layui_verify_config = {
    //整数
    int: function (value, item) {
        return value % 1 === 0 ? false : "取值为整数"
    },
    // 年份验证
    year: function (value, item) {
        return value >= 2000 && value <= 2100 ? false : '年份取值范围为2000-2100';
    },
    //楼栋号验证
    buildingNumber: function (value, item) {
        if (/^[A-Z]?\d{1,3}[A-Z]?$/.test(value)) {
            return false;
        }
        return '楼号长度在4以内,只能有一个大写字母';
    },
    //楼号验证
    roomNumber: function (value, item) {
        return value >= 101 && value <= 999 ? false : '教室号取值在101-999';
    },
    //大于0
    capacity: function (value, item) {
        return value > 0 ? false : "必须大于0"
    },
    //持续节验证
    courseInfoLength: function (value, item) {
        if (value >= 1 && value <= 4) {
            return false;
        }
        return "取值范围在1-4";
    },
    //验证起始节
    courseInfoBegin: function (value, item) {
        if (value >= 1 && value <= 11) {
            return false;
        }
        return "取值范围在1-11";
    },
    //周验证
    courseInfoWeek: function (value, item) {
        if (value >= 1) {
            return false;
        }
        return "取值为>0";
    },
    //假期日期格式验证
    /*
    2022-8-1,2,3,4,5,6,7\n
    2028-9-4,5,6,7
    */
    holiday: function (value, item) {
        if (value === '') {
            return false;
        }
        const rows = value.split('\n');
        let count = 0;
        for(let row of rows) {
            if (/^20\d{2}-\d{1,2}-(\d{1,2},)*\d{1,2}$/.test(row) || row==='') {
                count++
            }
        }

        if (count === rows.length) {
            return false;
        }
        return '格式不合法'
    }

}
