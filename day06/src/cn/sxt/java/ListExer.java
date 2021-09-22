package cn.sxt.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
    List面试题
 */
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("原来的集合元素：" + list);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
//        list.remove(2); //删除索引是2的元素
        list.remove(new Integer(2)); //删除元素是2的元素
    }

}
