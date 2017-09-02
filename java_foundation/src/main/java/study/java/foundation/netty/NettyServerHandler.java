package study.java.foundation.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class NettyServerHandler extends ChannelHandlerAdapter{

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		super.exceptionCaught(ctx, cause);
		 cause.printStackTrace();    //  打印异常栈跟踪
	     ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		super.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		super.channelRead(ctx, msg);
		
//		ByteBuf in = (ByteBuf) msg;
//        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));//将消息记录到控制台
        
//        while (in.isReadable()) { // (1)
//            System.out.print((char) in.readByte());
//            System.out.flush();
//        }
        
//        ByteBuf out = ctx.alloc().buffer().writeBytes("Hello!Client".getBytes("UTF-8"));
//        ctx.write(out); //将接收到的消息写给发送者，而不冲刷出站消息
//        ctx.flush();
		
		//新增解码器
		System.out.println(msg);
		
		String out = "I get mssseage : " + msg;
		ctx.writeAndFlush(out);
        
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		super.channelReadComplete(ctx);
		 ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
         .addListener(ChannelFutureListener.CLOSE);;//　将未决消息冲刷到远程节点，并且关闭该Channel

	}

}
