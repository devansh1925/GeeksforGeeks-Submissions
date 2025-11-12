


class Solution {
    public static int[] findLIS(int[] nums){
        int n = nums.length;

        int[] dp = new int[n];
        
        for(int i=0;i<n;i++){
            dp[i]=1;
        }

        for(int index=0;index<n;index++){
            for(int prev=0;prev<index;prev++){
                if(nums[index]>nums[prev]){
                    dp[index] = Math.max(dp[index],1+dp[prev]);
                }
            }
        }
        
        return dp;
    }
    
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp1 = findLIS(nums);
        
        
        int[] nums2 = new int[n];
        for(int i=0;i<n;i++){
            nums2[i] = nums[n-i-1];
        }
        
        int[] dp2 = findLIS(nums2);
        
        for (int i = 0; i < n / 2; i++) {
            int temp = dp2[i];
            dp2[i] = dp2[n - i - 1];
            dp2[n - i - 1] = temp;
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){
                ans = Math.max(ans,dp1[i]+dp2[i]-1);
            }
            
        }
        return ans;
    }
}