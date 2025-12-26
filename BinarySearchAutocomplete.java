import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BinarySearchAutocomplete {
    private List<Term> copy; 

    public BinarySearchAutocomplete(List<Term> terms) {
        ArrayList<Term> copy = new ArrayList<>();
        for(Term term: terms){
            copy.add(term);
        } 
        copy.sort(Comparator.comparing(Term::getWord));
        this.copy = copy;
    }

    public static <T> int firstIndex(List<T> list,
			T target, Comparator<T> comp) {
		if(list == null || list.isEmpty()){
			return -1;
		}
		int low = -1; // open on left
		int high = list.size()-1; //closed on the right 
		
		// (low,high] contains target
		while (low+ 1 != high) { // stop when only one candiate remains only contains high
        	int mid = (low + high)/2; //pick midpoint between low and high
       		T midval = list.get(mid);
        	int cmp = comp.compare(midval,target);
        	if (cmp >= 0){
            	high = mid; //keep mid and everything left of it 
			}
        	else{
            	low = mid; //target is to the right of midval
			}
		}
		if(high < 0 || high >= list.size()){ //check if high is a valid index
			return -1;
		}
		if(comp.compare(list.get(high),target) == 0){ //found smallest index with target
			return high;
		}

		return -1;		
	}

	public static <T> int lastIndex(List<T> list,
			T target, Comparator<T> comp) {
		if(list == null || list.isEmpty()){
			return -1;
		}
		int low = 0;
		int high = list.size();
		
		// target in [low,high)
		while (low+ 1 != high) { // stop when only one candiate remains only contains low
        	int mid = (low + high)/2;
       		T midval = list.get(mid);
        	int cmp = comp.compare(midval,target);
        	if (cmp <= 0){
            	low = mid; //value at mid is <= target, so last match could be mid or to the right 
			}
        	else{
            	high = mid; //value at mid is > target, so target must be to the left
			}
		}
		if(low < 0 || low >= list.size()){ //check if low is a valid index
			return -1;
		}
		if(comp.compare(list.get(low),target) == 0){ //found largest index with target
			return low;
		}
		
		return -1;
	}
public List<Term> topMatches(String prefix, int k) {
		if (k < 0) {
			throw new IllegalArgumentException("Illegal value of k:"+k);
		}
		if (k == 0) return Collections.emptyList();      

		Term dummy = new Term(prefix,0);
		MyComparator comp = new MyComparator(prefix.length());
		int first = firstIndex(copy, dummy, comp);  
		int last = lastIndex(copy, dummy, comp);

		if (first == -1) {               // prefix not found
			return new ArrayList<>();
		}
		// maintain pq of size k
		PriorityQueue<Term> pq = 
				new PriorityQueue<>(Comparator.comparing(Term::getWeight));
		for(int i = first; i<=last; i++){
			Term t = copy.get(i);
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
			// after loop, pq holds *at most* k Terms and
		// these are terms that are the "heaviest" based on code above
		// since pq is a min-pq, lightest/least-heavy is first to be removed
        ArrayList<Term> top = new ArrayList<>();
        while(!pq.isEmpty()){
            top.add(pq.remove());  
        }
        Collections.reverse(top); // PriorityQueue removes the lowest-weight term first; reverse to return results in descending weight order
        return top;
	}
	





}


