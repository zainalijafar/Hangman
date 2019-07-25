import java.io.File;
import java.util.Scanner;
import java.util.*;

public class FileReader {

	File file;
	Scanner reader;
	private List <String> wordList;
	
	
	public FileReader(File file) {
		this.file = file;
		this.wordList = new ArrayList<>();
	}
	
	public void readFile() {
		
		try {
			
			this.reader = new Scanner(this.file);
			String nextWord = null;
			
			while(this.reader.hasNext()) {
				
				nextWord = this.reader.nextLine();
				this.wordList.add(nextWord);
			}
			
		}catch(Exception e) {
			
			System.out.println("File does not exist");
		}
	}
	
	public String selectWord() {
		
		Random rand = new Random();
		int rando = rand.nextInt(this.wordList.size());
		return this.wordList.get(rando);
	}
}