class Solution {
    public int coinChange(int[] coins, int amount) {
        List<Integer> dp = new ArrayList<>(
    Collections.nCopies(amount+1, amount+1));
       dp.set(0, 0);
       for(int i=1;i < amount+1;i++){
          for(int c : coins){
            if(i - c >= 0){
              dp.set(i, Math.min(dp.get(i), 1 + dp.get(i - c)));
            }
          }
       }
       return dp.get(amount) != amount+1 ? dp.get(amount)  : -1;
    }
}
