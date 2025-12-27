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
        BruteAutocomplete bruteForceObj = new BruteAutocomplete(list);
        ArrayList<Term> matches =  new ArrayList<>(bruteForceObj.topMatches("ap", 2));
        System.out.println("Top matches from Brute:");
        for(Term match: matches){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        BinarySearchAutocomplete binarySearchObj = new BinarySearchAutocomplete(list);
        ArrayList<Term> matches2 =  new ArrayList<>(binarySearchObj.topMatches("ap", 2));
        System.out.println("BinaryAutoComplete Object");
        ArrayList<Term> test1 =  new ArrayList<>(binarySearchObj.topMatches("zz", 2));
        System.out.println("Top matches from Binary Search test 1 when no prefix is found:");
        for(Term match: test1){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test2 =  new ArrayList<>(binarySearchObj.topMatches("ban", 5));
        System.out.println("Top matches from Binary Search test 2 one match:");
        for(Term match: test2){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test3 =  new ArrayList<>(binarySearchObj.topMatches("ap", 10));
        System.out.println("Top matches from Binary Search test 3 where k is larger than matches:");
        for(Term match: test3){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test4 =  new ArrayList<>(binarySearchObj.topMatches("ap", 2));
        System.out.println("Top matches from Binary Search test 4 where k is smaller than matches:");
        for(Term match: test4){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test5 =  new ArrayList<>(binarySearchObj.topMatches("apple", 5));
        System.out.println("Top matches from Binary Search test 5 prefix logic with equality:");
        for(Term match: test5){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test6 =  new ArrayList<>(binarySearchObj.topMatches("a", 10));
        System.out.println("Top matches from Binary Search test 6:");
        for(Term match: test6){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        HashListAutocomplete hashListObj = new HashListAutocomplete(list);
        ArrayList<Term> test7 =  new ArrayList<>(hashListObj.topMatches("zz", 2));
        System.out.println("Top matches from HashList Autocomplete test 1 when no prefix is found:");
        for(Term match: test7){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test8 =  new ArrayList<>(hashListObj.topMatches("ban", 5));
        System.out.println("Top matches from HashList Autocomplete test 2 one match:");
        for(Term match: test8){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test9 =  new ArrayList<>(hashListObj.topMatches("ap", 10));
        System.out.println("Top matches from HashList Autocomplete test 3 where k is larger than matches:");
        for(Term match: test9){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test10 =  new ArrayList<>(hashListObj.topMatches("ap", 2));
        System.out.println("Top matches from HashList Autocomplete test 4 where k is smaller than matches:");
        for(Term match: test10){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test13 =  new ArrayList<>(hashListObj.topMatches("ap", 2));
        System.out.println("Top matches from HashList Autocomplete test 4 where k is smaller than matches:");
        for(Term match: test13){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test11 =  new ArrayList<>(hashListObj.topMatches("apple", 5));
        System.out.println("Top matches from HashList Autocomplete test 5 prefix logic with equality:");
        for(Term match: test11){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test12 =  new ArrayList<>(hashListObj.topMatches("a", 10));
        System.out.println("Top matches from hashList Autocomplete test 6:");
        for(Term match: test12){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
    }
}
