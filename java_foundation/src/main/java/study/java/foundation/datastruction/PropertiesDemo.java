package study.java.foundation.datastruction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesDemo {
	
	static final String relativePath = System.getProperty("user.dir") + File.separator+ "src/main/java/study/java/foundation/datastruction/"; 
	static final String sparator = File.separator;
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		Properties sexInfo = new Properties();
		sexInfo.setProperty("xl", "36");
		
		try {
			sexInfo.load(new FileInputStream(relativePath + sparator + "test.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sexInfo.put("liming", "female");
		sexInfo.put("limingw", "female");
		sexInfo.put("limingq", "male");
		
		
		
		if(sexInfo.containsKey("xl") && sexInfo.containsValue("82")){
			Iterator enit = sexInfo.entrySet().iterator();
			sexInfo.remove("xl");
			sexInfo.replace("liming", "female", "999");
			try {
				sexInfo.store(new PrintWriter(relativePath + sparator +"test"), "store");
				sexInfo.storeToXML(new FileOutputStream(relativePath + sparator +"test.xml"), "test", "UTF-8");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
        Iterator it = sexInfo.keySet().iterator();
		
		Iterator itValues = sexInfo.values().iterator();
		while(it.hasNext()){
			String name =  (String) it.next();
			System.out.println(name + "  " + sexInfo.getProperty(name) + "  " + sexInfo.get(name));
		}
		
	}
}
