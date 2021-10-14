package com.saniya;

import java.io.IOException;

@SuppressWarnings("serial")
class A extends Exception {
	public A(String errorMessage) {
		super(errorMessage);
	}
}

@SuppressWarnings("serial")
class B extends A {
	public B(String errorMessage) {
		super(errorMessage);
	}
}


public class ExceptionExample2 {
	public static void main(String[] args) {
		try {
			throw new A("exception thrown");
		} catch (Exception e) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + e);
		}

		System.out.println("rest of the code...");

		try {
			throw new B("exception thrown");
		} catch (Exception e) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + e);
		}

		System.out.println("rest of the code...");

		try {
			throw new NullPointerException("exception thrown");
		} catch (Exception e) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + e);
		}

		System.out.println("rest of the code...");

		
		try {
			throw new IOException("exception thrown");
		} catch (Exception e) {
			System.out.println("Caught the exception");

			System.out.println("Exception occured: " + e);
		}

		System.out.println("rest of the code...");


	}
}