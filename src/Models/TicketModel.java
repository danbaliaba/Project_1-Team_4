package Models;

import java.util.Objects;

public class TicketModel {
    private long id ; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int price; //Значение поля должно быть больше 0
    private TicketType type; //Поле может быть null
    private String person;//Поле не может быть null


    public TicketModel(String name, long id, int price, TicketType type, String person){
        this.name = name;
        this.id = id;
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


