package cn.sxt.java;

/**
 * @author xiexu
 * @create 2020-11-04 9:44 上午
 */
public class Test2 {

}

class Two {
    Byte x; //x为包装类
}

class PassO {
    public static void main(String[] args) {
        PassO p = new PassO();
        p.start();
    }

    void start() {
        Two t = new Two();
        System.out.print(t.x + " ");
        Two t2 = fix(t);
        System.out.print(t.x + " " + t2.x);
    }

    Two fix(Two tt) {
        tt.x = 42;
        return tt;
    }
}

