package study.java.foundation.proto;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg;
@Component
public class Server  implements ApplicationListener<ContextRefreshedEvent>,Ordered{
	@SuppressWarnings("unused")
	private int port;

	public Server(int port) {
		this.port = port;
	}

	public void run(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap(); // (2)
			b.group(bossGroup, workerGroup)
			 .channel(NioServerSocketChannel.class) // (3)
			 .childHandler(
				new ChannelInitializer<SocketChannel>() { // (4)
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						//新增解码器
//						ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
//						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						ch.pipeline().addLast(new ProtobufDecoder(RequestMsg.getDefaultInstance()));
						ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						ch.pipeline().addLast(new ProtobufEncoder());
						
						ch.pipeline().addLast(new ServerHandler());
					}
				})
				.option(ChannelOption.SO_BACKLOG, 128) // (5)
				.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

			// Bind and start to accept incoming connections.
			ChannelFuture f = b.bind(port).sync(); // (7)

			// Wait until the server socket is closed.
			// In this example, this does not happen, but you can do that to
			// gracefully
			// shut down your server.
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 9999;
		}
		new Server(port).run(port);
	}
	
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	public void onApplicationEvent(ContextRefreshedEvent event) {
		 try {
			run(9999);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
