public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> results = new ArrayList<>(D);
        PriorityQueue<Integer> nodesToSearch = new PriorityQueue<>();
        HashSet<Integer> uniqueNumbers= new HashSet<>();
        
        Integer[] basePrimes = new Integer[3];
        basePrimes[0] = A;
        basePrimes[1] = B;
        basePrimes[2] = C;
        
        Arrays.sort(basePrimes);
        
        nodesToSearch.add(A);
        nodesToSearch.add(B);
        nodesToSearch.add(C);
        
        uniqueNumbers.add(A);
        uniqueNumbers.add(B);
        uniqueNumbers.add(C);
        
        Integer lowestNumber = 0;
        
        while(results.size() < D){
            Integer currentNode = nodesToSearch.poll();
            
            //dont add dupes if multiple input primes the same
            if(currentNode > lowestNumber){
                results.add(currentNode);
                lowestNumber = currentNode;
            }

            for(Integer basePrime: basePrimes){
                Integer newNode = currentNode * basePrime;
                
                //exclude degenerate nodes in the tree
                if(!uniqueNumbers.contains(newNode)){
                    uniqueNumbers.add(newNode);
                    nodesToSearch.add(newNode);
                }
            }
        }
        
        return results;
        
    }
}


// You dont need to make a HashSet . 
//Your (currentNode > lowestNumber) will handle the case of equality such that no equal values are stored in the result array.
