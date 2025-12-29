public class Term {
    private final String word; 
    private final int weight; 
    
    public Term(String word, int weight){
        this.word = word; 
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public String getWord(){
        return word;
    }


}
