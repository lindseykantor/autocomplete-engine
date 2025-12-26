public class Term {
    public String word; 
    public int weight; 
    
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
