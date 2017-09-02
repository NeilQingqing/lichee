package study.java.foundation.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SelectorSocketChannelDemo {
	
	public static void main(String[] args) {
		SelectorSocketChannelDemo sDemo = new SelectorSocketChannelDemo();
		sDemo.selectorSocketChannelDemo();
	}
	
	public void selectorSocketChannelDemo(){
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("127.0.0.1",9999));//连接后才可以设置下面的属性
			socketChannel.configureBlocking(false);
			
			Selector selector = Selector.open();
			//注册selector
			socketChannel.register(selector, SelectionKey.OP_READ);
			
			//轮询接收数据
			new ClientThread(selector).start();
			
			//发送数据
			String request = "SelectorSocketChannelDemo says: hello SelectorServerSocketChannelDemo!你好";
			ByteBuffer wrByteBuffer = ByteBuffer.wrap(request.getBytes("UTF-8"));
			socketChannel.write(wrByteBuffer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	class ClientThread extends Thread{
		private Selector selector ;
		
		public ClientThread(Selector selector){
			this.selector = selector;
		}
		
		@Override
		public void run(){
			try {
				while(selector.select() > 0){
					for(SelectionKey key : selector.selectedKeys()){
						//从selector获取SocketChannel
						SocketChannel socketChannel = (SocketChannel) key.channel();
						
						ByteBuffer rByteBuffer = ByteBuffer.allocate(1024);
						int size = socketChannel.read(rByteBuffer);
						
						while(size > 0){
							rByteBuffer.flip();
							Charset charset = Charset.forName("utf-8");
							System.out.println(charset.newDecoder().decode(rByteBuffer).toString());
						
							size = socketChannel.read(rByteBuffer);
						}
						
						selector.selectedKeys().remove(key);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
