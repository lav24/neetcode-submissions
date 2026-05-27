class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer ,Boolean> map = new HashMap<>();
        for(int i =0;i<nums.length; i++){
            if(Boolean.TRUE.equals(map.get(nums[i]))){
                return true;
            }
            map.put(nums[i], Boolean.TRUE);
        }
        return false;
    }
}