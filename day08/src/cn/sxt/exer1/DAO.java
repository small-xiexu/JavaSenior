package cn.sxt.exer1;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。

 分别创建以下方法：
 public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 public T get(String id)：从 map 中获取 id 对应的对象
 public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 public List<T> list()：返回 map 中存放的所有 T 对象
 public void delete(String id)：删除指定 id 对象
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<String,T>();

    //保存 T 类型的对象到 Map 成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }

    //从 map 中获取 id 对应的对象
    public T get(String id){
        return map.get(id);
    }

    //替换 map 中key为id的内容,改为 entity 对象
    public void update(String id,T entity){
        if(map.containsKey(id)){ //判断是否存在当前id
            map.put(id,entity);
        }
    }

    //返回 map 中存放的所有 T 对象
    public List<T> list(){
        //错误的：
//        Collection<T> values = map.values();
//        return (List<T>) values;
        /*
        上面的错误有两个原因：
            1.map.value是无序，可重复的集合，而强转为list是有序，可重复的，这样会矛盾。
            2.强转一般都是形成多态后，父类再强转为子类，两者是有互相关联的关系的，
            而上面的是Collection直接强转为list，所以是错误的
         */

        //正确的：
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t : values){
            list.add(t);
        }
        return list;
    }

    //删除指定 id 对象
    public void delete(String id){
        map.remove(id); //可以返回删除的key对应的value
    }

}
