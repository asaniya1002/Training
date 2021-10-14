package com.saniya;

@SuppressWarnings("serial")
class C extends Exception {
	public C(String errorMessage) {
		super(errorMessage);
	}
}

@SuppressWarnings("serial")
class D extends C {
	public D(String errorMessage) {
		super(errorMessage);
	}
}

public class ExceptionExample3 {
	public static void main(String[] args) {
		// If we try to write the catch block for Exception
		// before its subclass such as ExceptionC
		// in other words if the catch blocks below were to
		// be placed in the opposite order, program would not compile
		// and would display this error:
		// Unreachable catch block for C;
		// It is already handled by the catch block for Exception
		try {
			throw new C("exception thrown");
		} catch (C c) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + c);
		} catch (Exception e) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + e);
		}

		System.out.println("rest of the code...");

	}
}