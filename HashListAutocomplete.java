import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashListAutocomplete {
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    
    //results in connecting every possible prefix up to max prefix with the list of words containing that prefix
    public HashListAutocomplete(List<Term> terms) {
        myMap = new HashMap<>(); 
        if (terms == null) {
            throw new IllegalArgumentException("terms cannot be null");
        }
        for(Term term: terms){ //going through each term in terms
            String word = term.getWord();
            for (int i = 0; i <= MAX_PREFIX && i <= word.length(); i++){ //going through each substring including empty string
                String prefix = word.substring(0,i);
                if(!myMap.containsKey(prefix)){
                    myMap.put(prefix,new ArrayList<>()); // if prefix hasn't been seen yet, create a new list
                }
                myMap.get(prefix).add(term); // add term to the list for this prefix         
            }
        }
        //sort every value in map
        for(String key: myMap.keySet()){
            List<Term> value = myMap.get(key);
            Collections.sort(value, Comparator.comparing(Term::getWeight).reversed());
        }       
    }

    public List<Term> topMatches(String prefix, int k) {
        if(k<0){
            throw new IllegalArgumentException("Illegal value of k:"+k);
        }
        if(k == 0){
            return Collections.emptyList();
        }
        if (prefix == null) {
            throw new IllegalArgumentException("prefix cannot be null");
        }
        if(prefix.length() > MAX_PREFIX){
            prefix = prefix.substring(0,MAX_PREFIX);
        }
        if(myMap.containsKey(prefix)){ //search prefix in the map and find list of words that contain that prefix
            List<Term> matches = myMap.get(prefix);
            return matches.subList(0, Math.min(k, matches.size())); //return all matches if less than k, or just top k matches already sorted
        }
        return Collections.emptyList();
    }
}