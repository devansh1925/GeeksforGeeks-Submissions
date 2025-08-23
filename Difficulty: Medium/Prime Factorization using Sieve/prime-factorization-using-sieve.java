// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int n) {
        // code here
        List<Integer> list = new ArrayList<>();
        
        for(int i=2;i<=Math.pow(n,0.5);i++){
            if(n%i==0){
                
                while(n%i==0){
                    list.add(i);
                    n=n/i;
                }
            }
        }
        if(n!=1){
            list.add(n);
        }
        
        return list;
    }
}
