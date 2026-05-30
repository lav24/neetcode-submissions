class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int sum = 0;
        while(i<j){
            int intSum = Math.min(heights[i], heights[j]) * (j-i) ;
            System.out.println(i + "-" + j + "-" +  heights[i] + "-" + heights[j] + "--" + sum + "--" + intSum);
            if(intSum > sum){
                sum = intSum;
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
