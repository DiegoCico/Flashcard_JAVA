import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Deck> d = new ArrayList<>();
        String i = "";
        System.out.println("Welcome to study room");

        while(!"4".equals(i)){
            options();
            i = in.nextLine();

            if("1".equals(i))
                d.add(createDeck());

            if ("2".equals(i)) {
                System.out.println("Name of deck");
                String name = in.nextLine();
                int index = locateDeck(d, name);
                if (index == -1)
                    System.out.println("Deck not found!");
                else
                    d.remove(index);
            }

            if ("3".equals(i)){
                System.out.println("Name of deck");
                String name = in.nextLine();
                int index = locateDeck(d, name);
                if (index == -1)
                    System.out.println("Deck not found!");
                else
                    infoDeck(d.get(index));
            }

            if("4".equals(i))
                showAllDecks(d);


            if("5".equals(i))
                break;
        }
    }

    private static void options(){
        System.out.println("1.Create deck");
        System.out.println("2.Delete deck");
        System.out.println("3.Select a deck");
        System.out.println("4.Show all decks name");
        System.out.println("5.Quit");
        System.out.println("---------------------------------");
    }

    private static Deck createDeck(){
        ArrayList<Flashcard> f = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String i = "";
        int num = 1;
        System.out.println("Name of the deck");
        String n = in.nextLine();



        while(!"n".equals(i)){
            System.out.println("Flashcard number " + num);
            System.out.println("Front of deck");
            String front = in.nextLine();
            System.out.println("Back of deck");
            String back = in.nextLine();

            f.add(new Flashcard(front,back));
            num++;

            System.out.println("add another Y or N");
            i = in.nextLine().toLowerCase();
        }

        return new Deck(n,f);
    }

    private static int locateDeck(ArrayList<Deck> d, String n) {
        for(int i = 0; i<d.size(); i++){
            if (d.get(i).getName().equals(n))
                return i;
        }
        return -1;
    }

    private static void infoDeck(Deck d) {
        System.out.println("---------------------------------");
        System.out.println("Deck Name: " + d.getName());
        System.out.println("Number of flashcards " + d.getCards().size()+1);

        for(int i = 0; i < d.getCards().size(); i++){
            System.out.println("Card: " + (i+1));
            System.out.println("Front: "+ d.getSpecific(i).getFront() + ", Back: " + d.getSpecific(i).getBack());
        }
        System.out.println("-----------------------------------");
    }

    private static void showAllDecks(ArrayList<Deck> d){
        for(int i = 0; i<d.size();i++){
            System.out.println("Deck " + (i+1) + " " + d.get(i).getName());
        }
        System.out.println("-----------------------------------");
    }
}
