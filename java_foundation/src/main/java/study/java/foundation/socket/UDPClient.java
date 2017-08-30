package study.java.foundation.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Socket 实现 UDP 数据传输
 *
 */
public class UDPClient {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader inFormUser = new BufferedReader(
				new InputStreamReader(System.in)); // 以缓冲方式输入一段字符串

		// System.out.println(sentence);

		DatagramSocket ClientSocket = new DatagramSocket(); // 创建一个套接字
		InetAddress IPAddress = InetAddress.getByName("hostname"); // 获取本机IP地址
		byte[] sendData = new byte[1024]; // 一次发送1024字节
		byte[] receiveData = new byte[1024]; // 一次接收1024字节

		String sentence = inFormUser.readLine(); // 获取要发送的字节
		sendData = sentence.getBytes(); // 将字符串转化为字节
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8765); // 创建一个发送数据包

		ClientSocket.send(sendPacket); // 发送
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length, IPAddress, 8765); // 创建一个接收的数据包

		ClientSocket.receive(receivePacket); // 接收
		String modifiedSentence = new String(receivePacket.getData());

		System.out.print("FROM Server:\n" + modifiedSentence + "\n");
		ClientSocket.close();
	}

}
