package cn.sxt.java1;

/**
 * 自定义函数式接口
 */
@FunctionalInterface
public interface MyFunc<T> {

    public T getValue(T t);

//    void method2(); //函数式接口只能有一个抽象方法
}

