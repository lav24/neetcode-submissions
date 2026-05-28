class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i =0;
        int j= 0;
        int diff = target - numbers[0];
        while(i <= j){
            if(numbers[j] == diff){
               return new int[]{i+1, j+1};
            }
            if(numbers[j] != diff){
                if(j == numbers.length - 1){
                    i++;
                    j = i;
                    diff = target - numbers[i];
                }else {
                    j++;
                }
            }
        }
        return new int[1];
    }
}
