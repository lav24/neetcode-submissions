class Solution {
    public int change(int amount, int[] coins) {
   //coin=1  coin=2  coin=3
//amt=0.  1    1       1
//amt=1.  1    0       0
//amt=2.  1    2       0
//amt=3.  1    2       3 
//amt=4.  1    3       4

        int[][] dp = new int[amount+1][coins.length];
        for(int col=0;col < dp[0].length;col++){
            dp[0][col] = 1; 
        }
        for(int a =1;a<= amount;a++){
            for(int c=0;c<coins.length;c++){
                int take = 0;
                int dontTake = 0;
                if(a - coins[c] >=0){
                    take = dp[a - coins[c]][c]; //take the coin
                }
                if(c > 0){
                    dontTake += dp[a][c - 1]; //dont take the coin 
                }
                dp[a][c] = take + dontTake;
             }
        }
       
       return dp[amount][coins.length -1];
    }
}
