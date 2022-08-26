package ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

enum Suit{
    Club(1),Diamond(2),Spade(3),Heart(4);
    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
public class Card {
    protected int faceValue;
    protected Suit suit;
    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public int getFaceValue() {
        return faceValue;
    }


    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "faceValue=" + faceValue +
                ", suit=" + suit +
                '}';
    }
}
class BlackJackCard extends Card{
    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }
    public int getGameValue(){
        if(this.faceValue>=1 && this.faceValue<10){
            return faceValue;
        }
        return 10;
    }
    public boolean isAce(){
        return this.faceValue==1;
    }

    public boolean isFaceCard(){
        return this.faceValue>=10;
    }
}
class Deck{
    private ArrayList<BlackJackCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (int i = 1; i <14; i++) {
            BlackJackCard club= new BlackJackCard(i,Suit.Club);
            cards.add(club);
            BlackJackCard diamond= new BlackJackCard(i,Suit.Diamond);
            cards.add(diamond);
            BlackJackCard spade= new BlackJackCard(i,Suit.Spade);
            cards.add(diamond);
            BlackJackCard heart= new BlackJackCard(i,Suit.Heart);
            cards.add(heart);
        }
    }

    public ArrayList<BlackJackCard> getCards() {
        return cards;
    }

    // use random number to shuffle
    public void shuffle(){

    }

}
