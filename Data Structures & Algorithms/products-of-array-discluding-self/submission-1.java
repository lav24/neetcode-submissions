class Solution {
    public int[] productExceptSelf(int[] nums) {
          Map<Integer, Integer> map = new HashMap<>();
          for(int i=0;i<nums.length;i++){
             for(int j=0;j<nums.length;j++){
                  if(i!=j){
                      map.put(i, map.getOrDefault(i, 1) * nums[j]);
                  }
             }
          }
          Collection<Integer> values = map.values();
          int[] result = new int[values.size()];
          int k = 0;
          for (int val : values) {
            result[k++] = val;
            }
          return result;
    }

   
}  
