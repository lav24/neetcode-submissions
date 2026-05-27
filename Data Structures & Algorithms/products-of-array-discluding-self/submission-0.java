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
          return map.values()
              .stream()
              .mapToInt(Integer::intValue)
              .toArray();
    }
}  
