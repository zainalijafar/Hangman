import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileRead {

	public File file;
	public Scanner reader;
	public List<String> wordList;
	
	public FileRead(File file) {
		this.file = file;
		this.wordList = new ArrayList<>();
	}
	
	public void readFile() {
		
		try {
			this.reader = new Scanner(this.file);
			String nextWord = this.reader.nextLine();
			
			while(this.reader.hasNextLine()) {
				
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