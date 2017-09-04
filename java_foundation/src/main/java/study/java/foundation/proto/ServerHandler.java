package study.java.foundation.proto;

import com.google.protobuf.ByteString;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg;
import study.java.foundation.proto.UserProtoBuf.User;

public class ServerHandler extends ChannelHandlerAdapter{

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		RequestMsg request = (RequestMsg)msg;
		String command = request.getCmd();
		System.out.println(command);
		
		ByteString param = request.getParam();
		User user = User.parseFrom(param);
		System.out.println(user.getPhoneNumber());
		
		ctx.writeAndFlush(user);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

	}

}
