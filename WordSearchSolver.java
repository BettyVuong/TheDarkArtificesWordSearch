/**
 * ICS4U
 * 23/06/22
 * An object class that is the child class of WordSearch class. The class solves the word search when user interacts and inputs in main class.
 * class provides feedback to the user and updates the 2d array accordingly (removes words from the 2d array).
 */

public class WordSearchSolver extends WordSearch {
	private String[] correctWordsMod;

	// constructor
	public WordSearchSolver() {
		super();
		correctWordsMod = new String[8];
	}

	// overloaded constructor
	public WordSearchSolver(int newSet) {
		super(newSet);
		correctWordsMod = new String[8];
	}

	// overloaded constructor
	public WordSearchSolver(String[][] newSearch, String[] newWords, int newSet, String newUserWord,
			String[] newCorrectWordsMod) {
		super(newSearch, newWords, newSet, newUserWord);
		correctWordsMod = newCorrectWordsMod;
	}

	// duplicates the string array 'correctWords' from parent class, used to modify and compare to allow the method
	// 'wordChecker' to solve correctly
	// post: string array 
	public String[] duplicateWords() {
		for (int ind = 0; ind < super.correctWords().length; ind++) {
			correctWordsMod[ind] = super.correctWords()[ind]; // copying the array into a new array
		}

		return correctWordsMod;

	}

	//accessor 
	// post: reutrns string array 'correctWordsMod'
	public String[] getDuplicateWords() {
		return correctWordsMod;
	}

	// determines if the user-inputted word is one that matches the list of correct words for the search set. 
	// indicates an int value according to user-input and comment accordingly. if user has gotten the word correct 
	// and has not already been found, a method will be called for modification of the 2d array.
	// post: int value that indicates if the user entered a word that is correct or incorrect
	public int wordChecker() {
		int indication = 0;
		correctWordsMod = super.sort(correctWordsMod);

		// if-else structure is for if user enters "4" the game will exit immediately
		if (!super.getUserWord().equals("4")) {

			// add code to block

			int indicatorCorrect = super.search(super.correctWords(), super.getUserWord());// indicates if word user
																							// entered is correct
			int indicatorRepeatOrNot = super.search(correctWordsMod, super.getUserWord());// indicates if word user
																							// entered is correct but
																							// has already been entered
			// determines if string user entered is correct, been entered, or incorrect
			// legend: 1 = correct word, 2 = repeated correct word entered, and 3 =
			// incorrect word entered

			if (indicatorRepeatOrNot != -1) { // correct word and first time user has entered
				correctWordsMod[indicatorRepeatOrNot] = " ";
				if (indicatorCorrect != -1) {
					indication = 1;
				}

				wordBlocker(super.getSearch()); // blocks out the correct word in 2d array to update

			} else if (indicatorRepeatOrNot == -1) { // correct word but already entered
				if (indicatorCorrect != -1) {
					indication = 2;
				}
			} else if (indicatorRepeatOrNot == -1) { // incorrect word entered
				if (indicatorCorrect == -1) {
					indication = 3;
				}
			}

			// prints the appropriate comment and reassigns "indication" for usage in the
			// main method legend for variable
			// "indication": 1 = correct word, 2 = either incorrect or correct but user has
			// entered previously
			if (indication == 1) {
				System.out.println("Correct!\n");
				indication = 1;
			} else if (indication == 2) {
				System.out.println("Already entered this correct word, try again!\n");
				indication = 0;
			} else {
				System.out.println("Incorrect\n");
				indication = 0;
			}

			// returns 'indication' which has the value of either 1 or 0 that indicates
			// if the word user entered is correct or incorrect
			return indication;
		} else {
			// returns an int value of 8 to exit the loop from the main method from running
			// to exit the game round
			return (8);
		}

	}

	// removes words from the array for display purposes accordingly to the search set
	// pre: int 'set' indicating which search set is being used
	public void wordBlocker(int set) {
		// blocking out the word in the array
		if (set == 1) { // blocks for search set #1
			
			if(super.getUserWord().equalsIgnoreCase("curse")) { // updates if user inputed "rune"
				for (int rounds = 0, row = 2; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][11] = " ";
				}				
			} else if (super.getUserWord().equalsIgnoreCase("institute")) { // updates if user inputed "institute"
				for (int rounds = 0, columnNum = 1; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[0][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("pure")) { // updates if user inputed "pure"
				for (int rounds = 0, columnNum = 3; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[4][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("combat")) { // updates if user inputed "combat"
				for (int rounds = 0, row = 1; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][1] = " ";
				}
			} else if (super.getUserWord().equalsIgnoreCase("stone")) { // updates if user inputed "stone"
				for (int rounds = 0, row = 3; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][8] = " ";
				}
			} else if (super.getUserWord().equalsIgnoreCase("murder")) { // updates if user inputed "murder"
				for (int rounds = 0, row = 4; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][10] = " ";
				}
			} else if (super.getUserWord().equalsIgnoreCase("angel")) { // updates if user inputed "angel"
				for (int rounds = 0, columnNum = 3; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[10][columnNum] = " ";
				}
			} else if (super.getUserWord().equalsIgnoreCase("cloves")) { // updates if user inputed "cloves"
				for (int rounds = 0, columnNum = 0; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[7][columnNum] = " ";
				}
			}
		} else if (set == 2) { // blocks for search set #2
			if(super.getUserWord().equalsIgnoreCase("portal")) { // updates if user inputed "portal"
				for (int rounds = 0, columnNum = 2; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[0][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("paint")) { // updates if user inputed "paint"
				for (int rounds = 0, columnNum = 7; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[1][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("vampire")) { // updates if user inputed "vampire"
				for (int rounds = 0, row = 2; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][2] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("rose")) { // updates if user inputed "rose"
				for (int rounds = 0, row = 4; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][10] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("necromancy")) { // updates if user inputed "necromancy"
				for (int rounds = 0, row = 0; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][0] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("demon")) { // updates if user inputed "demon"
				for (int rounds = 0, columnNum = 5; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[2][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("mundane")) { // updates if user inputed "mundane"
				for (int rounds = 0, columnNum = 3; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[8][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("war")) { // updates if user inputed "war"
				for (int rounds = 0, columnNum = 5; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[11][columnNum] = " ";
				}
			}
			
		} else if (set == 3) { // blocks for search set #3
			if(super.getUserWord().equalsIgnoreCase("iron")) { // updates if user inputed "iron"
				for (int rounds = 0, columnNum = 5; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[4][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("water")) { // updates if user inputed "water"
				for (int rounds = 0, columnNum = 6; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[7][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("pearl")) { // updates if user inputed "pearl"
				for (int rounds = 0, row = 1; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][10] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("warlock")) { // updates if user inputed "warlock"
				for (int rounds = 0, columnNum = 3; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[0][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("spells")) { // updates if user inputed "spells"
				for (int rounds = 0, row = 3; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][1] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("ivy")) { // updates if user inputed "ivy"
				for (int rounds = 0, columnNum = 0; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[11][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("church")) { // updates if user inputed "church"
				for (int rounds = 0, columnNum = 4; rounds < super.getUserWord().length(); rounds++, columnNum++) {
					search[10][columnNum] = " ";
				}
			} else if(super.getUserWord().equalsIgnoreCase("beach")) { // updates if user inputed "beach"
				for (int rounds = 0, row = 2; rounds < super.getUserWord().length(); rounds++, row++) {
					search[row][3] = " ";
				}
			}
		}
	}

}
