package module4Objects.exercises.antiqueCollection;

public class Book extends Antique {
    private String author;

    public Book(int code, String fabricationDate, String origin, float price, String author) {
        super(code, fabricationDate, origin, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Object: Book | " + super.toString() + " | Author: " + author;
    }
}
