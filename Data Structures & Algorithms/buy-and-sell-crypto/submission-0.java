class Solution {
    public int maxProfit(int[] prices) {
        int i =0;
        int maxProfit =0;
        while(i<prices.length-1){
           int j = i+1;
           while(j<prices.length){
               int p = prices[j] - prices[i];
               if(p > maxProfit){
                    maxProfit =p;
                }
                j++;
           }
           i++;
        }
        return maxProfit;
    }
}
