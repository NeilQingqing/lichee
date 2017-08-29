package test.study.java.foundation.file;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import study.java.foundation.file.FileStudy;
import study.java.foundation.file.SystemUtils;

public class FileTest {
	SystemUtils sysUtils = null;
	FileStudy fileStudy = null;
	@Before
	public void init(){
		sysUtils = new SystemUtils();
		fileStudy = new FileStudy();
	}
	
	@Test
	public void testSysUtils(){
		try {
			sysUtils.showPath();
			sysUtils.showPropertiesElment();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFileStudy() throws IOException{
		File file = new File(System.getProperty("user.dir"));
	    fileStudy.createFile();
//		fileStudy.showFile();
		fileStudy.filterFile();
		fileStudy.showDir(file);
		
		
//		fileStudy.deleteFile(file);
	}
	
	
	
}
