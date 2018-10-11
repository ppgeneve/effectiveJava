package cn.jsfund.equals;

/**
 * @author ppgeneve
 * @Description: equals symmetry
 * @Date 2018/10/11 14:09
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * equalsIgnoreCase 两个字符串忽略大小写的比较。
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s
            );
        }

        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    /**
     * equals的对称性
     * x.equals(y) == true  <=>  y.equals(x) == true
     * 这个例子重写了equals，cis.equals(s)是true，但是
     * s.equals(cis)返回false，这违反了对称性。
     * 所以，我们只应该在equals实现类型判断。即：
     *
     * return o instanceof CaseInsensitiveString &&
     *          ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
     * @param args
     */
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s)); //true
        System.out.println(s.equals(cis)); //false
    }
}
