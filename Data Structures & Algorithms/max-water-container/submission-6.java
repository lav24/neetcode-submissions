class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int sum = 0;
        while(i<j){
            if(Math.min(heights[i], heights[j]) * (j-i) > sum){
                sum = Math.min(heights[i], heights[j]) * (j-i);
            }
            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return sum;
    }
}
