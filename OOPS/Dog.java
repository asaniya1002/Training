public class Dog {
    private String name;
    private int age;
    private double weight;

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog()
    {
        this.name = "Tesla";
        this.age = 1;
        this.weight = 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public void showExcitement()
    {
        System.out.println(name + " is wagging its tail!");
    }

    public void showExcitement(int levelOfExcitement)
    {
        System.out.println(name + " is wagging its tail " +
                "and its excitement level is: " + levelOfExcitement + "!");
    }

    public void eating()
    {
        System.out.println(name + " is eating!");
    }

    public void eating(String food)
    {
        System.out.println(name + " is eating " + food + "!");
    }
}

class DogTest
{
    public static void main(String[] args)
    {
       Dog myDog = new Dog("Sparkles", 7, 6.9);
        Dog yourDog = new Dog("Cinder", 4, 16.9);

        System.out.println(myDog);
        System.out.println(yourDog);

        myDog.showExcitement();
        yourDog.showExcitement();

        myDog.showExcitement(7);
        yourDog.showExcitement(24);

        myDog.eating();
        myDog.eating("my cat");
    }
}
