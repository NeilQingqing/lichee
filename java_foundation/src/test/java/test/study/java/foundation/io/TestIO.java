package test.study.java.foundation.io;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import study.java.foundation.io.IOByteStudy;
import study.java.foundation.io.IOCharStudy;

public class TestIO {

	IOByteStudy ioStudy = null;
	IOCharStudy iOCharStudy = null;
	
	@Before
	public void init(){
		ioStudy = new IOByteStudy();
		iOCharStudy = new IOCharStudy();
	}
	
	@Test
	public void testFileStream(){
		ioStudy.fileCount();
		ioStudy.copyFile();
	}
	
	@Test
	public void testObjectStream(){
		ioStudy.serializableByObjectStream();
	}
	
	@Test
	public void testDataStream(){
		ioStudy.dataStream();
	}
	
	@Test
	public void testPushBackInputStream() throws IOException{
		ioStudy.pushBackInputStreamDemo();
	}
	
	@Test
	public void testSequenceInputStream() {
		ioStudy.sequenceInputStreamTest();
	}
	
	
	@Test
	public void testFileReader() {
		iOCharStudy.fileReader();
	}
	
	@Test
	public void testFileConcatenate() {
		try {
			iOCharStudy.fileConcatenate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStreamTokenizer() {
		iOCharStudy.streamTokenizerTest();
	}
	
	@Test
	public void testPipedStream(){
		ioStudy.pipedStreamTest();
	}
}
