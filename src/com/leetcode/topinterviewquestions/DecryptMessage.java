package com.leetcode.topinterviewquestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Decrypt Message An infamous gang of cyber criminals named “The Gray Cyber
 * Mob”, which is behind many hacking attacks and drug trafficking, has recently
 * become a target for the FBI. After intercepting some of their messages, which
 * looked like complete nonsense, the agency learned that they indeed encrypt
 * their messages, and studied their method of encryption.
 * 
 * Their messages consist of lowercase latin letters only, and every word is
 * encrypted separately as follows:
 * 
 * Convert every letter to its ASCII value. Add 1 to the first letter, and then
 * for every letter from the second one to the last one, add the value of the
 * previous letter. Subtract 26 from every letter until it is in the range of
 * lowercase letters a-z in ASCII. Convert the values back to letters.
 * 
 * For instance, to encrypt the word “crime”
 * 
 * Decrypted message: c r i m e 
 * Step 1: 99 114 105 109 101 
 * Step 2: 100 214 319 428 529 
 * Step 3: 100 110 111 116 113 
 * Encrypted message: d n o t q The FBI
 * needs an efficient method to decrypt messages. Write a function named
 * decrypt(word) that receives a string that consists of small latin letters
 * only, and returns the decrypted word.
 * 
 * Explain your solution and analyze its time and space complexities.
 * 
 * Examples:
 * 
 * input: word = "dnotq" output: "crime"
 * 
 * input: word = "flgxswdliefy" output: "encyclopedia" Since the function should
 * be used on messages with many words, make sure the function is as efficient
 * as possible in both time and space. Explain the correctness of your function,
 * and analyze its asymptotic runtime and space complexity.
 * 
 * Note: Most programing languages have built-in methods of converting letters
 * to ASCII values and vica versa. You may search the internet for the
 * appropriate method.
 * 
 * Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] string word
 * 
 * The ASCII value of every char is in the range of lowercase letters a-z.
 * [output] string
 * 
 * Java Plain Text C C# C++ Clojure Go HTML/CSS/JS Haskell Java JavaScript PHP
 * Python Ruby Swift Reset 1 import java.io.*; 2 import java.util.*; 3 import
 * java.io.BufferedReader; 4 import java.io.InputStreamReader; 5 import
 * java.io.IOException; 6 import java.lang.Exception; 7 ​ 8 class Solution { 9 ​
 * 10 static String decrypt(String word) { 11 if (word == null ||
 * word.equals("")) { 12 return word; 13 } 14 StringBuilder original = new
 * StringBuilder(); 15 char preEncCh = word.charAt(0); 16 original.append((char)
 * (preEncCh - 1)); 17 for (int i = 1; i < word.length(); i++) { 18 char
 * curEncCh = word.charAt(i); 19 int orgCh = curEncCh - preEncCh + 26; 20 while
 * (orgCh < 97) { 21 orgCh += 26; 22 } 23 preEncCh = curEncCh; 24
 * original.append((char) orgCh); 25 } 26 return original.toString(); 27 } 28 ​
 * 2
 * 
 * @author Govind
 *
 */
class DecryptMessage {

	static String decrypt(String word) throws Exception {
		if (word == null || word.equals("")) {
			return word;
		}
		StringBuilder original = new StringBuilder();
		char preEncCh = word.charAt(0);
		original.append((char) (preEncCh - 1));
		for (int i = 1; i < word.length(); i++) {
			char curEncCh = word.charAt(i);
			int orgCh = curEncCh - preEncCh + 26;
			while (orgCh < 97) {
				orgCh += 26;
			}
			preEncCh = curEncCh;
			original.append((char) orgCh);
		}
		return original.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		System.out.println(decrypt(word));
	}

}