package exp6;

import java.util.Calendar;

public class exp6_4_Calendar {
    int year, month, day;
    long time1;

    exp6_4_Calendar(int a, int b, int c) {
        year = a;
        month = b - 1;//在月份中，0表示1月
        day = c;
    }

    long Millisecond() {//返回当前对象的毫秒计时
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        time1 = calendar.getTimeInMillis();
        return time1;
    }

    static void IntervalTime(exp6_4_Calendar a, exp6_4_Calendar b) {//计算相隔天数并输出
        long time = Math.abs(b.Millisecond() - a.Millisecond()) / (1000 * 60 * 60 * 24);//Math.abs()返回参数绝对值
        System.out.println(b.year + "-" + (b.month + 1) + "-" + b.day + " 和 " + a.year + "-" + (a.month + 1) + "-" + a.day + "相隔时间:" + time);
    }

}
