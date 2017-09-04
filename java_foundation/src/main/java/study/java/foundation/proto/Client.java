package study.java.foundation.proto;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.util.AttributeKey;
import study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg;
import study.java.foundation.proto.UserProtoBuf.User;

public class Client {
	 
	 public static Object startClient(RequestMsg.Builder requestMsg) {
		 String host = "127.0.0.1";
	     int port = 9999;  
		 
	        EventLoopGroup workerGroup = new NioEventLoopGroup();
	        
	        try {
	        	Bootstrap b = new Bootstrap();
	            b.group(workerGroup); // (2)
	            b.channel(NioSocketChannel.class); // (3)
	            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
	            b.handler(new ChannelInitializer<SocketChannel>() {
	                @Override
	                public void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						ch.pipeline().addLast(new ProtobufDecoder(User.getDefaultInstance()));
						ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						ch.pipeline().addLast(new ProtobufEncoder());
	                	ch.pipeline().addLast(new ClientHandler());
	                }
	            });
	            ChannelFuture f = b.connect(host, port).sync();
				f.channel().writeAndFlush(requestMsg);
				f.channel().closeFuture().sync();
				
	            return f.channel().attr(AttributeKey.valueOf("Attribute_key")).get();
	        } catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
	            workerGroup.shutdownGracefully();
	        }
	        return null;
	  
	 }
	
     
}
