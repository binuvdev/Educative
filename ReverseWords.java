package com.java.educative;

class ReverseWords {
	public static void main(String[] args) {
		reverseWords("We love Java".toCharArray());
		// reverseWords("To be or not to be".toCharArray());
	}

	public static void reverseWords(char[] sentence) {
		int start = 0;
		int end = sentence.length - 1;
		System.out.println(new String(sentence));
		while (end > start) {
			swap(sentence, start, end);
			start++;
			end--;
		}
		System.out.println(new String(sentence));
		int index = 0;
		end = 0;
		start = 0;
		while (index < sentence.length) {
			if (sentence[index] == ' ' || index == sentence.length - 1) {
				
				if (sentence[index] == ' ')
					end = end - 1;
				while (end > start) {
					swap(sentence, start, end);
					start++;
					end--;
				}
				start = index + 1;
				end = index;
			}
			index++;
			end++;
		}

		System.out.println(new String(sentence));
		// TODO: Write - Your - Code
	}

	static void swap(char[] sentence, int i, int j) {
		char ch = sentence[i];
		sentence[i] = sentence[j];
		sentence[j] = ch;

	}
}