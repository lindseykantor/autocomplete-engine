import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
// Implements brute-force autocomplete by scanning all terms each query and using a priority queue to track the top k matches 
public class BruteAutocomplete {
    private List<Term> terms; 

    public BruteAutocomplete(List<Term> terms) {
        this.terms = terms;
    }
    public List<Term> topMatches(String prefix, int k) {
        if(k<0){
            throw new IllegalArgumentException("Illegal value of k:"+k);
        }
        if(k == 0){
            return new ArrayList<>();
        }
        PriorityQueue<Term> pq = 
				new PriorityQueue<>(Comparator.comparing(Term::getWeight));
		for(Term t: terms){
			if(!t.word.startsWith(prefix)){
				continue;
			}
			if(pq.size() <k){
				pq.add(t);
			}
			else if(pq.peek().getWeight() <t.getWeight()){
				pq.remove();
				pq.add(t);
			}
        }
        ArrayList<Term> top = new ArrayList<>();
        while(!pq.isEmpty()){
            top.add(pq.remove());  
        }
        Collections.reverse(top); // PriorityQueue removes the lowest-weight term first; reverse to return results in descending weight order
        return top;
    }
}
