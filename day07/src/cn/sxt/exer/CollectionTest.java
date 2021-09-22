package cn.sxt.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);

        coll.forEach(System.out::println);
    }

    //练习：在List内去除重复数字值，要求尽量简单
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    //Set面试题
    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        //remove会失败,因为remove的时候会根据1001,"CC"的hash值去查找，结果查找失败
        //即：p1的存储位置是根据 1001,"AA" 的hash值计算出来的
        //然后把p1的name修改为"CC",存储的位置还是不变，而接着使用remove(p1)
        //会让hashset根据1001,"CC"的hash值计算出的位置去查找的，显示是查找失败的
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set); //3个
        set.add(new Person(1001,"AA"));
        //之所以new Person(1001,"AA")还可以成功添加，是因为
        //前面位置的p1已经修改了name值，虽然hash值是一样的，但通过equals对比是不同的
        System.out.println(set); //4个
    }

}
