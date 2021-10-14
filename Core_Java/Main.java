package com.saniya;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UserMainCode {
	public static int checkCharacters(String input) {
		if (input.charAt(0) == (input.charAt(input.length() - 1)))
			return 1;
		return -1;

	}

	public static void displayMiddle(String input) {
		int length = input.length();
		if (length % 2 == 0)
			System.out.println(input.charAt(length / 2) + input.charAt(length / 2 - 1));
		else
			System.out.println(input.charAt(length / 2));

	}

	public static int countVowels(String input) {
		Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("([aeiou])");
		Matcher countEmailMatcher = EMAIL_ADDRESS_PATTERN.matcher(input);

		return (int) countEmailMatcher.results().count();
	}
}

public class Main {
	public static void main(String[] args) {
		// String input = "this";
		String input = "the picture was great";

		if (UserMainCode.checkCharacters(input) == 1)
			System.out.println("Valid");
		else
			System.out.println("Invalid");

		String referenceVariable1;
		String referenceVariable2;

		String temp1 = "cat";
		String temp2 = "cat";

		referenceVariable1 = temp1;
		referenceVariable2 = temp2;

		if (referenceVariable1 == referenceVariable2)
			System.out.println("They are equal");
		else
			System.out.println("They are NOT equal");

		String myString = new String("cat");
		referenceVariable1 = myString;

		System.out.println("\nAfter setting referenceVariable 1 to a new String");
		if (referenceVariable1 == referenceVariable2)
			System.out.println("They are equal");
		else
			System.out.println("They are NOT equal");

		StringBuilder mySB = new StringBuilder("cat");
		System.out.println(mySB);
		mySB.append("cat");
		System.out.println(mySB);

		// Write a Java method to display the middle character of a string
		String myInput = "367";
		String yourInput = "HCL Technologies";

		UserMainCode.displayMiddle(myInput);
		System.out.println(UserMainCode.countVowels(yourInput));

	}
}
