package it.car.yelp.intrw.io;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteReadOnFile {

	public static void main(String args[]){

		writeOnFile();
//		appendToCheckbook();

	}

	public static void readFromFile(){
		String nameFile = "test";

	}

	public static void writeOnFile(){
		String test = "I'm writing on file";
		String nameFile = "test";

		File file = null;
		BufferedWriter buff = null;
		FileWriter fw = null;
		PrintWriter pw = null;

		try{

			file = new File(nameFile);
			if(!file.exists()){
				file.createNewFile();
			}

			fw = new FileWriter(file, true);
			buff = new BufferedWriter(fw);

			for(int i = 0; i < 10 ; i++){
				buff.write(test);
				buff.newLine();
			}

			buff.flush();

		}catch (Exception e){
			e.printStackTrace();
		}finally{
			// I'm closing the scanner and fileInputStream
			try{
				if(buff != null) buff.close();
				if(fw != null) fw.close();
				if(pw != null) pw.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}

		}

	}

	public static void appendToCheckbook () {

		BufferedWriter bw = null;

		try {
			// APPEND MODE SET HERE
			bw = new BufferedWriter(new FileWriter("test", true));
			bw.write("400:08311998:Inprise Corporation:249.95");
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {                       // always close the file
			if (bw != null) try {
				bw.close();
			} catch (IOException ioe2) {
				// just ignore it
			}
		} // end try/catch/finally

	} // end test()

}
