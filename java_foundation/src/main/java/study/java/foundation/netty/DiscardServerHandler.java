package study.java.foundation.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
	// This method is called with the received message, whenever new data is
	// received from a client.
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		// Discard the received data silently.
//		((ByteBuf) msg).release(); // (3)

		// 本方法是接收到clients的消息，并进行处理。下面是正确写法
		
		/**
		 *  字节与字符
		 *  String s = "fs123fdsa";//String变量 
			byte b[] = s.getBytes();//String转换为byte[] 
			String t = new String(b);//bytep[]转换为String
		 */
		 ByteBuf in = (ByteBuf) msg;
		    try {
		    	
		    	ctx.alloc().buffer().writeBytes("Hello Client!".getBytes()); // (1)
		        ctx.writeAndFlush("Hello Client!".getBytes()); // (2)
		        
		    	//接收客户端的消息
//		        while (in.isReadable()) { // (1)
//		            System.out.println(in.getLong(8));
//		            System.out.flush();
//		        }
		    	System.out.println(in.toString(io.netty.util.CharsetUtil.UTF_8));
		    	
		    	 //响应客户端的请求
			    
		    } finally {
		        ReferenceCountUtil.release(msg); // (2)
		    }
		    
		   

	}
	
	// The exceptionCaught() event handler method is called with a Throwable
	// when an exception was raised by Netty due to an I/O error or by a handler
	// implementation due to the exception thrown while processing events.In
	// most cases, the caught exception should be logged and its associated
	// channel should be closed here, although the implementation of this method
	// can be different depending on what you want to do to deal with an exceptional situation. 
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}
}
