class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums); 
       for(int i = 0; i < nums.length; i++){
           int start = i+1;
           int end  = nums.length-1;
           if (i > 0 && nums[i] == nums[i - 1]) continue;
           while(start < end){
               int sum = nums[i] + nums[start] + nums[end];
               if(sum < 0){
                  start++;
               }else if(sum> 0){
                  end --;
               }else {
                  result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                  while (start < end && nums[start] == nums[start + 1]) start++;
                  while (start < end && nums[end-1] == nums[end]) end--;
                  start++;
                  end--;
               }
           }
       }
       return result;
    }
}