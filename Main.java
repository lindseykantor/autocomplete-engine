import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Term t = new Term("apple",100);
        System.out.printf("Term: %s %d%n", t.word,t.weight);
        ArrayList<Term> list = new ArrayList<>();
        list.add(new Term("apple", 100));
        list.add(new Term("application",80));
        list.add(new Term("apricot", 60));
        list.add(new Term("banana", 90));
        BruteAutocomplete obj = new BruteAutocomplete(list);
        ArrayList<Term> matches =  new ArrayList<>(obj.topMatches("ap", 2));
        System.out.println("Top matches:");
        for(Term match: matches){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
    }
}
