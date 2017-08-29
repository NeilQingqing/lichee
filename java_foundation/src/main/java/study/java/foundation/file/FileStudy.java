package study.java.foundation.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Java @code#File study
 * @author lichee
 * Demo the way of usage @code#File
 * 
 * Java File类方法使用详解
 */
public class FileStudy {

    
	
    public File createFile(){
    	String currentDir = System.getProperty("user.dir");
    	System.out.println(currentDir);
    	/**
    	 * 构造函数File（String pathname）
	        File f1 = new File("Test1.txt");
	        
	        File(String parent,String child)
	        File f2 = new File("D:\\a", "2.txt");
	         
	        File(File parent,String child)
	        File f3 = new File("D:"+File.separator+"a");
	        File f4 = new File(f3,"3.txt");
    	 * 
    	 * 创建文件
    	 * 1 boolean createNewFile() 不存在就返回true；存在返回false
           2 boolean mkdir()  创建目录
           3 boolean mkdirs()  创建多级目录
    	 */
        File file = new File(currentDir + File.separator + "Test1.txt");
        if(!(file.exists() && file.isFile())){
        	try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        System.out.println("PATH = " + file.getAbsolutePath());
        
        return file;
    }
	
    
    public void deleteFile(File file) throws IOException{
    	/**
			 删除方法
			1 boolean delete()
			2 boolean deleteOnExit()  文件使用后删除
    	
    	
    	file.getParentFile();
    	file.getAbsolutePath();
    	file.getAbsoluteFile();
    	file.getPath();
    	file.getName();
    	file.getCanonicalFile();
    	
    	
    	file.setExecutable(true);
    	file.setExecutable(true, true);
    	file.setReadable(false);
    	file.setReadOnly();
    	file.setWritable(true);
    	
    	
    	file.isAbsolute();
    	file.isFile();
    	file.isDirectory();
    	file.isHidden();
    	
    	file.lastModified();
    	file.length();
    	file.listFiles();
    	file.canExecute();
    	file.canRead();
    	file.canWrite();
    	file.toURI();
    	
    	long freeSpace = file.getFreeSpace();
    	long totalSpace = file.getTotalSpace();
    	long usableSpace = file.getUsableSpace();
    	 */
    	file.renameTo(new File("test"));
    	
    	File[] files = File.listRoots();
    	for(File f : files){
    		System.out.println(f.getAbsolutePath());
    	}
    	
    	
    	
    	if(file.exists() && file.isFile()){
    		boolean bol = file.delete();
    		if(bol){
    			System.out.println("delete success");
    		}else{
    			System.out.println("delete fail");
    		}
    	}
    }
	
    // 列出磁盘下的文件和文件夹
    public void showFile(){
    	File[] files =File.listRoots();
        for(File file:files){
            System.out.println("******************"+file);
            if(file.length()>0){
                String[] filenames =file.list();
                for(String filename:filenames){
                    System.out.println(filename);
                }
            }
        }
    }
    
    //文件过滤
    public void filterFile(){
        File[] files =File.listRoots();
        for(File file:files){
            System.out.println(file);
            if(file.length()>0){
                String[] filenames =file.list(new FilenameFilter(){
                    //file 过滤目录 name 文件名
                    public boolean accept(File file,String filename){
                        return filename.endsWith(".pdf");
                    }
                });
                for(String filename:filenames){
                    System.out.println(filename);
                }
            }
        }
    }
    
    //列出目录下所有文件
    public void showDir(File dir){
        System.out.println(dir);
        File[] files =dir.listFiles();
        for(File file:files){
            if(file.isDirectory())
                showDir(file);
            else
                System.out.println(file);
        }
    }
  
    
}
