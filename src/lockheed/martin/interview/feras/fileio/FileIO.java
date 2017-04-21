package lockheed.martin.interview.feras.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	private ArrayList wordsList;
	private File file;
	private FileWriter fw;
    private BufferedWriter bw;
	
   
    
	public String saveChanges(String fileName, String correctWord){
		
		
		try {
			file = new File(fileName);
			fw = new FileWriter(file);
			bw = new BufferedWriter(bw);
			
			bw.flush();
			bw.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "SUCCESS";
	}
	
	
	public ArrayList<String> read(String fileName){
		try {
		//	BufferedReader in = new BufferedReader(new FileReader("<Filename>"));
			Scanner in = new Scanner(new File(fileName));
			wordsList = new ArrayList<String>();
			while(in.hasNext()){
				wordsList.add(in.next());
				
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wordsList;
		
	}

}
