package study.java.foundation.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class SystemUtils {
	 
	public void showPath() throws IOException {
         // 第一种：获取类加载的根路径  F:\workspace\myRepo\lichee\java_foundation\target\test-classes
         File f = new File(this.getClass().getResource("/").getPath());
         System.out.println(f);

         // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录 
         // F:\workspace\myRepo\lichee\java_foundation\target\classes\study\java\foundation\file
         File f2 = new File(this.getClass().getResource("").getPath());
         System.out.println(f2);

         // 第二种：获取项目路径    F:\workspace\myRepo\lichee\java_foundation
         File directory = new File("");// 参数为空
         String courseFile = directory.getCanonicalPath();
         System.out.println(courseFile);

 
         // 第三种：  file:/F:/workspace/myRepo/lichee/java_foundation/target/test-classes/
         URL xmlpath = this.getClass().getClassLoader().getResource("");
         System.out.println(xmlpath);

         // 第四种：F:\workspace\myRepo\lichee\java_foundation
         System.out.println(System.getProperty("user.dir"));
       
         // 第五种：  获取所有的类路径 包括jar包的路径
         System.out.println(System.getProperty("java.class.path"));
         /*
          * 结果： F:\workspace\myRepo\lichee\java_foundation\target\test-classes;F:\workspace\myRepo\lichee\java_foundation\target\classes;F:\apache_software\apache-maven-3.3.9-bin\maven_repository\junit\junit\4.12\junit-4.12.jar;F:\apache_software\apache-maven-3.3.9-bin\maven_repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;/F:/Eclipse/eclipse/configuration/org.eclipse.osgi/390/0/.cp/;/F:/Eclipse/eclipse/configuration/org.eclipse.osgi/389/0/.cp/
          */
     }
	
	
	public void showPropertiesElment(){

        //遍历Properties
        //Properties 继承于 Hashtable，entrySet()是Hashtable的方法，返回此 Hashtable 中所包含的键的 Set 视图。此 collection 中每个元素都是一个 Map.Entry
        Properties properties = System.getProperties();
        Iterator<Entry<Object, Object>> it=properties.entrySet().iterator();
        while(it.hasNext()){
       	    @SuppressWarnings("rawtypes")
			Map.Entry entry=(Map.Entry)it.next();
       	    Object key = entry.getKey();
       	    Object value = entry.getValue();
       	    System.out.println(key +":            "+value);
       }
        
        
      //Properties 继承于 Hashtable，elements()是Hashtable的方法，返回哈希表中的值的枚举。
        Enumeration<Object> enu=properties.elements();
        while(enu.hasMoreElements()){
            String key = (String)enu.nextElement();
            System.out.println(key);
        } 
        
      //propertyNames(),返回属性列表中所有键的枚举
        Enumeration<?> enu2=properties.propertyNames();
        while(enu2.hasMoreElements()){
            String key = (String)enu2.nextElement();
            System.out.println(key);
        }
        
	}
	
	
	
}
