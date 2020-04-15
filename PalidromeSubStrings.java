package com.java.educative;

public class PalidromeSubStrings {
	
	public static void main(String[] args) {
		//System.out.println(isPalidrome("malayalam"));
		//getPalidromeSubStrings("aabbbaa");
		findAllPalidromes("aabbbaa");
	}
	
	static void getPalidromeSubStrings(String str) {
		for(int i=0; i<str.length()-1;i++) {
			for(int j=i+2;j<=str.length();j++) {
				String sub = str.substring(i,j);
				if (isPalidrome(sub)) {
					System.out.println(sub);
				}
			}
		}
	}
	static boolean isPalidrome(String str) {
		int mid = (str.length()/2);
		int end = str.length() - 1;
		for(int i=0;i<mid;i++) {
			if (str.charAt(i) != str.charAt(end) ) {
				return false;
			}
			end--;
		}
		return true;
	}
	
	static void printPalidromes(String str, int start, int end) {
		while(start>=0 && end<str.length()) {
			if (str.charAt(start) != str.charAt(end)) {
				break;
			}
			System.out.println(str.substring(start,end+1));
			start--;
			end++;
		}
	}
	
	static void findAllPalidromes(String str) {
		for(int i=0;i<str.length();i++) {
			printPalidromes(str,i-1,i+1);
			printPalidromes(str,i,i+1);
		}
	}
}
