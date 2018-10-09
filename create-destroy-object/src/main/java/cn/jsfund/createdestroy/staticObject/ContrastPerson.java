package cn.jsfund.createdestroy.staticObject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author ppgeneve
 * @Description: 创建Calendar实例非常昂贵，所以借鉴Person。
 * @Date 2018/10/9 17:45
 */
public class ContrastPerson {
    private final Date birthDate;

    public ContrastPerson(Date bd) {
        System.out.println("创建Person");
        this.birthDate = bd;
    }

    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();

        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();

        return birthDate.compareTo(boomStart) >= 0 &&
                birthDate.compareTo(boomEnd) < 0;
    }
}
