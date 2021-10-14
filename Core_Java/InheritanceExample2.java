package com.saniya;

class Animal {

	void walk() {

		System.out.println("I am walking");

	}

	private String furColor;

	public Number makeNoise() {
		System.out.println("I am making noise");
		return null;

	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

}

class Dog extends Animal {

	Dog(String furColor) {
		this.setFurColor(furColor);
	}

	void eat() {

		System.out.println("I am eating");

	}

	void bark() {

		System.out.println("I am barking");

	}

	// Cant override because we are changing the parameters
	// as well as because the return type has to be inherited
	public boolean makeNoise(int level) {
		System.out.println("I am making noise at a level of " + level);
		return level > 0;

	}

	@Override
	public Integer makeNoise() {
		System.out.println("I am a Dog and am making noise!");
		return 0;

	}

}

public class InheritanceExample2 {

	public static void main(String[] args) {

		Dog dog = new Dog("Gray");

		dog.walk();

		dog.eat();

		dog.bark();

		System.out.println(dog.getFurColor());

		dog.makeNoise(3);
		dog.makeNoise();

	}

}
