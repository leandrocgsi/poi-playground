package br.com.semeru.poi.file.utils;

import org.junit.Before;
import org.junit.Test;

public class IOUtilsTest {
		
	IOUtils ioUtils = new IOUtils(); 
		
	String s = "It's a simple test writing into disk";
	byte[] byteArray = null;
	String path, fileName = "";

    @Before
    public void setup() {
		byteArray = s.getBytes();
		path = System.getProperty("user.dir") + "\\target\\";
		fileName = "WriterTest.txt";
    }
	
	@Test
	public void test() {
		ioUtils.fileWriter(byteArray, path, fileName);
	}

}
