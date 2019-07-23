import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

	private Scanner reader; 
	private FileRead fileRead;
	private String selectedWord;
	
	public Hangman() {
		this.reader = new Scanner(System.in);
	}
	
	public void start() {
	
		userInterface();
		System.out.println(displayWord());
		System.out.println("Enter a letter ");
		String userInput = this.reader.nextLine();
		char [] charToArray = userInput.toCharArray();
		char userInputChar = charToArray[0];
				
		int index = 0;
		
		for(int i=0; i<selectedWord.length(); i++) {
			
			
		}
	}
	
	public void userInterface() {
		System.out.println("Welcome to Hangman");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Select the desired Category : ");
		System.out.println("[1] Cities of Canada ");
		System.out.println("[2] Cities of USA ");
		
		String input = this.reader.nextLine();
		
		int selection = parseStringToInt(input);
		
		checkInput(selection);
	}
	
	public void checkInput(int i) {
		
		if(i==1) {
			File fileCanada = new File("Canada.txt");
			this.fileRead = new FileRead(fileCanada);
		}else if (i==2) {
			File fileUSA = new File("USA.txt");
			this.fileRead = new FileRead(fileUSA);
		}
	}
	
	public int parseStringToInt(String input) {
		
		int number = Integer.parseInt(input);
		
		return number;
	}
	
	public String displayWord() {
		
		this.fileRead.readFile();
		selectedWord = this.fileRead.selectWord();
		System.out.println(selectedWord);
		String display = "";
		
		for(int i=0; i<selectedWord.length(); i++) {
			display = display + "_" + " ";
		}
		return display;
	}
	
	public List<Integer> findIndex(String word,char letter) {
		
		int index = 0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<word.length(); i++) {
			
			if(word.charAt(i)==letter) {
				index = i;
				list.add(index);
			}
		}
		return list;
	}
}