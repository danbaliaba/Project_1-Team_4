package Models;

import java.io.IOException;
import java.util.Objects;

public class TicketModel implements Comparable<TicketModel> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int price; //Значение поля должно быть больше 0
    private TicketType type; //Поле может быть null
    private Person person;//Поле не может быть null
    long counter;

    public TicketModel(String name, int price, TicketType type, Person person) {
        counter++;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.type = type;
        this.person = person;
    }

    public String getCSVLine() {
        return
                name + ";" +
                        price + ";" +
                        getType() + ";" +
                        getPerson();
    }

    public Person getPerson() {
        return person;
    }

    public long getId() {
        return this.id;
    }

    public TicketType getType() {
        return this.type;
    }

    public void setId(long newId) {
        this.id = newId;
    }
    public int getPrice(){return this.price;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketModel ticket = (TicketModel) o;
        return id == ticket.id && price == ticket.price && Objects.equals(name, ticket.name) && type == ticket.type && Objects.equals(person, ticket.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, type, person);
    }

    public String toString() {
        return "Имя: " + this.name + "\nЦена: " + this.price + "\nСтатус: " + this.type + "\nPassportID: " + this.person + "\nID: " + this.id + "\n";
    }
    public String showPerson(){
        return "PassportID : " + person;
    }

    @Override
    public int compareTo(TicketModel o) { // переопределение для сравнения элементов в методе printFieldDescendingPerson
        return o.getPrice() - this.price;
    }

    public static TicketModel getFromCSV(String line) throws IOException {
        String[] parts = line.split(";");

        if (parts[0] == null || parts[0].isEmpty() || parts[0].isBlank()) {
            throw new IOException("Название не может быть пустым!");
        }
        String name = parts[0];

        if (!Utils.isInt(parts[1])) {
            throw new IOException("Цена должна быть числом!");
        }
        if (Integer.parseInt(parts[1]) < 0) {
            throw new IOException("Цена должна быть больше 0!");
        }
        int price = Integer.parseInt(parts[1]);

        if (parts[2] == null || parts[2].isEmpty() || parts[2].isBlank()) {
            throw new IOException("Тип не может быть пустым!");
        }
        if (!Utils.isEnum(parts[2], TicketType.class)) {
            throw new IOException("Тип введён неверно!");
        }
        TicketType type = TicketType.valueOf(parts[2]);

        if (parts[3] == null || parts[3].isEmpty() || parts[3].isBlank()) {
            throw new IOException("ID человека не может быть пустым!");
        }
        String passportId = parts[3];

        Person person = new Person(passportId);

        TicketModel ticket = new TicketModel(name, price, type, person);
        return ticket;
    }

}



