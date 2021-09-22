package cn.sxt.java;

/**
 * @author xiexu
 * @create 2020-11-04 9:25 上午
 */
public class Test1 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(10)); //30
        System.out.println(WithException());
    }

    /**
     * 如果try和finally都有return，先执行try中的return
     * 然后会把return的结果暂存在栈里面，等待finally执行后返回
     */
    public static int test(int b) {
        try {
            b += 10;
            return b;
        } catch (RuntimeException e) {

        } catch (Exception e2) {

        } finally {
            b += 10;
            return b;
        }
    }

    public static int WithException() {
        int i = 10;
        try {
            System.out.println("i in try block is ： " + i);
            i = i / 0;
            return --i;
        } catch (Exception e) {
            System.out.println("i in catch - form try block is ： " + i);
            --i;
            System.out.println("i in catch block is ： " + i);
            return --i;
        } finally {
            System.out.println("i in finally - from try or catch block is--" + i);
            --i;
            System.out.println("i in finally block is--" + i);
            return --i;
        }
    }
}
