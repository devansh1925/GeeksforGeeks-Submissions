// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        int n = bt.length;
        Arrays.sort(bt);
        int start=0;
        int wait=0;
        
        for(int i=0;i<n;i++){
            wait+=(start-0);
            start+=bt[i];
        }
        
        return (int)wait/n;
    }
}
