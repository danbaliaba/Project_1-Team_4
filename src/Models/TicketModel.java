package Models;

import Controller.TicketController;

import java.util.Objects;

public class TicketModel {
    private long id ; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int price; //Значение поля должно быть больше 0
    private TicketType type; //Поле может быть null
    private Person person;//Поле не может быть null
    long counter;

    TicketController TicketController = new TicketController();
    TicketRepository TicketRepository = new TicketRepository();


    public TicketModel(String name, int price, TicketType type, Person person){
        counter++;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.type = type;
        this.person = person;
    };
    public long getId(){
        return this.id;
    }
    public TicketType getType(){
        return this.type;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setId(long newId) {
        this.id = newId;
    }

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

    public String toString(){
        return "Название : " + this.name + "\nЦена : " + this.price +"\nСтатус : " + this.type +"\nPassportID : "+ this.person + "\nID : " + this.id +"\n";
    }
    public String showPerson(){
        return "Идентификационный номер персоны " + person;
    }
}


