public class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary > 0.0)
            this.salary = salary;
    }
}

class EmployeeTest
{
    public static void main(String[] args)
    {
        Employee myEmployee = new Employee("Amatul", "Saniya", 25000.00);
        Employee yourEmployee = new Employee("Creigh", "Battle", 500.00);

        System.out.println("MyEmployee's yearly salary " + myEmployee.getSalary() * 12);
        System.out.println("YourEmployee's yearly salary " + yourEmployee.getSalary() * 12);

        System.out.println("Giving " + myEmployee.getFirstName() + " and " +
                yourEmployee.getFirstName() + "a 10% raise...");

        myEmployee.setSalary(myEmployee.getSalary() * 1.10);
        yourEmployee.setSalary(yourEmployee.getSalary() * 1.10);

        System.out.println("MyEmployee's yearly salary " + myEmployee.getSalary() * 12);
        System.out.println("YourEmployee's yearly salary " + yourEmployee.getSalary() * 12);
    }
}