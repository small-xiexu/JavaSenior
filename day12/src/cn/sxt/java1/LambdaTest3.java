package cn.sxt.java1;

import org.junit.Test;

/**
 * 作为参数传递Lambda表达式
 */
public class LambdaTest3 {

    public String toUpperString(MyFunc<String> mf,String str) {
        return mf.getValue(str);
    }

    @Test
    public void test1(){
        String newStr = toUpperString(new MyFunc<String>() {
            @Override
            public String getValue(String s) {
                return s.toUpperCase();
            }
        },"abcdef");
        System.out.println(newStr);
    }

    @Test
    public void test2(){

        String newStr = toUpperString(
                (str) -> str.toUpperCase() , "abcdef");
        System.out.println(newStr);
    }

}
