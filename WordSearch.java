/**
 * ICS4U
 * 23/06/22
 * An object class that is the skeleton of the word search. Class reads files to 2d arrays, displays 2d array, and sort and searches arrays. 
 */

import java.util.*;
import java.io.*;

public class WordSearch {
	Random rand = new Random();
	static String[][] search;
	private String[] wordsFixed;
	private int set;
	private String userWord;

	//constructor method
	public WordSearch() {
		search = new String[12][12];
		wordsFixed = new String[8];
		set = 0;
		userWord = "";
	}
	
	//overloaded constructor method
	public WordSearch(int newSet) {
		search = new String[12][12];
		wordsFixed = new String[8];
		set = newSet;
		userWord = "";
	}
	
	//overloaded constructor method
	public WordSearch(String[][] newSearch, String[] newWords, int newSet, String newUserWord) {
		search = newSearch;
		wordsFixed = newWords;
		set = newSet;
		userWord = newUserWord;
	}
	
	// modifier
	// sets set to the set used in main
	// pre: int 'set'
	public void setSearch(int newSet) {
		set = newSet;
		
	}
	
	// accessor
	// post: returns int 'set'
	public int getSearch() {
		return set;
	}
	
	// modifier
	// sets userword to user inputted userword
	public void setUserWord(String newUserWord) {
		userWord = newUserWord;
	}
	
	// accessor
	// post: returns String 'userWord'
	public String getUserWord() {
		return userWord;
	}
	
	// allocates the correct file to be used for reading file to array
	// pre: int 'searchSet'
	public void wordSearchArray(int searchSet) {
		File searchFile = new File ("/Users/bettyvuong/eclipse-workspace/ICS4U_Final_Proj/Search 1 File");
		
		//expand on this
		if(searchSet == 1) {
			searchFile = new File ("/Users/bettyvuong/eclipse-workspace/ICS4U_Final_Proj/Search 1 File");
		} else if (searchSet == 2) {
			searchFile = new File ("/Users/bettyvuong/eclipse-workspace/ICS4U_Final_Proj/src/Search 2 File");
		} else if (searchSet == 3) {
			searchFile = new File ("/Users/bettyvuong/eclipse-workspace/ICS4U_Final_Proj/src/Search 3 File");
		}
		
		//read file to array
		search = readFileToArray(searchFile);
	}
	
	// reads file to 2d string array
	// pre: file 'file'
	// post: returns an 2d string array that is used for word search
	public String[][] readFileToArray(File file){
		
		//reading file
		String[][] searchArray = new String[0][]; //initializing array
        try {
            //opening file reader
            Scanner myReader = new Scanner(file);
            int index = 0;
            //will loop after each line and will stop looping when there are no more lines to read in file
            while (myReader.hasNextLine()) {
                //increasing array length by one
                int length = searchArray.length;
                String[][] temp = new String[length + 1][];
                for (int i = 0; i < length; i++){ //copying to temp array
                    temp[i] = searchArray[i];
                }
                searchArray = temp;
                //split the line into an array of Strings
                String[] data = myReader.nextLine().split(" "); //space separate each String
                searchArray[index] = data; //sets last index of returnArray to data
                index += 1;
            }
        } catch (FileNotFoundException e) { //Catches FileNotFoundError
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return searchArray; //returns 2D array
	}
	
	// creates an array of strings that has the correlated correct words to the search set and sorts the array
	// post: array of strings
	public String[] correctWords() {
		//list of correct words according to search set
		String[] set1 = {"curse", "pure", "institute", "combat", "stone", "murder", "angel", "cloves"};
		String[] set2 = {"portal", "paint", "vampire", "rose", "necromancy", "demon", "mundane", "war"};
		String[] set3 = {"iron", "water", "pearl", "warlock", "spells", "ivy", "church", "beach"};

		// assigns array with correct words of a theme array according to theme
		if (set == 1) {
			wordsFixed = set1;
		} else if (set == 2) {
			wordsFixed = set2;
		} else if (set == 3) {
			wordsFixed = set3;
		}
		
		sort(wordsFixed); //sorts the array of words to be used in child class
		// returns 'words' with the array of "permanent/correct" words 
		return (wordsFixed);
	}
	
	// Prints String 2D array via method calling for recursion
	// pre: String 2D array
	public void userArrayDisplay() {
		System.out.println("      Word Search      ");
		displayArray(search, 0,0);

	}
	
	// displays 2d array recursively. recursivey iterates through every column and row of the search to display it
	// to the user
	// pre: 2D Array for word search 'search', int 'row' and 'col' values that are updated after every
	// recursive call
	public static void displayArray(String[][] search, int row, int col) {
		// prints 2d array using recursion
		if (row < search.length) { // iterate through all (11) rows
			if (col < search[row].length) { // iterate through all (11) columns
				System.out.print(search[row][col] + " "); // displays the current index in the array
				displayArray(search, row, col + 1); // repeats this method by iterating through the columns first
				return;
			}

			System.out.println(); // enters the line after each row for display purposes

			displayArray(search, row + 1, col = 0); // repeats this method by iterating through the rows
		}
	}
	
	// bubble sorts array of strings
	// pre: string 2d array 'wordArr'
	// post: string 2d array 
	public String[] sort(String[] wordArr) {
		boolean swap = true;

		for (int i = wordArr.length - 1; i > 0 && swap; i--) {
			swap = false;

			for (int ind = 0; ind < i; ind++) {
				if (wordArr[ind].compareToIgnoreCase(wordArr[ind + 1]) > 0) { //if a swap needs to be done
					String temp = wordArr[ind];
					wordArr[ind] = wordArr[ind + 1];
					wordArr[ind + 1] = temp;
					swap = true;
				}
			}
		}
		
		return wordArr;
	}

	// binary search, searches for the string 'word' in the string array
	// pre: string array 'arr, string 'word'
	// post: returns int value that indicates the index where the word that is desired to be searched found on the array
	// if word was not found on the array, int value returned is "-1"
	public int search(String[] arr, String word) {
		// where "word" is the word that is being searched

		int bottom = 0; // lowest index
		int index = -1;
		int top = arr.length - 1;
		int middle;

		while (bottom <= top) {
			middle = bottom + ((top - bottom) / 2); // middle index

			if (arr[middle].compareToIgnoreCase(word) > 0) { // if the word is in the lower half
				top = middle - 1;
			} else if (arr[middle].compareToIgnoreCase(word) < 0) { // if the word is in the upper half
				bottom = middle + 1;
			} else if (arr[middle].compareToIgnoreCase(word) == 0) { // if the middle index is the word
				index = middle;
				return index;
			}

		}

		return -1; // if the element is not in the array

	}

}


