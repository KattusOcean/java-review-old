package module4Objects.exercises.antiqueCollection;

public class Antique {
    protected int code;
    protected String fabricationDate;
    protected String origin;
    protected float price;

    public Antique(int code, String fabricationDate, String origin, float price) {
        this.code = code;
        this.fabricationDate = fabricationDate;
        this.origin = origin;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(String fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Code: " + code + " | Fabrication date: " + fabricationDate + " | Origin: " + origin + " | Price: " + price;
    }
}
