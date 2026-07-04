class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        Arrays.sort(piles);
        int right = piles[piles.length - 1];
        int ans = right;
        while(left <= right){
            long totalHrs = 0;
            int mid = (left + right) /2 ;
            for(int i=0;i<piles.length;i++){
                  totalHrs += Math.ceil((double)piles[i]/ mid);
            }
            if(totalHrs > h){
                left = mid + 1;
            }else{
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
        }
        return ans;
    }
}
