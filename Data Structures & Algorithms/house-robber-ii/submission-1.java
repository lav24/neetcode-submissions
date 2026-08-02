class Solution {
    public int rob(int[] nums) {

        List<Integer> skipFirst = new ArrayList<>();
        List<Integer> skipLast = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            skipFirst.add(nums[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            skipLast.add(nums[i]);
        }
        return Math.max(nums[0],Math.max(helper(skipFirst), helper(skipLast)));
    }

    public int helper(List<Integer> nums){
        int rob1 =0;
        int rob2 = 0;
        for(Integer i : nums){
         int temp = Math.max(i+ rob1 , rob2);
         rob1= rob2;
         rob2 =temp;
        }
        return rob2;
    }
}
