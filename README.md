# Autocomplete Engine (Java)
This project implements an autocomplete engine to explore different algorithmic approaches and their tradeoffs for efficently returning the top-k-heaviest-weighted terms that match a given prefix. It compares multiple strategies to highlight the tradeoffs between time complexity, memory usage, and preprocessing cost. 

The project mirrors real-world systems such as search bars, code competion engines, and text prediction engines.

Key variables: N total Terms, M # of matches for the prefix, k # top of results needed

**How to Run:** 
1. Clone the repository: git clone https://github.com/lindseykantor/autocomplete-engine.git
2. Compile the project: javac *.java
4. Run the Demo: java Demo

The program will output results from the brute-force, binary search, and hash-based autocomplete implementations for comparison.

**Implemented Approaches:**
1. Brute Force: Scans all terms each and uses a priority queue to select the top k heaviest matches.
  - **Time Complexity:** O(N + M log k)
  - **Pros:** Simple and Easy to implement
  - **Cons:** Inefficent for large datasets
  
2. Binary Search-Based Autocomplete: Sorts all terms lexicographically and uses binary search to locate the range of matching terms for a given prefix, then uses a priority queue to select top-k heaviest matches.
  - **Time Complexity:** O(log N + M log k)
  - **Pros:** More efficent than Brute implementation, avoids scanning all terms
  - **Cons:** Still requires scanning all matching terms
3. Hash-Based Autocomplete: Precomputes a map connecting every possible prefix to the set of words containing prefix sorted by weight. Each query accesses matches and returns top-k heaviest matches.
  - **Time Complexity:**
    - Preprocessing: O(Max_Prefix * N)
    - Query: O(k) 
  - **Pros:** Extremely fast lookup, ideal for real-time autocomplete
  - **Cons:** Uses more memory due to the prefix map
 
**Key Concepts Demonstrated:**
- Algorithimic tradeoffs between time vs. space efficiency 
- Use of arrays, hash maps, priority queues, and binary search 
- Prefix-based searching and optimization strategies 
- Defensive programing and input validation



   
   

