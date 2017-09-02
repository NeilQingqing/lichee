package study.java.foundation.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelHandlerAdapter{

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
        ctx.close();

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		super.channelActive(ctx);
//		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",   //当被通知Channel是活跃的时候，发送一条消息
//		        CharsetUtil.UTF_8));
		
		ctx.writeAndFlush("Hello Server!");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		super.channelRead(ctx, msg);

//		ByteBuf in = (ByteBuf) msg;
//		System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8));

//		 while (in.isReadable()) { // (1)
//	            System.out.print((char) in.readByte());
//	            System.out.flush();
//	        }
		
		
//		ByteBuf out = ctx.alloc().buffer().writeBytes("Hello!Server".getBytes("UTF-8"));
//		ctx.write(out);
//		ctx.flush();
		
		System.out.println("Cleint recive message : " + msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		super.channelReadComplete(ctx);
	}
 
}
