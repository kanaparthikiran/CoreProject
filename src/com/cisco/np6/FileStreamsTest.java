/**
 * 
 */
package com.cisco.np6;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
public class FileStreamsTest {

	private static final Logger  log = Logger.getLogger(FileStreamsTest.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String filePath = "ChristinaAguilera-TheVoice-jpg_214905.jpg";
		String myfavImgChar = "Aguilera_char1.jpg";
		String myfavImgByte = "Aguilera_byte.jpg";
		
		File inFile = new File(filePath);
		File outFileChar = new File(myfavImgChar);
		File outFileByte = new File(myfavImgByte);
		
		FileReader fr = new FileReader(inFile);
		
		FileWriter fw = new FileWriter(outFileChar);
		int read = 0;
		
		while((read =fr.read())!=-1) {
			fw.write(read);
		}
		fr.close();
		fw.close();
		log.info("Reading and Writing of the image file is completed*******");
		
		

	}

}
