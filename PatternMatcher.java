package com.java.educative;

public class PatternMatcher {

	public static void main(String[] args) {
		System.out.println(regxMatch("aabbbbbcdda", "a*b*c*da"));
		System.out.println(regxMatch("aaabbbbbcccd","a*bbb*.*d"));
		System.out.println(regxMatch("b","b*"));
		System.out.println(regxMatch("","b*c"));
		System.out.println(regxMatch("abb","abb"));
	}

	static boolean regxMatch(String text, String pattern) {

		int i = 0;
		int strIdx = 0;

		while (i < pattern.length()) {
			char ch = pattern.charAt(i);
			if (strIdx >= text.length()) {
				if (ch == '*' && i == pattern.length() - 1) {
					return true;
				} else {
					return false;
				}
			}

			if (ch == '.') {
				i++;
				strIdx++;
			} else if (ch == '*') {
				if (i == 0) {
					return false;
				} else {
					char prevCh = pattern.charAt(i - 1);
					if (prevCh == '.') {
						if (i == pattern.length() - 1) {
							return true;
						} else {
							char nextCh = pattern.charAt(i + 1);
							while (text.charAt(strIdx) != nextCh && strIdx < text.length())
								strIdx++;
							i++;
						}
					} else {
						while (text.charAt(strIdx) == prevCh && strIdx < text.length())
							strIdx++;
						i++;
					}

				}
			} else if (text.charAt(strIdx) != ch) {
				return false;
			} else {
				i++;
				strIdx++;
			}
		}

		if (strIdx == text.length())
			return true;
		return false;

	}

}
