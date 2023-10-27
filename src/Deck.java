import java.util.ArrayList;

public class Deck {
    private ArrayList<Flashcard> cards;
    private String name;

    public Deck( String n, ArrayList<Flashcard> c){
        cards = c;
        name = n;
    }

    public String getName(){
        return name;
    }

    public ArrayList getCards(){
        return cards;
    }

    public Flashcard getSpecific(int i){
        return cards.get(i);
    }
}
