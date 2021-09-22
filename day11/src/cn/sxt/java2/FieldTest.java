package cn.sxt.java2;

import cn.sxt.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 */
public class FieldTest {

    @Test
    public void test1(){

        Class clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其所有父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明的所有属性(包括私有属性)。
        // （不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
    }

    //权限修饰符  数据类型  变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符,注意：权限修饰符如果是空的，表示default
            int modifier = f.getModifiers();
            System.out.print("权限修饰符:" + Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print("数据类型:" + type.getName() + "\t");

            //3.变量名(属性名)
            String fName = f.getName();
            System.out.print("变量名:" + fName + "\t");

            System.out.println();
        }
    }

}
