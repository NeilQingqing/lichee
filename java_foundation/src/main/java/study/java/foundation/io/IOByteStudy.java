package study.java.foundation.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PushbackInputStream;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

public class IOByteStudy {

	//文件统计
	//FileInputStream fis = new FileInputStream(new File(""))
	/**
	 * FileInputStream
	 * 
	 * FileInputStream(String name)
	 * FileInputStream(File file)
	 * FileInputStream(FileDescriptor fdObj)
	 * 
	 * open()
	 * read()
	 * read(byte[])
	 * read(byte [], int , int)
	 * readBytes(byte[], int, int)
	 * 
	 * available()
	 * close()
	 * getChannel()
	 */
	public int fileCount(){
	     int count=0;  //统计文件字节长度  
	     InputStream streamReader = null;   //文件输入流  
	      try{  
	          streamReader=new FileInputStream(new File(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/" +"IO流"));  
	          // FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。 
	          while(streamReader.read()!=-1) {  
	        	  //读取文件字节，并递增指针到下一个字节  
	        		/**
	        		 *  markSupported 判断该输入流能支持mark 和 reset 方法。
	        				mark用于标记当前位置；在读取一定数量的数据(小于readlimit的数据)后使用reset可以回到mark标记的位置。
	        			FileInputStream不支持mark/reset操作；BufferedInputStream支持此操作；
	        				mark(readlimit)的含义是在当前位置作一个标记，制定可以重新读取的最大字节数，也就是说你如果标记后读取的字节数大于readlimit，你就再也回不到回来的位置了。
	        			通常InputStream的read()返回-1后，说明到达文件尾，不能再读取。除非使用了mark/reset。
	        		 */

	             count++;  
	          }  
	          System.out.println("---长度是： "+count+" 字节");  
	      }catch (IOException e) {  
	          e.printStackTrace();  
	      }finally{  
	          try{  
	             streamReader.close();  
	          }catch (IOException e) {  
	             e.printStackTrace();  
	          }  
	      }  
	  	return count;
	   }  

	//文件复制
	/**
	 * FileOutputStream
	 * 
	 * FileOutputStream(String)
	 * FileOutputStream(String, boolean)
	 * FileOutputStream(File)
	 * FileOutputStream(File, boolean)
	 * FileOutputStream(FileDescriptor)
	 * 
	 * open(String, boolean)
	 * write(int, boolean)
	 * writeBytes(byte[], int, int, boolean)
	 * write(byte[])
	 * write(byte[], int, int)
	 * 
	 * close()
	 * getChannel()
	 */
	public void copyFile(){
		 byte[] buffer=new byte[512];   //一次取出的字节数大小,缓冲区大小  
	     int numberRead=0;  
	     FileInputStream input=null;  
	     FileOutputStream out =null;  
	     try {  
	        input=new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/" +"IO流");  
	        out=new FileOutputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/" +"IO流_bak", true); //如果文件不存在会自动创建  
	         
	        //输入流读取read，输出流写出write
	        while ((numberRead=input.read(buffer))!=-1) {  
	        //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  否则会自动被填充0  
	           out.write(buffer, 0, numberRead);           
	        }  
	     } catch (final IOException e) {  
	        e.printStackTrace();  
	     }finally{  
	        try {  
	           input.close();  
	           out.close();  
	        } catch (IOException e) {  
	           e.printStackTrace();  
	        }  
	         
	     }  
	}
	
	/**
	 * ObjectInputStream 和ObjectOutputStream ，该流允许读取或写入用户自定义的类，
	 * 但是要实现这种功能，被读取和写入的类必须实现Serializable接口，其实该接口并没有方法，
	 * 可能相当于一个标记而已，但是却是不可缺少的。
	 * 
	 * ObjectInputStream
	 * ObjectInputStream(InputStream)
	 * 
	 * available()
	 * close()
	 * defaultReadObject()
	 * read()
	 * read(byte[], int, int)
	 * readArray(boolean)
	 * readFields()
	 * readUnshared() 
	 * readFully(byte[])
	 * readXXX() 基本数据类型
	 * readUTF()
	 * readObject()
	 * 
	 * 
	 * ObjectOutputStream
	 * ObjectOutputStream(OutputStream)
	 * 
	 * defaultWriteObject()
	 * close()
	 * flush()
	 * putFields()
	 * 
	 * writeUTF(String)
	 * writeXXX(xxx)
	 * writeFields(xxx)
	 * writeObject(Object)
	 * 
	 */
	public void serializableByObjectStream(){
	      ObjectOutputStream objectwriter=null;  
	      ObjectInputStream objectreader=null;  
	       
	      try {  
	         objectwriter=new ObjectOutputStream(
	        		 new FileOutputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/student.txt"));  
	         objectwriter.writeObject(new Student("xm", 22));  
	         objectwriter.writeObject(new Student("th", 18));  
	         objectwriter.writeObject(new Student("sm", 17));  
	        
	         objectreader=new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/student.txt"));  
	         for (int i = 0; i < 3; i++) {  
	            System.out.println(objectreader.readObject());  
	         }  
	      } catch (IOException e) {  
	         e.printStackTrace();  
	      } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}finally{  
	         try {  
	            objectreader.close();  
	            objectwriter.close();  
	         } catch (IOException e) {  
	            // TODO自动生成的 catch 块  
	            e.printStackTrace();  
	         }  
	          
	      }  
	       
	   }  
	
	
	/**
	 * DataInputStream  
	 * 
	 * DataInputStream(InputStream)
	 * readUTF(DataInput)
	 * read(byte[])
	 * readXXX()
	 * 
	 * DataOutputStream
	 * 
	 * DataOutputStream(OutputStream)
	 * flush()
	 * size()
	 * write(int)
	 * writeUTF(String)
	 * writeBoolean(boolean)
	 * writeXXX(xxx)
	 * 
	 * 有时没有必要存储整个对象的信息，而只是要存储一个对象的成员数据，成员数据的类型假设都是Java的基本数据类型，
	 * 这样的需求不必使用到与Object输入、输出相关的流对象，可以使用DataInputStream、DataOutputStream来写入或读出数据。
	 * 下面是一个例子：（DataInputStream的好处在于在从文件读出数据时，不用费心地自行判断读入字符串时或读入int类型时何时将停止，
	 * 使用对应的readUTF()和readInt()方法就可以正确地读入完整的类型数据。）
	 */
	public void dataStream() {
		Member[] members = { new Member("Justin", 90), new Member("momor", 95), new Member("Bush", 88) };
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/member.txt"));

			for (Member member : members) {
				// 写入UTF字符串
				dataOutputStream.writeUTF(member.getName());
				// 写入int数据
				dataOutputStream.writeInt(member.getAge());
			}

			// 所有数据至目的地
			dataOutputStream.flush();
			// 关闭流
			dataOutputStream.close();

			DataInputStream dataInputStream = new DataInputStream(
					new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/member.txt"));

			// 读出数据并还原为对象
			for (int i = 0; i < members.length; i++) {
				// 读出UTF字符串
				String name = dataInputStream.readUTF();
				// 读出int数据
				int score = dataInputStream.readInt();
				members[i] = new Member(name, score);
			}

			// 关闭流
			dataInputStream.close();

			// 显示还原后的数据
			for (Member member : members) {
				System.out.printf("%s\t%d%n", member.getName(), member.getAge());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * PushbackInputStream 类继承了 FilterInputStream 类是 InputStream 类的修饰者。
	 * 提供可以将数据插入到输入流前端的能力(当然也可以做其他操作)。
	 * 简而言之PushbackInputStream类的作用就是能够在读取缓冲区的时候提前知道下一个字节是什么，
	 * 其实质是读取到下一个字符后回退的做法，这之间可以进行很多操作，这有点向你把读取缓冲区的过程当成一个数组的遍历，
	 * 遍历到某个字符的时候可以进行的操作.当然，如果要插入，能够插入的最大字节数是与推回缓冲区的大小相关的，插入字符肯定不能大于缓冲区
	 * 
	 * PushbackInputStream
	 * 
	 * PushbackInputStream(InputStream)
	 * PushbackInputStream(InputStream, int)
	 * unread(int)
	 * unread(byte[])
	 * unread(byte[], int, int)
	 * read()
	 * read(byte[], int, int)
	 * mark(int)
	 * markSupported()
	 * reset()
	 * skip(long)
	 * available()
	 * 
	 * 
	 * ByteArrayInputStream
	 * 
	 * ByteArrayInputStream(byte[])
	 * ByteArrayInputStream(byte[], int, int)
	 * available()
	 * close()
	 * mark(int)
	 * markSupported()
	 * read()
	 * reset()
	 * skip(long)
	 */
	
	public void pushBackInputStreamDemo() throws IOException {
		String str = "hello,rollenholt";
		PushbackInputStream push = null; // 声明回退流对象
		ByteArrayInputStream bat = null; // 声明字节数组流对象

		bat = new ByteArrayInputStream(str.getBytes());
		push = new PushbackInputStream(bat); // 创建回退流对象，将拆解的字节数组流传入

		int temp = 0;
		while ((temp = push.read()) != -1) { // push.read()逐字节读取存放在temp中，如果读取完成返回-1
			if (temp == ',') { // 判断读取的是否是逗号
				push.unread(temp); // 回到temp的位置
				temp = push.read(); // 接着读取字节
				System.out.print("(回退" + (char) temp + ") "); // 输出回退的字符
			} else {
				System.out.print((char) temp); // 否则输出字符
			}
		}
	}
	
	/**
	 * 有些情况下，当我们需要从多个输入流中向程序读入数据。此时，可以使用合并流，将多个输入流合并成一个SequenceInputStream流对象。
	 * SequenceInputStream会将与之相连接的流集组合成一个输入流并从第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，
	 * 依次类推，直到到达包含的最后一个输入流的文件末尾为止。 合并流的作用是将多个源合并合一个源。其可接收枚举类所封闭的多个字节流对象。
	 *
	 * SequenceInputStream
	 * SequenceInputStream(InputStream, InputStream)
	 * SequenceInputStream(Enumeration<? extends InputStream>)
	 * 
	 * read(byte[], int, int)
	 * read()
	 * close()
	 * 
	 */
	public void sequenceInputStreamTest(){
		 // 创建一个合并流的对象  
	     SequenceInputStream sis = null;  
	     // 创建输出流。  
	     BufferedOutputStream bos = null;  
	     try {  
	        // 构建流集合。  
	        Vector<InputStream> vector = new Vector<InputStream>();  
	        vector.addElement(new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/IO流"));  
	        vector.addElement(new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/IO流_bak"));  
	        vector.addElement(new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/IO流2"));  
	       
	        Enumeration<InputStream> e = vector.elements();  
	   
	        sis = new SequenceInputStream(e);  
	   
	        bos = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/S_IO流"));  
	        // 读写数据  
	        byte[] buf = new byte[1024];  
	        int len = 0;  
	        while ((len = sis.read(buf)) != -1) {  
	           bos.write(buf, 0, len);  
	           bos.flush();  
	        }  
	     } catch (FileNotFoundException e1) {  
	        e1.printStackTrace();  
	     } catch (IOException e1) {  
	        e1.printStackTrace();  
	     } finally {  
	        try {  
	           if (sis != null)  
	              sis.close();  
	        } catch (IOException e) {  
	           e.printStackTrace();  
	        }  
	        try {  
	           if (bos != null)  
	              bos.close();  
	        } catch (IOException e) {  
	           e.printStackTrace();  
	        }  
	     }  
	}
	
	
	
}


class Member {  
    private String name;  
    private int age;  
    public Member() {  
    }  
   public Member(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
    public void setName(String name){  
        this.name = name;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public String getName() {  
        return name;  
    }  
    public int getAge() {  
        return age;  
    }  
}  


class Student implements Serializable{  
	private static final long serialVersionUID = 1L;
	private String name;  
	   private int age;  
	    
	   public Student(String name, int age) {  
	      super();  
	      this.name = name;  
	      this.age = age;  
	   }  
	   
	   @Override  
	   public String toString() {  
	      return "Student [name=" + name + ", age=" + age + "]";  
	   }  
	    
	    
	}  
