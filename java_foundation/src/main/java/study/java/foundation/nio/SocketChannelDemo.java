package study.java.foundation.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelDemo {

	public static void main(String[] args) {
		SocketChannelDemo socketChannelDemo = new SocketChannelDemo();
		socketChannelDemo.clientDemo();
	}
	public void clientDemo(){
		SocketChannel socketChannel = null;
		try {
			//********************写出********************************
			//创建一个 SocketChannel
			socketChannel = SocketChannel.open();
			//SocketChannel 链接 ServerSocketChannel
			socketChannel.connect(new InetSocketAddress("127.0.0.1",9999));
//			socketChannel.configureBlocking(false);  //设置为false的时候，无法同时写出和读入
			
			//发送的内容
			String content = "socketChannel says: hello ServerSocketChannel!";
			//对发送的内容进行编码
			ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes("utf-8"));
			//发送
			socketChannel.write(byteBuffer);
			byteBuffer.clear();
			
			
			//**********************读取***********************************
			
			//创建一个 ByteBuffer
			ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
			//ByteBuffer 与 SocketChannel 结合输出数据，读出数据
			int size = socketChannel.read(readByteBuffer);
			//如果读取的数据长度大于0，则循环读出所有数据
			while(size > 0){
				readByteBuffer.flip();
				//解码字符节
				Charset charset = Charset.forName("UTF-8");
				//对byteBuffer解码输出
				System.out.println(charset.newDecoder().decode(readByteBuffer));
				
				size = socketChannel.read(readByteBuffer);
			}
			readByteBuffer.clear();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socketChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
