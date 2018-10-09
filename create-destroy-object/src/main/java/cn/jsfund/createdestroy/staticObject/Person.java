package cn.jsfund.createdestroy.staticObject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author ppgeneve
 * @Description: Person类只要在初始化的时候创建Calendar、TimeZone、Date实例，
 *               而不是在每次调用isBabyBoomer时都创建这些实例。
 * @Date 2018/10/9 17:41
 */
public class Person {
    private final static Date BOOM_START;
    private final static Date BOOM_END;

    private final Date birthDate;

    public Person(Date bd) {
        System.out.println("创建Person");
        this.birthDate = bd;
    }

    static {
        System.out.println("设置起止时间");
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(1956, Calendar.JUNE, 15);
        Person bill = new Person(cal.getTime());
        System.out.println(bill.isBabyBoomer());
    }
}


