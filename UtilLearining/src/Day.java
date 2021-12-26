import java.util.Arrays;
/**
 * 计算日期对应这一年的第几天
 * 闰年判断方法
 */
public class Day {
    public static void main(String[] args) {
        //计算日期对应这一年的第几天
//        int sumdays = getSumDays(2021,1,15);
//        System.out.println(sumdays);
    }

    //计算year-month-day日期对应year这一年的第几天：2018 09 10
    private static int getSumDays(int year, int month, int day) {
        // 定义统计天数的参数 sum
        int sum = 0;
        for (int j = 1; j < month; j++) {
            int days = getMonthdays(year, j);
            sum += days;
        }
        return  sum+day;
    }
    //返回year中month的天数
    private static int getMonthdays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                //闰年二月29天
                //平年二月28天
                if (leapYear(year)) {
                    return 29;
                }
                else {
                    return 28;
                }
            default:
                break;
        }
        return 0;
    }
    //闰年判断方法
    private static boolean leapYear(int year) {
        // TODO Auto-generated method stub
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
