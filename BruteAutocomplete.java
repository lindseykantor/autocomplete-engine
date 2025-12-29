import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
// Implements brute-force autocomplete by scanning all terms each query and using a priority queue to track the top k matches 
public class BruteAutocomplete {
    private List<Term> copy; 

    public BruteAutocomplete(List<Term> terms) {
        ArrayList<Term> copy = new ArrayList<>();
        for(Term term: terms){
            copy.add(term);
        } 
        this.copy = copy;
    }
    public List<Term> topMatches(String prefix, int k) {
        if(prefix == null){
        throw new IllegalArgumentException("prefix cannot be null");
        }
        if(k<0){
            throw new IllegalArgumentException("Illegal value of k:"+k);
        }
        if(k == 0){
            return Collections.emptyList();
        }
        PriorityQueue<Term> pq = 
				new PriorityQueue<>(Comparator.comparing(Term::getWeight));
		for(Term t: copy){
			if(!t.getWord().startsWith(prefix)){
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
