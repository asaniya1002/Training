package com.saniya;

@SuppressWarnings("serial")
class ExceptionA extends Exception {
	public ExceptionA(String errorMessage) {
		super(errorMessage);
	}
}

@SuppressWarnings("serial")
class ExceptionB extends ExceptionA {
	public ExceptionB(String errorMessage) {
		super(errorMessage);
	}
}

@SuppressWarnings("serial")
class ExceptionC extends ExceptionB {
	public ExceptionC(String errorMessage) {
		super(errorMessage);
	}
}

class TestExceptions {
	static void validate(int age) throws ExceptionB {
		if (age < 18)
			throw new ExceptionB("age is not valid to vote");

		else
			System.out.println("welcome to vote");

	}

	static void isATeen(int age) throws ExceptionC {
		if (age <= 12 || age >= 20)
			throw new ExceptionC("not A Teen");

		else
			System.out.println("you're a teen!");

	}
}

public class ExceptionExample {
	public static void main(String[] args) {
		try {
			TestExceptions.validate(13);
		} catch (ExceptionA ex) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + ex);
		}

		System.out.println("rest of the code...");

		try {
			TestExceptions.isATeen(20);
		} catch (ExceptionA ex) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + ex);
		}

		System.out.println("rest of the code...");

	}
}
