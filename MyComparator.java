import java.util.Comparator;

public class MyComparator implements Comparator<Term> {
    int prefixSize; 
    public MyComparator(int prefix) {
        prefixSize = prefix;
    }
    
    public int compare(Term v, Term w) {
        int i = 0;
        while(i < prefixSize && i< v.getWord().length() && i < w.getWord().length()){
            //continue loop until one of the letters are different  
            if(v.getWord().charAt(i) < w.getWord().charAt(i)){
                return -1;
            }
            if(v.getWord().charAt(i) > w.getWord().charAt(i)){
                return 1;
            }
            i += 1;
        }
        if(i == prefixSize) return 0; //if each character is same 
        if(i == v.getWord().length() && i == w.getWord().length()) return 0; //if iterated through all words then they are the same
        if (i == v.getWord().length()) return -1;  
        if (i == w.getWord().length()) return 1; 
        return 0;
    }
}
