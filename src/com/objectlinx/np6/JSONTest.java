/**
 * 
 */
package com.objectlinx.np6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.log4j.Logger;

import com.google.gson.Gson;


class Sample {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Sample [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int id;
	private int age;
	private String name;
	
	public Sample(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	
}
/**
 * @author kikanapa
 *
 */
public class JSONTest {
	
	private static final Logger log = Logger.getLogger(JSONTest.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample s1 = new Sample(1,25,"Kiran");
		Sample s2 = new Sample(2,30,"Rams");
		
		Gson gson = new Gson();
		String json1 = gson.toJson(s1);
		String json2 = gson.toJson(s2);
		String jsonFilePath = "simple.json";
		File file = new File(jsonFilePath);
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bwr1 = new BufferedWriter(fw);
			bwr1.write(json1);
			bwr1.write(json2);
			//fw.write(json);
		//	fw.close();
			bwr1.close();
			log.info("Saved the json file to the file simple.json");
			System.out.println("Json file outout : "+ json1+" "+ json2);
			log.info("Now Reading the contents from JSON file simple.json");
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			FileWriter outFile = new FileWriter("outfilejson.txt");
			int length = 0;
			BufferedWriter bw2 = new BufferedWriter(outFile);
			String bufLine = null;
			while((bufLine = br.readLine())!= null) {
				log.info("Writing the line using the BufferedOutputStream : "+ bufLine);
				bw2.write(bufLine);
				
			}
/*			while((length=reader.read())!=-1) {
				System.out.println("writing the char/int :"+ length);	
				outFile.write((length));
			}
*/	/*		reader.close();
			outFile.flush();
			outFile.close();*/
			bw2.close();
			br.close();
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}

}
