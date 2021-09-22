package cn.sxt.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环(增强for循环)，用于遍历集合、数组
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合中元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器。
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    //使用普通的for循环，赋值的都是原来的数组的元素，
    //而使用增强for循环，赋值的是新的变量s，相当于把"GG"赋值给新的数组s
    //所以原来的数组元素保持不变
    @Test
    public void test3(){

        String[] arr = new String[]{"MM","MM","MM"};

//        //方式一：普通for循环的赋值操作
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环的赋值操作
        //使用增强for循环，赋值的是新的变量s，相当于把"GG"赋值给新的数组s
        for(String s : arr){
            s = "GG";
            System.out.println(s);
        }

        System.out.println("***************");

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
