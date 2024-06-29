package company_interview.enfussion.L1;

public class Person {
    private String name;
    private String lname;
    private int number;

    public Person(String name, String lname, int number) {
        this.name = name;
        this.lname = lname;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
