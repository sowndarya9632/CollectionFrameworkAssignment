package com.day3;

import java.util.Scanner;
import java.util.Stack;

public class stringparanthesisbalanced {
	static boolean isbalanced(String st) {
		if (st.length() % 2 == 1)
			return false;
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[')
				s.push(ch);
			else if (s.isEmpty()) {
				return false;
			}
			switch (ch) {
			case '}':
				if (s.pop() != '{')
					return false;
				break;
			case ']':
				if (s.pop() != '[')
					return false;
				break;
			case ')':
				if (s.pop() != '(')
					return false;
				break;

			}
		}
		return s.isEmpty();

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the string");
		String st = s.next();
		boolean rs = isbalanced(st);
		if (rs) {
			System.out.println("balanced");
		} else {
			System.out.println("not balanced");
		}

	}
}
