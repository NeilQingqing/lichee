package study.java.foundation.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;

public class NettyClient {
	 public static void main(String[] args) throws Exception {
//	        String host = args[0];
//	        int port = Integer.parseInt(args[1]);
		    String host = "127.0.0.1";
	        int port = 9999;
	        EventLoopGroup workerGroup = new NioEventLoopGroup();
	        
	        try {
	            Bootstrap b = new Bootstrap(); // (1)
	            b.group(workerGroup); // (2)
	            b.channel(NioSocketChannel.class); // (3)
	            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
	            b.handler(new ChannelInitializer<SocketChannel>() {
	                @Override
	                public void initChannel(SocketChannel ch) throws Exception {
	                	ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new NettyEncoder());
	                	
	                	ch.pipeline().addLast(new NettyClientHandler());
	                }
	            });
	            
	            // Start the client.
	            ChannelFuture f = b.connect(host, port).sync(); // (5)

	            // Wait until the connection is closed.
	            f.channel().closeFuture().sync();
	        } finally {
	            workerGroup.shutdownGracefully();
	        }
	    }
}
