class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++){
            int diff = target - numbers[i];
            for(int j=0;j<numbers.length;j++){
                if (i  < j && numbers[j] == diff){
                  return new int[]{i+1,j+1};
                }
            }
        }
        return new int[1];
    }
}
