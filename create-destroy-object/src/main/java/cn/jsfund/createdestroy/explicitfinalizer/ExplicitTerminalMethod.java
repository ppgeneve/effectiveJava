package cn.jsfund.createdestroy.explicitfinalizer;

import java.io.*;

/**
 * @author ppgeneve
 * @Description: 终结方法
 * @Date 2018/10/9 19:14
 */

/**
 * 终结方法：finalizer，其并不能保证时效性，如果非要使用终结方法，应该
 * 使用try... finally...结合显式终结方法，比如数据库链接/InputSteam等。
 * 注意，这里的终结方法充当"安全网"，不保证终结方法会及时的调用。但是
 * Better late than never。
 */
public class ExplicitTerminalMethod {
    public void inputStreamClose() {
        InputStream in = null;

        try {
            File file = new File("some path");
            in = new FileInputStream(file);
            System.out.println(in.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
