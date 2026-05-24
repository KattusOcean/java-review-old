package module4Objects.exercises.edibleShop;

public class Perishable extends Products{

    private String date;

    public Perishable(String code, String name, float price, String date) {
        super(code, name, price);
        this.date = date;
    }

    public String getExpiringDate() {
        return date;
    }

    public void setExpiringDate(String expiringDate) {
        this.date = expiringDate;
    }

    @Override
    public String toString() {
        return super.toString() + " | Expiring date: " + date;
    }
}
