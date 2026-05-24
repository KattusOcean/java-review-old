package module4Objects.exercises.pokerMatch;

import java.util.Arrays;

public class Card {
    private String suitType;
    private int value;
    private int id;
    private String name;

    public Card() {

    }

    public Card(String suitType, int value, int id, String name) {
        this.suitType = suitType;
        this.value = value;
        this.id = id;
        this.name = name;
    }

    public String getSuitType() {
        return suitType;
    }

    public void setSuitType(String suitType) {
        this.suitType = suitType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (value == 1 || value == 11 || value == 12 || value == 13) {
            return "Suit: " + suitType + " | Value: " + value + " | ID: " + id + " | Name: " + name;
        }
        return "Suit: " + suitType + " | Value: " + value + " | ID: " + id;
    }
}