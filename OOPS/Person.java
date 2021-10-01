public class Person {
    private String name;
    private int age;
    private double shoeSize;

    public Person(String name, int age, double shoeSize) {
        this.name = name;
        this.age = age;
        this.shoeSize = shoeSize;
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

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }

    private void walking()
    {
        System.out.println(name + " of age: " + age + " has a shoeSize of " + shoeSize
         + "and is walking!");
    }

    public void startWalking()
    {
        walking();
    }

}

class Driver
{
    public static void main(String[] args)
    {
        Person myPerson = new Person("Amatul", 7, 9);
        myPerson.startWalking();

        myPerson.setName("Saniya");
        myPerson.setAge(20);
        myPerson.setShoeSize(9.5);

        System.out.println(myPerson.getName());
        System.out.println(myPerson.getAge());
        System.out.println(myPerson.getShoeSize());
    }
}
