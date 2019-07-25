import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hangman {
	
	Scanner reader; 
	FileReader fileReader;
	private int trials;
	private StringBuilder display;
	Map<Character,List<Integer>> myMap;

	public Hangman() {
		this.trials = 0;
		this.myMap = new HashMap<>();
	}
	
	public void start() {
		
		boolean won = true;
		boolean guessWord = false; 
		
		System.out.println("Welcome to Hangman");
		System.out.println("You have 5 tries to guess the letters");
		System.out.println("Choose your category : ");
		System.out.println("[1] Cities of Canada");
		System.out.println("[2] Cities of USA");
		
		this.reader = new Scanner(System.in);
		
		String readerString = this.reader.nextLine();
		
		int readerChoice = parseStringtoInt(readerString);
		
		userChoice(readerChoice);
		String selectedWord = this.fileReader.selectWord();
		System.out.println(displayWord(selectedWord));
		
		while(this.trials<6) {
		
			System.out.println("Enter a letter: ");
			String userInput = this.reader.nextLine();
			char userInputChar = userInput.charAt(0);
			fillLetter(selectedWord,userInputChar);
			System.out.println(this.display);
		
			for(int i=0; i<this.display.length(); i++) {
			
				if(this.display.charAt(i) == '*') {
				won = false;
				guessWord = false;
				break;
				}
				guessWord = true;
			}
			if(guessWord) {
				System.out.println("You have won the game");
				break;
			}
		}
		if(!won && !guessWord) {
			System.out.println("You have lost the game ");
		}
	}
	
	public void checkCharacter(String word,char userInput) {
		
		boolean wordContained = false;
		
		for(int i=0; i<word.length(); i++) {
			
			if(word.charAt(i) != userInput) {
				continue;
			}else {
				System.out.println("Contained");
				wordContained = true;
				break;
			}
		}
		if(!wordContained) {
			System.out.println("Not Contained ");
		}
	}
	
	public Map<Character,List<Integer>> findIndex(String word,char userInput) {
		
		List<Integer> myList = new ArrayList<>();
		
		for(int i=0; i<word.length(); i++) {
			
			if(word.charAt(i) == userInput) {
				myList.add(i);
			}
			myMap.put(userInput,myList);
		}
		return myMap;
	}
	
	public void fillLetter(String word,char userInput) {
	
		boolean found = false; 
		
		for(int i=0; i<word.length(); i++) {
			
			if(word.charAt(i) == userInput && display.charAt(i) == '*') {
				
				this.display.setCharAt(i,userInput);
				found = true; 
			}
		}
		if(!found) {
			trials++;
		}
		System.out.println("You have used : " + trials);
	}
	
	public StringBuilder displayWord(String word) {
		
		String display = "";
		
		for(int i=0; i<word.length(); i++) {
			
			display = display + "*";
		}
		this.display = new StringBuilder(display);		
		return this.display; 
	}
	
	public void userChoice(int i) {
		
		if(i==1) {
			
			File file = new File("Canada.txt");
			this.fileReader = new FileReader(file);
			this.fileReader.readFile();
			
		}else if (i==2) {
			
			File file = new File("USA.txt");
			this.fileReader = new FileReader(file);
			this.fileReader.readFile();
		}
	}
	
	public int parseStringtoInt(String s) {
		
		int number = Integer.parseInt(s);
		return number;
	}
}