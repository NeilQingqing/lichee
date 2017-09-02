package study.java.foundation.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ByteBufferDemo {

	public static void main(String[] args) {
		ByteBufferDemo bbd = new ByteBufferDemo();
		try {
			bbd.readFile(System.getProperty("user.dir") + File.separator + "test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile(String fileName) throws FileNotFoundException {
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

		FileChannel fc = raf.getChannel();

		ByteBuffer bb = ByteBuffer.allocate(1024);

		try {
			int size = fc.read(bb);
			while (size > 0) {
				bb.flip();

//				while (bb.remaining() > 0) {
//					System.out.print(bb.getChar());//呥獴†批瑥䉵晦敲
//					System.out.print(bb.get());//8410111511632329812111610166117102102101114
//				}

				Charset charset = Charset.forName("UTF-8");
				System.out.println(charset.newDecoder().decode(bb).toString());//Test  byteBuffer

				bb.clear();
				size = fc.read(bb);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fc.close();
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
