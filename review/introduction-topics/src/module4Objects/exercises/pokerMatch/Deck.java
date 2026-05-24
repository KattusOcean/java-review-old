package module4Objects.exercises.pokerMatch;

public class Deck {
    Card[] deck = new Card[52];

    public void generateDeck() {
        int cardsCreated = 0;

        for (int i = 0; i < deck.length; i++) {
            if (cardsCreated >= 0 && cardsCreated <= 52) {
                generateCard();
            }
            cardsCreated++;
        }

        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public void generateCard() {
        String[] suitOptions = {"Spade", "Diamond", "Heart", "Club"};
        String suitType, name = null;
        int value, id = 0;

        for (int i = 0; i < deck.length; i++) {
            suitType = suitOptions[i / 13];
            value = (i % 13) + 1;
            id++;

            if (value == 1) { name = "As"; }
            if (value == 11) { name = "Jack"; }
            if (value == 12) { name = "Queen"; }
            if (value == 13) { name = "King"; }

            deck[i] = new Card(suitType, value, id, name);
        }
    }

    public void moveCardToTop() {
        Card firstCard = deck[0];

        for (int i = deck.length - 1; i >= 0; i++) {
            Card aux = deck[i - 1];

            if (deck[i-1] != null) {
                deck[i-1] = deck[i];

            } else {
                deck[deck.length - 1] = firstCard;
            }
        }
    }

    public void moveCardToBottom () {

    }
}
