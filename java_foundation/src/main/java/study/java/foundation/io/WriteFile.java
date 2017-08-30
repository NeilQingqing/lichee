package study.java.foundation.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteFile {
	public WriteFile() {     
    }     
  
    public static void main(String[] args) {     
  
        FileOutputStream out = null;     
        
        FileOutputStream outSTr = null;     
        BufferedOutputStream Buff=null;     
  
        FileWriter fw = null;     
  
        int count=1000;//写文件行数     
        
        try {     
            out = new FileOutputStream(new File(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/IO_T"));     
            long begin = System.currentTimeMillis();     
            for (int i = 0; i < count; i++) {     
                out.write("测试java 文件操作\r\n".getBytes());     
            }     
            out.close();     
            long end = System.currentTimeMillis();     
            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 豪秒");     
  
            
            outSTr = new FileOutputStream(new File(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/IO_T2"));     
            Buff=new BufferedOutputStream(outSTr);     
            long begin0 = System.currentTimeMillis();     
            for (int i = 0; i < count; i++) {     
                Buff.write("测试java 文件操作\r\n".getBytes());     
            }     
            Buff.flush();     
            Buff.close();     
            long end0 = System.currentTimeMillis();     
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 豪秒");     
           
            
            fw = new FileWriter(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/IO_T3");     
            long begin3 = System.currentTimeMillis();     
            for (int i = 0; i < count; i++) {     
                fw.write("测试java 文件操作\r\n");     
            }     
            fw.close();     
            long end3 = System.currentTimeMillis();     
            System.out.println("FileWriter执行耗时:" + (end3 - begin3) + " 豪秒");     
        } catch (Exception e) {     
            e.printStackTrace();     
        }     
        finally {     
            try {     
                fw.close();     
                Buff.close();     
                outSTr.close();     
                out.close();     
            } catch (Exception e) {     
                e.printStackTrace();     
  
            }     
  
        }     
  
    }  
    
    /** 
     * A方法追加文件：使用RandomAccessFile 
     *  
     * @param fileName 
     *            文件名 
     * @param content 
     *            追加的内容 
     */  
    public static void appendMethodA(String fileName,String content) {  
        try {  
            // 打开一个随机访问文件流，按读写方式  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            // 将写文件指针移到文件尾。  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * B方法追加文件：使用FileWriter 
     *  
     * @param fileName 
     * @param content 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    /** 
     * C方法追加文件：使用 FileOutputStream 
     *  
     * @param fileName 
     * @param content 
     */ 
    @SuppressWarnings("resource")
    public static void appendMethodC(String fileName, String content) {  
        try {  
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
        	FileOutputStream fos = new FileOutputStream(fileName, true);
			FileInputStream input=new FileInputStream(System.getProperty("user.dir") + File.separator+"/src/main/java/study/java/foundation/io/" +"IO流");  
        	byte[] buffer=new byte[512];   //一次取出的字节数大小,缓冲区大小  
    	    int numberRead=0;  
    	   //输入流读取read，输出流写出write
	        while ((numberRead=input.read(buffer))!=-1) {  
	        //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  否则会自动被填充0  
	        	fos.write(buffer, 0, numberRead);           
	        }   
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    
}
