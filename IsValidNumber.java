package com.java.educative;

public class IsValidNumber {

	public static void main(String[] args) {
		System.out.println("Is the number valid 4.325? " + isNumberValid("4.325"));
		System.out.println("Is the number valid 1.1.1? " + isNumberValid("1.1.1"));
		System.out.println("Is the number valid 222? " + isNumberValid("222"));
		System.out.println("Is the number valid 22.? " + isNumberValid("22."));
		System.out.println("Is the number valid 0.1? " + isNumberValid("0.1"));
		System.out.println("Is the number valid 22.22.? " + isNumberValid("22.22."));
		System.out.println("Is the number valid 1.? " + isNumberValid("1."));

	}

	enum STATE {
		START, DECIMAL, INTEGER, AFTERDECIMAL, UNKNOWN
	};

	static STATE getNewState(STATE currState, char ch) {
		switch (currState) {
		case START:
		case INTEGER:
			if (ch == '.') {
				return STATE.DECIMAL;
			} else if (ch >= '0' && ch <= '9') {
				return STATE.INTEGER;
			} else {
				return STATE.UNKNOWN;
			}
		case DECIMAL:
			if (ch >= '0' && ch <= '9') {
				return STATE.AFTERDECIMAL;
			} else {
				return STATE.UNKNOWN;
			}
		case AFTERDECIMAL:
			if (ch >= '0' && ch <= '9') {
				return STATE.AFTERDECIMAL;
			} else {
				return STATE.UNKNOWN;
			}
		}
		return STATE.UNKNOWN;
	}

	static boolean isNumberValid(String str) {

		int index = 0;
		while (str.charAt(index) == '+' || str.charAt(index) == '-') {
			index++;
		}

		if (index > 1)
			return false;
		STATE newState = STATE.START;
		while (index < str.length()) {

			char ch = str.charAt(index);
			newState = getNewState(newState, ch);
			if (newState == STATE.UNKNOWN)
				return false;

			index++;

		}
		if (newState == STATE.DECIMAL)
			return false;
		return true;
	}

}
