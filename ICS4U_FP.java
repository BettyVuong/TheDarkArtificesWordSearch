/**
 * Betty Vuong 
 * ICS4U
 * 23/06/22
 * Program is a themed story line word search based off of The Shadowhunter Chronicles book realm. The class works along with these 
 * classes: Stack, StopWatch, WordSearch, and WordSearchSolver in order to allow user to see their timed rounds via scoreboard, solve
 * word search puzzles based on the theme. The menu prompts and allows user to start playing the game, look at game instructions,
 * scoreboard, and exit the game. They go through the game through the perspective of Emma Carstairs. Once they start playing the game 
 * their duration playing the game is timed, depending on the duration of the first round, they will have a different storyline and word
 * search. If user solves both word searches, they are prompted with missing words and a fill in the blank. If user enters the fill in the 
 * blank sucessfully, they are shown the scoreboard. User can exit the game at any point. once exiting the game or finishing the game, user 
 * is reprompted with the menu.
 */

import java.util.*;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ICS4U_FP {

	public static void main(String[] args) {
		int play = 0;

		System.out.println("-----------------The Dark Artifices-----------------");

		// game's initiated until user wants to exit
		do {
			// menu is prompted from the method call, unless the user enters '2' within the
			// menu() method, loop is exited
			do {
				play = menu();
			} while (play == 2 || play == 3); // user want to view instructions or scoreboard

			// game plays if user enters 1 within the menu(); method
			if (play == 1) {
				playGame(); // calls method that plays the word search
			}

		} while (play != 4); //if user wanted to exit

	}

	// outputs a menu and prompts user with options to play the word search, view game instructions, view scoreboard,
	//or exit the game
	// post: returns an int value from 1-4
	public static int menu() {
		System.out.print("\nMenu:\n1. Play game\n2. Game instructions\n3. Score board\n4. Exit\nEnter an option: ");
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		input.nextLine();

		// if user does not enter one of the valid options, they are prompted to
		// re-enter an option until they do
		while (option < 1 || option > 4) {
			System.out.print(
					"\nPlease enter a valid option.\nMenu:\n1. Play game\n2. Game instructions\n3. Score board\n4. Exit\nEnter an option: ");
			option = input.nextInt();
			input.nextLine();
		}

		// option #2, #3, and #4
		if (option == 2) {
			System.out.println(
					"\n----------------------------------------------------\n\nINSTRUCTIONS\n\nTo start the game, enter \"1\"; to learn more about \nthe"
							+ " game and instructions, enter \" 2\", to view the \nscoreboard enter \"3\" to exit, and enter \"4\". *Note \nthat if at any point you "
							+ "want to exit the game \nwhen playing a round, enter \"4\"* \n\nThe overall objective of the program is that\nyou are on a "
							+ "mission in the Shadow "
							+ "World,\n a book realm based off of The Shadowhunter\nChronicles. Where the mission is to retrieve the Black \nVolume of the "
							+ "Dead which"
							+ " would explain the ongoing \nmurders in their universe. You will have \nto solve timed word puzzles to retrieve the \nmissing "
							+ "words used "
							+ "to unlock the Black Volume\nof the Dead. Depending on the timing and \ncharacter, you will have possibly 2 different storylines "
							+ "\nwith the "
							+ "word search's changed. If you don't solve \nthe mission in time, your character will die."
							+ "\n\nRULES\n\n1. You cannot retype a correct word, \n   it"
							+ " will be considered incorrect.\n\n2. If you type in more than one word, \n   it'll be considered incorrect.\n"
							+ "\n----------------------------------------------------");
		} else if (option == 4) {
			System.out.println(
					"\n----------------------------------------------------\n\n     Thank you for playing The Dark Artificies"
							+ "\n\n----------------------------------------------------\n");
		} else if (option == 3) {
			//scoreboard displayed by calling method
			scoreBoard();
		}

		// returns an option from 1-4 that corresponds to what option user chooses
		return (option);
	}

	//starts the word search games, displays storylines, timer, current time, etc. displays word search game and allow
	//user to interact with the game in order to play. Records time for score board and displays score board via method calling.
	public static void playGame() {
		Scanner input = new Scanner(System.in);
		//calling instances of objects
		StopWatch s = new StopWatch();
		Stack searchSetOrder = new Stack();
		WordSearchSolver searchPart2 = new WordSearchSolver();
		boolean scoreTimeValid = false; //indicates if the time the stopwatch timed will be recorded into the
										//scoreboard

		// start stopwatch
		s.startWatch();

		System.out.println("----------------------------------------------------");

		// prints timer stamp
		s.getElapsedSecs();
		System.out.println("Time elapsed: " + s + "\n\nEmma Carstairs\n--------------");

		// prints current time
		LocalTime time1 = LocalTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
		System.out.println("\n" + time1.format(timeFormat));

		System.out.println("Recently, I’ve been hearing about these murders at \n" + "the shadow market…\n"
				+ "These murder victims have the same scripts on their \n"
				+ "skin as my parents' bodies had. I’ve been tipped off \n"
				+ "by Johnny that the answer may lay in The Black Volume \n"
				+ "of the Dead. But Mark has said that the ley lines \n"
				+ "will help me retrieve the dark artifice.\n");

		String contGame = input.nextLine();// used for user interaction puposes

		// prints current time
		time1 = LocalTime.now();
		System.out.println(time1.format(timeFormat));

		System.out.println("I must go to the convergence point,that's where the\nley lines are.\n");

		contGame = input.nextLine();

		// prints current time
		time1 = LocalTime.now();
		System.out.println(time1.format(timeFormat));

		System.out.println("I found a cave… and another body.\n\nLocation: Convergence Point\n");

		// prints timer stamp
		s.getElapsedSecs();
		System.out.println("Time elapsed: " + s);

		contGame = input.nextLine();

		stackOrder(searchSetOrder, 1); //sets up stack for the word search set order

		// this is for word search calling
		int set = searchSetOrder.pop(); // pops the search set indicator by stack
		WordSearchSolver searchPart1 = new WordSearchSolver(set); // creates an object with the set in parameters
		
		wordSearchSolverSetUp(searchPart1, set); // for word search calling, sets up the necessary functions to start the word search round

		s.getElapsedSecs(); // gets the time elapsed since the first word search
		
		//round two of word search
		if (!searchPart1.getUserWord().equals("4")) { // second round of word search runs if user has not entered "4" 
													  // to exit the round
			//story line and word search changes depending on how long user took to solve the first word search
			if (s.getMins() < 10) { // user is still in the normal universe, normal time line		
				//storyline continued
				// prints current time
				time1 = LocalTime.now();
				System.out.println("\n" + time1.format(timeFormat) + "\nJulian found another location, where Malcolm is \n"
						+ "attending. It’s called The Lottery.\n");
				
				contGame = input.nextLine();
				
				// prints current time
				time1 = LocalTime.now();
				System.out.println(time1.format(timeFormat) + "\nI went to the Lottery and... "
						+ "\nI fear that I may have found another dead body.");
				
				contGame = input.nextLine();
				
				// prints current time
				time1 = LocalTime.now();
				System.out.println(time1.format(timeFormat) + "\nThe\nSame\nMarks\nOf\nScript\nOn\nThe\nVictim\n\nLocation: The Lottery");
				
				contGame = input.nextLine();
				
				// prints timer stamp
				s.getElapsedSecs();
				System.out.println("Time elapsed: " + s);

				contGame = input.nextLine();
				
				set = searchSetOrder.pop();
				searchPart2.setSearch(set); 
				wordSearchSolverSetUp(searchPart2, set); // for word search calling, sets up the necessary functions to start the word search round
			} else if(s.getMins() > 10) { // user is in a different universe, different word search set and story line
				// prints current time
				time1 = LocalTime.now();
				System.out.println("\n" + time1.format(timeFormat) + "\nOh no! Since I couldn't solve the search in time,\n I think the "
						+ "murderer sent us to Thule.");
				
				contGame = input.nextLine();
				
				// prints current time
				time1 = LocalTime.now();
				System.out.println("\n" + time1.format(timeFormat) + "\nThule is an alternate universe, this place has\nnot "
						+ "survived the war. They all seem to think I'm \ngoing to harm them.");
				
				contGame = input.nextLine();
				
				// prints current time
				time1 = LocalTime.now();
				System.out.println("\n" + time1.format(timeFormat) + "\nI need to solve this search and leave this universe."
						+ "\nIf not, I'll probably get killed.");
				
				stackOrder(searchSetOrder, 2); //changes the word search set for round 2
				set = searchSetOrder.pop();
				searchPart2.setSearch(set);
				wordSearchSolverSetUp(searchPart2, set); // for word search calling, sets up the necessary functions to start the word search round
				
				if (searchPart2.getUserWord().equals("4")) {
					s.stopWatch(); //stops the stopwatch
					scoreTimeValid = false; //time is not recorded to score board
					// prints current time
					time1 = LocalTime.now();
					System.out.println("\n" + time1.format(timeFormat) + "\nYou're still stuck in Thule...");
					
					contGame = input.nextLine();
					
					// prints current time
					time1 = LocalTime.now();
					System.out.println("\n" + time1.format(timeFormat) + "\nCurrent status: Murdered");
				}
			}
			
			//user fills in the blank portion of the game, if user fills in the blank correctly, they've solved the motive
			if (!searchPart2.getUserWord().equals("4")) { // if users inputted word doesn't equal "4", condition runs
				s.getElapsedSecs(); // gets the time elapsed since the first word search
				
				// prints timer stamp
				s.getElapsedSecs();
				System.out.println("Time elapsed: " + s);
				
				// prints current time
				time1 = LocalTime.now();
				System.out.println("\n" + time1.format(timeFormat));
				System.out.println("In order to open The Black Volume of the Dead, \n"
						+ "I must enter the correct password with the words\n"
						+ "I found.\n\nWords Collected:\nA, N, B\n\nFill in the blank \n"
						+ "A _ N _ _ EL \n\nEnter the word:");

				String fillTheBlank = input.nextLine();

				// checking to see if user enters more than one word
				fillTheBlank = fillTheBlank.trim();

				// tell the user the outcome of the game depending on if they guessed correctly
				if (fillTheBlank.equalsIgnoreCase("annabel")) {
					s.stopWatch(); //stops the stopwatch
					scoreTimeValid = true; //time is recorded to score board
					
					System.out.println(
							"\n----------------------------------------------------\n\n                  Murder solved\n\n"
									+ "----------------------------------------------------\n\n" + "\n"
									+ "Malcolm Fade and Annabel Blackthorn were lovers who\n"
									+ "stole the The Black Volume of the Dead. Annabel was \n"
									+ "Caught, her family was ashamed of her actions. While \n"
									+ "Malcolm escaped unscathed. Annabel was buried alive.\n"
									+ "Malcolm tried to resurrect Annabel for centuries \n"
									+ "Later once he found out about Annabel's death, a \n"
									+ "tragic love story. In Malcolm’s ritual, he killed \n"
									+ "Emma’s parents to complete the spell. The spell had \n"
									+ "failed. He went to resurrect Annabel once again and \n"
									+ "started leaving the same script on other victims. \n"
									+ "\nA tell tale of Annabel Lee.\n");
				} else {
					s.stopWatch(); //stops the stopwatch
					scoreTimeValid = false; //time is not recorded to score board
					System.out.println(
							"\n----------------------------------------------------\n\n               Murder Unsolved\n\n");
				}
			}
		}

		System.out.println(
				"\n----------------------------------------------------\n\n                 Game round ended\n\n"
						+ "----------------------------------------------------");
		if (scoreTimeValid == true) {
		scoreBoard(s);
		}
	}

	// allows user to input word found in the word search
	// post: returns string 'userword' user entered
	public static String userInteraction() {
		int spaceCount = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter word: ");
		String userWord = input.nextLine();

		// checking to see if user enters more than one word
		userWord = userWord.trim();

		// returns 'userWord' which is what the user enters if they possibly find a word
		// on the 2D array
		return (userWord);
	}
	
	// displays game, allows user input their guesses via method calling, displays word left to search for,
	// calculates and determine if user enters the correct guesses
	//pre: object instance of WordSearchSolver 'search'

	public static void stackOrder(Stack searchSetOrder, int universe) {
		if (universe == 1) {
			searchSetOrder.push(2);
			searchSetOrder.push(1);
		} else if (universe == 2) {
			searchSetOrder.makeEmpty(); // removes all the values from the stack
			searchSetOrder.push(3);
		}
	}

	//where the game actually runs, checks, prints, etc.
	public static void searchGame(WordSearchSolver search) {
		int round = 0, correctPerWord = 0, correctTotal = 0, wordsLeft = 0;
		do {

			if (correctPerWord == 1 || round == 0) {
				search.userArrayDisplay(); // displays the array

				// tells user how many words the have left to search for
				wordsLeft = 8 - correctTotal;
				System.out.println("\nWords left to search for: " + wordsLeft);

				search.setUserWord(userInteraction()); // prompts user to enter in a word, sets user word for object
				correctPerWord = search.wordChecker();
				// if user enters 4 within the game, the game round is exited immediately
				if (correctPerWord == 8) {
					correctTotal = 8;
				} else {
					correctTotal += correctPerWord; // if user enters correct word, it'll be added. variables make
													// sure that the users correct words only count once
				}
			} else { // pauses printing the 2D array and makes user enter words until they enter a
						// correct one
				search.setUserWord(userInteraction()); // prompts user to enter in a word, sets user word for object
				correctPerWord = search.wordChecker();
				// if user enters 3 within the game, the game round is exited immediately
				if (correctPerWord == 8) {
					correctTotal = 8;
				} else {
					correctTotal += correctPerWord; // if user enters correct word, it'll be added. variables make
													// sure that the users correct words only count once
				}
			}

			round++;
		} while (correctTotal < 8); // the game will stop once all 8 words are entered

		if (!search.getUserWord().equals("4")) {
			search.userArrayDisplay(); // displays the array one last time
		}

		// prints the remaining words if game wasn't completed
		if (search.getUserWord().equals("4")) {
			System.out.print("\nRemaining words: ");

			for (int index = 0; index < search.getDuplicateWords().length; index++) {
				if (!search.getDuplicateWords()[index].equals(" ")) {
					if (index != 7) {
						System.out.print("\n- " + search.getDuplicateWords()[index]);
					} else {
						System.out.print("\n- " + search.getDuplicateWords()[index] + "\n");
					}
				}
			}

			System.out.println(
					"\n----------------------------------------------------\n\n                  Murder Unsolved");
		}
	}

	// for word search calling, sets up the necessary functions to start the word search round
	// for each instance of the object created. Calls the method for the word search to start playing
	// (e.g. displaying the word search, determining correct inputs, etc.)
	//pre: object instance of WordSearchSolver 'search', int 'set' 
	public static void wordSearchSolverSetUp(WordSearchSolver search, int set) {
		search.setSearch(set); // sets the search set
		search.wordSearchArray(set); // calls to read file to 2d array
		search.correctWords();
		search.duplicateWords();
		
		//starts the word search for round one
		searchGame(search);
	}
	
	// overloaded method that reads and stores the scoreboard from file to arraylist, sorts the scoreboard, displays the scoreboard, 
	// and writes to the file
	//pre: object instance of Stopwatch 's'
	public static void scoreBoard(StopWatch s) {
		File scoreBoardFile = new File ("/Users/bettyvuong/eclipse-workspace/ICS4U_Final_Proj/src/ScoreBoardTimeList");
		
		
		ArrayList<Long> scoreBoardTimes = readToArrayList(scoreBoardFile); //read from file to arraylist
		
		scoreBoardTimes.add(s.getElapsedSecs()); //adds the elapsed time into scoreboard
		
		if(scoreBoardTimes.size() > 0) { //sorts if the array list has more than one index
		scoreBoardTimes = bubbleSortList(scoreBoardTimes); //sorts the times from greatest time to least time
		}
		System.out.print("\n                   Scoreboard"
		 		+ "\n\n----------------------------------------------------\n");
		
		//prints arraylist in order
		for(int i = 0; i < scoreBoardTimes.size(); i++) {
			System.out.println(i + " | " + s.toString(scoreBoardTimes.get(i)));
		}
		
		System.out.println("\n----------------------------------------------------");
		
		writeArrayListToFile(scoreBoardTimes, scoreBoardFile); //write arraylist to file
		
	}

	// overloaded method that reads and stores the scoreboard from file to arraylist, sorts the scoreboard, displays the scoreboard
	public static void scoreBoard() {
		File scoreBoardFile = new File ("/Users/bettyvuong/eclipse-workspace/ICS4U_Final_Proj/src/ScoreBoardTimeList");
		StopWatch stopWatchTemp = new StopWatch();
		
		ArrayList<Long> scoreBoardTimes = readToArrayList(scoreBoardFile); //read from file to arraylist
		
		if(scoreBoardTimes.size() > 0) { //sorts if the array list has more than one index
			scoreBoardTimes = bubbleSortList(scoreBoardTimes); //sorts the times from greatest time to least time
			}
		
		System.out.print("\n----------------------------------------------------\n\n                   Scoreboard"
		 		+ "\n\n----------------------------------------------------");
		
		//prints arraylist in order
		for(int i = 0; i < scoreBoardTimes.size(); i++) {
			System.out.println(i+1 + " | " + stopWatchTemp.toString(scoreBoardTimes.get(i)));
		}
		
		System.out.println("\n----------------------------------------------------");
	}
	
	// reads file to arraylist type long, parses the values to be applicable for the program
	// pre: file 'file'
	// post: returns an ArrayList of long type that is used for the scoreboard
	public static ArrayList<Long> readToArrayList(File file) {
		//reads file to arraylist
		ArrayList<Long> scoreBoardTimes = new ArrayList<Long>(); // initializing an arraylist
		
		try {
           //opening file reader
		Scanner myReader = new Scanner(file);
		
		//will loop after each line and will stop looping when there are no more lines to read in file
		 while (myReader.hasNextLine()) {
			 long num = Long.parseLong(myReader.nextLine()); //parses from string to long data type
			 scoreBoardTimes.add(num); //adds element to arraylist
		 }
		
		 myReader.close();
		} catch (FileNotFoundException e) { //Catches FileNotFoundError
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		
		return scoreBoardTimes; //returns long arrayList
	}
	
	// writes arraylist to file 
	// pre: ArrayList long type 'scoreBoardTimes', file 'scoreBoardFile'
	public static void writeArrayListToFile(ArrayList<Long> scoreBoardTimes, File scoreBoardFile) {
		try {
			//opening file writer and  bufferwriter
			FileWriter fw = new FileWriter(scoreBoardFile);
			Writer output = new BufferedWriter(fw);
			//writing arraylist to file
			for (int i = 0; i < scoreBoardTimes.size(); i++) {
				output.write(scoreBoardTimes.get(i).toString() + "\n");
			}
			
			//closing FileWriter and Writer
			output.close();
			fw.close();
		} catch (Exception e) { //catches an problems while writing to file
			System.out.println("An error occurred updating files");
		}
	}
	
	
	// bubble sorts the arraylist of long types by ascending order for scoreboard feature
	// pre: ArrayList long type 'list'
	// post: returns an ArrayList of long type that is sorted and used for the scoreboard
	public static ArrayList<Long> bubbleSortList(ArrayList<Long> list){
		long temp;
		boolean swap = true;

		for (int i = list.size() - 1; i > 0 && swap; i--) {
			swap = false;

			for (int ind = 0; ind < i; ind++) {
				if (list.get(ind).compareTo(list.get(ind + 1)) > 0) { //if a swap needs to be done
	                temp = list.get(ind);
	                list.set(ind, list.get(ind + 1));
	                list.set(ind + 1, temp);
	                swap = false;
				}
			}
		}
		return list;
	}
}
