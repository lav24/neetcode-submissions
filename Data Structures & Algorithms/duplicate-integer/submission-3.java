class Solution {
    public boolean hasDuplicate(int[] nums) {
         Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // early exit
            }
            set.add(num);
        }
        
        return false;
    }
}