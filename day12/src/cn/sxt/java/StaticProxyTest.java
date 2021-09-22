package cn.sxt.java;

/**
 * 静态代理的举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 */
//衣服工厂
interface ClothFactory{

    void produceCloth();

}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//就拿"被代理类"的对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");

    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批Aj");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建"被代理类"的对象
        ClothFactory nike = new NikeClothFactory();

        //创建"代理类"的对象,传入的参数是"被代理类"的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();

    }
}
