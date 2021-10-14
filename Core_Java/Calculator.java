package com.saniya;

public class Calculator {

	public int add(int... a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum;
	}

	public int subtract(int... a) {
		int retVal = 0;
		for (int i : a)
			retVal -= i;
		return retVal;
	}

	public int multiply(int... a) {
		int retVal = 0;
		for (int i : a)
			retVal *= i;
		return retVal;
	}

	public int divide(int... a) {
		int retVal = 0;
		for (int i : a)
			retVal /= i;
		return retVal;
	}

	public int abs(int a) {
		return Math.abs(a);
	}

	public double squareRoot(int a) {
		return Math.sqrt(a);
	}

	public double power(double a, double b) {
		return Math.pow(a, b);
	}

	public double log(double a) {
		return Math.log(a);
	}

	public int round(float a) {
		return Math.round(a);
	}

}

 class CalcMain {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		System.out.println(myCalc.add(4, 8, 12, 65));
		System.out.println(myCalc.multiply(4, 8, 12, 65));
		System.out.println(myCalc.subtract(4, 8, 12, 65));
		System.out.println(myCalc.divide(4, 8, 12, 65));
		System.out.println(myCalc.abs(-2));
		System.out.println(myCalc.squareRoot(49));
		System.out.println(myCalc.power(2, 10));
		System.out.println(myCalc.log(-2));
		System.out.println(myCalc.round(99.79f));

	}
}
