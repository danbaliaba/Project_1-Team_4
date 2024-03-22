package Models;


import java.util.Comparator;
import java.util.Scanner;
public class Person {
    private String passportID;

 /*   public void setPassportID() {
        Scanner scans = new Scanner(System.in);
        do {
            System.out.print("Введите ваш идентификационный номер : ");
            this.passportID = scans.nextLine();
            if (this.passportID.length() < 4) {
                System.out.println("Длина строки должна содержать не меньше 4 символов!");
            }
        } while (this.passportID.length() < 4);
    }
   public static class personComparator implements Comparator<Ticket> {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getPerson().compareTo(o2.getPerson());
        }
    }*/


    public String getPassportID() {
        return this.passportID;
    }
}
