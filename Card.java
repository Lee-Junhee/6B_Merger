import java.util.ArrayList;
import java.util.Arrays;

public class Card implements Comparable<Card>{
    
    private String cardValue;
    private static ArrayList<String> orderedCards = new ArrayList<String>(
        Arrays.asList("A", "2", "3", "4", "5", "6", "7",
                      "8", "9", "10", "J", "Q", "K")
    );

    public Card(String value) {
        cardValue = value;
    }
    
    public String toString() {
        return cardValue;
    }

    @Override
    public int compareTo(Card other) {
        return orderedCards.indexOf(cardValue) - orderedCards.indexOf(other.toString());
    }
}