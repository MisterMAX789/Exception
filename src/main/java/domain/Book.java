package domain;


import lombok.Data;

@Data

public class Book extends Product{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public Book() {
        super();
    }

    public Book(String author) {
        this.author = author;
    }
}