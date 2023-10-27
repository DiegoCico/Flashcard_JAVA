public class Flashcard {
    private String front;
    private String back;

    public Flashcard(String f, String b){
        front = f;
        back = b;
    }

    public String getFront(){
        return front;
    }

    public String getBack(){
        return back;
    }
}
