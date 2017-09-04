package study.java.foundation.proto;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GenerateCodeByProto {

	static final String Path = System.getProperty("user.dir");
	static final String separater = File.separator;

	public static void main(String[] args) {
		String protoFile = "RequestMsg.proto";// proto文件名
//		String protoFile = "User.proto";
		//命令格式 ： 
		// protoc.exe -I=proto的输入目录 --java_out=java类输出目录 proto的输入目录包括包括proto文件
		// 例如
		// d:/dev/protobuf-master/src/protoc.exe -I=./proto --java_out=./src/main/java ./proto/"+ protoFile;  
		String strCmd = Path + separater + "src/main/resource/bin/protoc.exe " + "-I=" + Path + separater
				+ "src/main/java/study/java/foundation/proto --java_out=" + Path + separater
//				+ "src/main/java/study/java/foundation/proto " + Path + separater  
				+ "src/main/java/ " + Path + separater //这里不写包名  在.proto文件的java_package处设置即可。
				+ "src/main/java/study/java/foundation/proto/" + protoFile;
		try {
			Process process = Runtime.getRuntime().exec(strCmd);
			InputStream input = process.getInputStream();
			InputStream error = process.getErrorStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(error));
			String line;
			System.out.println("----");
			while ((line = reader.readLine()) != null) {
				System.out.println("*****");
				System.out.println("----" + line);
			}
			while ((line = errorReader.readLine()) != null) {
				System.out.println("***** errorReader *****");
				System.out.println("----" + line);
			}
			
			process.waitFor();
			input.close();
			error.close();
			errorReader.close();
			reader.close();
			process.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		} // 通过执行cmd命令调用protoc.exe程序
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
