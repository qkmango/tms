let echarts_hotmap_school_calendar_option = {
    mySetDate:function (start,end,holidays) {
        this.calendar.range = [start,end]
        this.series.data=getVirtualData(start,end,holidays)
    },
    visualMap: {
        show: false,
        min: 0,
        max: 2,
        inRange: {
            color: ['#1E9FFF', '#e1f3d8','#FFFFFF']
        }
    },
    legend: {
        y: 'bottom',
        x: 'center'
    },
    calendar: {
        range: ['2022-2-21', '2022-7-1'],
        height:'auto',
        width:'auto',
        left:'25',
        right:'auto',
        top:'20',
        bottom:'auto',
        splitLine: {
            lineStyle:{
                color:'#FFF',
                width: 3
            }
        },
        itemStyle: {
            borderColor:'#FFFFFF',
        },
        yearLabel:{
            show:false
        },
        monthLabel:{
            align:'left'
        },
        dayLabel: {
            show: true,
            firstDay: 1
        }
    },
    series: {
        type: 'heatmap',
        coordinateSystem: 'calendar',
        data: getVirtualData('2022-2-21', '2022-7-1'),
        label: {
            show: true,
            formatter: function (params) {
                return params.value[0].split('-')[2];
            }
        }
    }
};

function getVirtualData(start,end,holidays) {
    start = Date.parse(start);
    end = Date.parse(end);
    holidays = holidayParse(holidays)

    const dayTime = 3600 * 24 * 1000;
    let data = [];
    for (let time = start; time <= end; time += dayTime) {
        const day = new Date(time).getDay();
        let hot = 0;
        if (day === 6 || day === 0) {
            hot = 1
        }
        const formatTimeStr = defaultFormatTime(time);
        //如果日期包含在假期中
        if (holidays!==undefined && holidays.includes(formatTimeStr)) {hot = 2}
        data.push([formatTimeStr, hot]);
    }
    return data;
}

/**
 * 默认日期格式化 yyyy-MM-dd
 * @param time
 * @returns {string}
 */
function defaultFormatTime( time) {
    const date = new Date(time);
    const year = date.getFullYear();
    let month = date.getMonth()+1;
    let day = date.getDate();
    if (month<10) month='0'+month;
    if (day<10) day='0'+day;
    return `${year}-${month}-${day}`;
}

/**
 * 将假期字符串解析为日期数组
 * ['2022-02-21','2022-02-22','2022-02-23'...]
 * @param holidayStr
 */
function holidayParse(holidayStr) {
    if (holidayStr === undefined || holidayStr === '') {return []}
    let raws = holidayStr.split('\n')
    let holidays = [];
    for(let raw of raws) {
        let ymd = raw.split('-');
        const year = ymd[0]
        let month = ymd[1]
        const dayarr = ymd[2].split(',')
        if (month.length === 1) {month = '0'+month;}
        for(let day of dayarr) {
            if (day.length === 1) {day = '0'+day;}
            holidays.push(`${year}-${month}-${day}`)
        }
    }

    return holidays;
}
