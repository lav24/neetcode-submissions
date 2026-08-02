class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0] , helper(nums));
    }

    public int helper(int[] nums){
        int rob1 =0;
        int rob2 = 0;
        for(int i : nums){
         int temp = Math.max(i+ rob1 , rob2);
         rob1= rob2;
         rob2 =temp;
        }
        return rob2;
    }
}
