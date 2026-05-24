package module4Objects.exercises.antiqueCollection;

public class Painting extends Antique {
    private String technique;

    public Painting(int code, String fabricationDate, String origin, float price, String technique) {
        super(code, fabricationDate, origin, price);
        this.technique = technique;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    @Override
    public String toString() {
        return "Object: Painting | " + super.toString() + " | Technique: " + technique;
    }
}
