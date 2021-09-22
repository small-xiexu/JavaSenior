package cn.sxt.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1. 利用File构造器，new一个文件目录file
 *    1)在其中创建多个文件和目录
 *    2)编写方法，实现删除file中指定文件的操作
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("/Users/xiexu/sgg-workspace_idea/JavaSenior/io/io1/hi.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        System.out.println(destFile.getPath());
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }
    }
}
