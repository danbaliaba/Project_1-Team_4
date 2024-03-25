package Models;

import java.util.Comparator;

public class Person implements Comparator<TicketModel> {
    private String passportID;

    public Person(String passportID) {
        this.passportID = passportID;
    }
    @Override
    public String toString() {
        return passportID;
    }
    @Override
    public int compare(TicketModel o1, TicketModel o2) { // переопределение для сравнения элементов списка
        return o1.compareTo(o2);
    }
    public String getPassportID() {
        return passportID;
    }
}
