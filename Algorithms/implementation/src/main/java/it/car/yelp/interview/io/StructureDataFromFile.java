package it.car.yelp.interview.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class StructureDataFromFile {

	/**
	 * http://www.javapractices.com/topic/TopicAction.do?Id=42
	 * @param args
	 */

	public static void main(String args[]){
		String fileName = "data_yelp";
		List<String> data = new ArrayList<>();

		//scanner
		scannerFillDataStructure(data, fileName);
		Collections.sort(data);
		System.out.println("Scanner \n" + data);

		//reset
		data.clear();

		//fileReader
		fileReaderFillDataStructure(data, fileName);
		Collections.sort(data);
		System.out.println("FileReader \n" + data);
	}

	/**
	 * Scanner sample
	 */
	public static void scannerFillDataStructure(List<String> list, String fileName){
		
		FileInputStream fis = null;
		Scanner scanner = null;

		try{
			
			fis = new FileInputStream(fileName);
			scanner = new Scanner(fis, "UTF-8");
			String tmp = "";
			while(scanner.hasNext()){
				tmp = scanner.next();
				if(!tmp.equals(""))
					list.add(tmp);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//close
			try{
				if(fis != null)
					fis.close();
				if(scanner != null)
					scanner.close();

			}catch(Exception e1){
				e1.printStackTrace();
			}

		}


	}

	/**
	 * FileReader sample
	 */
	public static void fileReaderFillDataStructure(List<String> list, String fileName){
		File file = null;
		FileReader fr = null;
		BufferedReader buff = null;
		
		try{
			file = new File(fileName);
			fr = new FileReader(file);
			buff = new BufferedReader(fr);
			String l = "";
			while( (l = buff.readLine()) != null){
				if(!l.equals(""))
					list.add(l);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)
					fr.close();
				if(buff != null)
					buff.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
		
	}

}
