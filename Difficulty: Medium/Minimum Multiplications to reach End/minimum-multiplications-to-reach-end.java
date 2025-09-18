// User function Template for Java

class Solution {
    class Pair{
        int num;
        int steps;

        public Pair(int num, int steps){
            this.num = num;
            this.steps = steps;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        int n = arr.length;
        
        int[] distance = new int[100000];
        for(int i=0;i<100000;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[start]=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,0));
        
        int mod = 100000;
        
        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            int num = curr.num;
            int steps = curr.steps;
        
            
            for(int i=0;i<n;i++){
                int newStart = (num*arr[i])%mod;
                if(steps+1<distance[newStart]){
                    distance[newStart] = steps+1;
                    queue.add(new Pair(newStart,steps+1));
                }
            }
        }
        
        if(distance[end]==Integer.MAX_VALUE){
            return -1;
        }
        
        return distance[end];
    }
}
