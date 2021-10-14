package com.saniya;

class SomeClass {
	SomeClass() throws Exception {
		System.out.println("Throwing Exception");
		throw new Exception("Exception Thrown\n");
	}
}

public class ExceptionExample4 {
public static void main(String[] args)
{
	try
	{
		SomeClass myClass = new SomeClass();
		
	}
	catch(Exception e)
	{
		System.out.println(e + "Exception Caught!");
	}
	}
}
