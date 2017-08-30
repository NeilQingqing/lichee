package study.java.foundation.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * Socket 实现 UDP 数据传输
 *
 */
public class UDPServer {
	 public static void main(String[] args) throws Exception {
	        @SuppressWarnings("resource")
			DatagramSocket ServerSocket = new DatagramSocket(8765);   //创建一个端口号为8765的套接字，端口号必须为1024至65535之间
	        byte[] receiveData = new byte[1024];   //一次接收1024个字节
	        byte[] sendData = new byte[1024];      //一次发送1024个字节
	        while(true){
	            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);   //创建一个数据包
	            ServerSocket.receive(receivePacket);               //套接字接收
	            String sentence = new String(receivePacket.getData());   //获取接收的数据
	            System.out.println(sentence);
	           
	            
	            InetAddress IPAssress = receivePacket.getAddress();      //获取IP地址
	            int port = receivePacket.getPort();                    //获取端口号
	            String capitalizedSentence = sentence.toUpperCase();   //转化为大写字母
	            sendData = capitalizedSentence.getBytes();             //转化为字节
	            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAssress,port);
	            ServerSocket.send(sendPacket);                         //发送
	        }
	    }
}
