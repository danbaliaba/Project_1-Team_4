package Models;

public class Person {
    private String passportID;

    public Person(String passportID) {
        this.passportID = passportID;
    }
    @Override
    public String toString() {
        return passportID;
    }
    public String getPassportID() {
        return passportID;
    }
}
