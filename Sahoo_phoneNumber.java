/*Ankur Sahoo
 * Period 3
 * Project: Phone Number Word Generator
 * This program generates all the combinations of words 
 * that corresponds to a phone number and prints out those
 * that are real english words 
 * */

import java.io.*;
import java.util.*;

public class Sahoo_phoneNumber {

	//const String array for storing all the letters for each number
	public static final String [] PHONE_LETTERS = {"abc","def","ghi","jkl","mno","prs","tuv", "wxy"};

	public static void main(String[] args) {

		Scanner fileIn = null;
		Scanner keyboard = new Scanner (System.in);
		String [] words = null;
		int index = 0;
		words = writeToArray(words);

		System.out.print("Enter the phone number: ");
		String pNumber = keyboard.nextLine();
		

		generateWord(pNumber, index, "", words);

	}

	/*generates all possible combinations of words for the phone number
	and prints out those that are real words
	*/
	public static void generateWord(String pNumber, int index, String wordSoFar, String[] words)
	{
		if (index==PHONE_LETTERS.length-1)
		{
			for (int i = 0; i<words.length; i++)//checks if the current word is a real word
			{
				if (wordSoFar.equals(words[i]))
					System.out.println(wordSoFar);
			}
			wordSoFar = "";
			index = 0;
		}
		else
		{
			for (int i = 0; i<3; i++)
			{
				String currentNum = pNumber.substring(index, index+1);
				generateWord(pNumber, index+1,(wordSoFar+PHONE_LETTERS[(Integer.parseInt(currentNum))-2].substring(i,i+1)), words);
			}
		}

	}

	//copies the text from the text file to an array
	public static String [] writeToArray(String[] words)
	{
		Scanner fileIn = null;
		int size = 0;
		int i = 0;

		String dictionary [] = null;

		try{
			fileIn = new Scanner (new File ("updatedWords.txt"));
			while(fileIn.hasNextLine())
			{
				fileIn.nextLine();
				size+=1;
			}

		}catch(FileNotFoundException e)
		{
			System.out.print("File not found");
			System.exit(-1);
		}

		try {
			fileIn = new Scanner (new File ("updatedWords.txt"));
		} catch (FileNotFoundException e) {
			System.out.print("File not found");
			System.exit(-1);
		}

		dictionary = new String [size];

		while(fileIn.hasNextLine())
		{
			dictionary[i] = fileIn.nextLine();
			i+=1;
		}
		fileIn.close();

		return dictionary;
	}





















}
