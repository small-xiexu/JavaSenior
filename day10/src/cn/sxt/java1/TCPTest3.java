package cn.sxt.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 并关闭相应的连接。
 */
public class TCPTest3 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9091);
            //2.
            os = socket.getOutputStream();
            //3.
            fis = new FileInputStream(new File("beauty.jpg"));
            //4.
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            /*
                关闭数据的输出
                这里需要注意下，在TCPTest1和TCPTest2中没写socket.shutdownOutput();
                是因为客户端传输后就进行了close操作，这样就结束了客户端的运行，
                而服务器自然就会知道客户端已经结束并且接收了来自客户端的数据。

                而在这里使用socket.shutdownOutput(); 是因为客户端传输完成后，
                并没有指明自己是否传输结束，一直卡在循环里面，服务端就会一直等待着
                客户端发出结束的指令才结束接收数据，导致一直卡死在循环。
             */
            socket.shutdownOutput();

            //5.接收来自于服务器端的数据，并显示到控制台上
            InputStream is = socket.getInputStream();
            //用这个类可以防止接收的中文乱码
            baos = new ByteArrayOutputStream();
            byte[] bufferr = new byte[20];
            int len1;
            while((len1 = is.read(buffer)) != -1){
                baos.write(buffer,0,len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            //1.
            ss = new ServerSocket(9091);
            //2.
            socket = ss.accept();
            //3.
            is = socket.getInputStream();
            //4.
            fos = new FileOutputStream(new File("beauty2.jpg"));
            //5.
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("图片传输完成");

            //6.服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("你好，美女，照片我已收到，非常漂亮！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
