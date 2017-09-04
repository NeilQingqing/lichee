package study.java.foundation.proto;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import study.java.foundation.proto.UserProtoBuf.User;

public class ClientHandler extends ChannelHandlerAdapter{

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		User user = (User) msg;
		ctx.channel().attr(AttributeKey.valueOf("Attribute_key")).set(user);
		ctx.channel().close();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	}
 
}
