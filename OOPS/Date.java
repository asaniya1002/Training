public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate()
    {
        System.out.println(month + "/" + day + "/" + year);
    }
}

class DateTest
{
    public static void main(String[] args)
    {
        Date myDate = new Date(9,29, 2001);
        myDate.displayDate();

        System.out.println("Setting myDate to October 1, 2021...");
        myDate.setDay(1);
        myDate.setMonth(10);
        myDate.setYear(2021);

        System.out.println("Displaying myDate: ");
        myDate.displayDate();
    }
}
