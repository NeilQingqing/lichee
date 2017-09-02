package study.java.foundation.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SelectorServerSocketChannelDemo {

	public static void main(String[] args) {
		SelectorServerSocketChannelDemo sDemo = new SelectorServerSocketChannelDemo();
		sDemo.selectorDemo();
	}
	
	public void selectorDemo() {
		ServerSocketChannel serverSocketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			// serverSocketChannel.socket().bind(new
			// InetSocketAddress("127.0.0.1",9999));
			serverSocketChannel.bind(new InetSocketAddress(9999));
			serverSocketChannel.configureBlocking(false);

			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			while (true) {
				// 每个链接只select一次
				int select = selector.select();
				if (select > 0) {
					for (SelectionKey selectionKey : selector.selectedKeys()) {
						if (selectionKey.isAcceptable()) {
							//从selector获取ServerSocketChannel 和 SocketChannel
							SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();

							// **********************获取消息**********************
							ByteBuffer bf = ByteBuffer.allocate(1024);
							int size = socketChannel.read(bf);
							while (size > 0) {
								bf.flip();
								Charset charset = Charset.forName("UTF-8");
								System.out.println(charset.newDecoder().decode(bf).toString());
								size = socketChannel.read(bf);
							}
							bf.clear();

							// ***********************发送消息**********************
							ByteBuffer writeBF = ByteBuffer
									.wrap("SelectorServerSocketChannel says: I get it!".getBytes());
							socketChannel.write(writeBF);
							writeBF.clear();
							socketChannel.close();

							selector.selectedKeys().remove(selectionKey);
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
