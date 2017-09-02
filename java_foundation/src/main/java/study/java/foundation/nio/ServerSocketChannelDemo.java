package study.java.foundation.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerSocketChannelDemo {
	
	public static void main(String[] args) {
		ServerSocketChannelDemo serverSocketChannelDemo = new ServerSocketChannelDemo();
		serverSocketChannelDemo.startServer();
	}
	
	public void startServer(){
		ServerSocketChannel serSoCh = null;
		SocketChannel soCh = null;
		try {
			//**********************读取***********************************
			//打开一个channel
			serSoCh = ServerSocketChannel.open();
			//channel 和 socket 关联 并绑定一个port
			serSoCh.socket().bind(new InetSocketAddress(9999));
			//设置channel是非阻塞的
//			serSoCh.configureBlocking(false);//设置为false的时候，无法同时写出和读入
			
			//读取channel 的内容
			while(true){
				//接收客户端的链接，得到一个 SocketChannel
				soCh = serSoCh.accept();
				//如果socketchannel不为空，则读取其中的数据
				if(soCh != null){
					
					//创建一个 ByteBuffer
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					//ByteBuffer 与 SocketChannel 结合输出数据，读出数据
					int size = soCh.read(byteBuffer);
					//如果读取的数据长度大于0，则循环读出所有数据
					while(size > 0){
						byteBuffer.flip();//没有这个会使获取的到的数据乱码
						//解码字符节
						Charset charset = Charset.forName("UTF-8");
						//对byteBuffer解码输出
						System.out.println(charset.newDecoder().decode(byteBuffer));
						size = soCh.read(byteBuffer);
						byteBuffer.clear();
					}
				}
				
				//**********************写出***********************************
				//发送的内容
				String response = "ServerSocketChannel says: hello socketChannel, I get it!";
				//对发送的内容进行编码
				ByteBuffer byteBuffer = ByteBuffer.wrap(response.getBytes("utf-8"));
				//发送
				soCh.write(byteBuffer);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				serSoCh.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
