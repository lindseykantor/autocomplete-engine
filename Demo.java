import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Term> list = new ArrayList<>();
        list.add(new Term("apple", 100));
        list.add(new Term("application",80));
        list.add(new Term("apricot", 60));
        list.add(new Term("banana", 90));

        BruteAutocomplete bruteForceObj = new BruteAutocomplete(list);
        BinarySearchAutocomplete binarySearchObj = new BinarySearchAutocomplete(list);
        HashListAutocomplete hashListObj = new HashListAutocomplete(list);

        System.out.println("Test 1: prefix ap, k=2");
        ArrayList<Term> matches =  new ArrayList<>(bruteForceObj.topMatches("ap", 2));
        System.out.println("Brute:");
        for(Term match: matches){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test4 =  new ArrayList<>(binarySearchObj.topMatches("ap", 2));
        System.out.println("Binary:");
        for(Term match: test4){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test10 =  new ArrayList<>(hashListObj.topMatches("ap", 2));
        System.out.println("Hash:");
        for(Term match: test10){
            System.out.printf("%s %d%n", match.word, match.weight);
        }

        
        System.out.println("Test 2: prefix not found");
        ArrayList<Term> test1 =  new ArrayList<>(binarySearchObj.topMatches("zz", 2));
        System.out.println("Binary:");
        for(Term match: test1){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test7 =  new ArrayList<>(hashListObj.topMatches("zz", 2));
        System.out.println("Hash:");
        for(Term match: test7){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        
        System.out.println("Test 3: prefix with many matches");
    
        ArrayList<Term> test3 =  new ArrayList<>(binarySearchObj.topMatches("ap", 10));
        System.out.println("Binary:");
        for(Term match: test3){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test9 =  new ArrayList<>(hashListObj.topMatches("ap", 10));
        System.out.println("Hash:");
        for(Term match: test9){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        


        System.out.println("Test 4: one match");
        ArrayList<Term> test2 =  new ArrayList<>(binarySearchObj.topMatches("ban", 5));
        System.out.println("Binary:");
        for(Term match: test2){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test8 =  new ArrayList<>(hashListObj.topMatches("ban", 5));
        System.out.println("Hash:");
        for(Term match: test8){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        
        System.out.println("Test 5: empty prefix");
        ArrayList<Term> test13 =  new ArrayList<>(binarySearchObj.topMatches("", 2));
        System.out.println("Binary:");
        for(Term match: test13){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        ArrayList<Term> test14 =  new ArrayList<>(hashListObj.topMatches("", 2));
        System.out.println("Hash:");
        for(Term match: test14){
            System.out.printf("%s %d%n", match.word, match.weight);
        }
        
    }
}
