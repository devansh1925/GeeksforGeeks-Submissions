// User function Template for Java
import java.util.*;

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        // code here
        Deque<Integer> dq = new LinkedList<>();
        int pagefault=0;
        
        for(int i=0;i<pages.length;i++){
            int curr = pages[i];
            if(!dq.contains(curr)){
                pagefault++;
                if(dq.size()==C){
                    dq.removeFirst();
                }
                dq.addLast(curr);
            }
            else{
                dq.remove(curr);
                dq.addLast(curr);
            }
        }
        
        return pagefault;
    }
}