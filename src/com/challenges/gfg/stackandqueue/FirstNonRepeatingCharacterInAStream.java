package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
 * 
 * Given an input stream of N characters consisting only of lower case
 * alphabets. The task is to find the first non repeating character, each time a
 * character is inserted to the stream. If no non repeating element is found
 * print -1.
 * 
 * Input: The first line of input contains an integer T denoting the no of test
 * cases. Then T test cases follow. Each test case contains an integer N
 * denoting the size of the stream. Then in the next line are x characters which
 * are inserted to the stream.
 * 
 * Output: For each test case in a new line print the first non repeating
 * elements separated by spaces present in the stream at every instinct when a
 * character is added to the stream, if no such element is present print -1.
 * 
 * Constraints: 1 <= T <= 200 1 <= N <= 500
 * 
 * Example: Input: 2 4 a a b c 3 a a c
 * 
 * Output: a -1 b b a -1 c
 * 
 * @author Govind
 *
 */
public class FirstNonRepeatingCharacterInAStream {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int sizeOfStream = Integer.parseInt(br.readLine());
			StringBuilder uniqueCharacters = new StringBuilder();
			StringBuilder repeatedCharacters = new StringBuilder();
			String[] stream = br.readLine().trim().split(" ");
			for (int j = 0; j < sizeOfStream; j++) {
				char ch = stream[j].charAt(0);
				// Check if character exists in the
				if (repeatedCharacters.toString().contains(ch + "")) {
					if (uniqueCharacters.length() > 0)
						output.append(uniqueCharacters.charAt(0) + " ");
					else
						output.append(-1 + " ");
				} else if (uniqueCharacters.toString().contains(ch + "")) {
					// Remove this character form uniqueCharacters array and add it in the
					// repeatedCharacters array
					int charIndex = uniqueCharacters.toString().indexOf(ch);
					// Remove this character from the unique characters string
					uniqueCharacters = new StringBuilder(uniqueCharacters.toString().substring(0, charIndex)
							+ uniqueCharacters.toString().substring(charIndex + 1, uniqueCharacters.length()));
					if (uniqueCharacters.length() > 0)
						output.append(uniqueCharacters.charAt(0) + " ");
					else
						output.append(-1 + " ");
					// And also add the same character to the repeated characters
					repeatedCharacters.append(ch);
				} else {
					uniqueCharacters.append(ch);
					output.append(uniqueCharacters.charAt(0) + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}
