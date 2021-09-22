package cn.sxt.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author xiexu
 * @create 2020-09-13 上午 11:38
 */
public class BankTest {

    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);
    }

}

class Bank{

    private Bank(){

    }

    private static Bank instance = null;

    public static Bank getInstance(){

        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二：效率更高
        if(instance == null){

            synchronized (Bank.class) {
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
