class Solution {
    public int minCostClimbingStairs(int[] cost) {
        List<Integer> l = new ArrayList<>();
        for(int i : cost){
            l.add(i);
        }
        l.add(0);
        for(int i = cost.length - 3;i>=0;i--){
            int  c = l.get(i);
            c+= Math.min(l.get(i+1), l.get(i+2));
            l.set(i, c);
        }
        return Math.min(l.get(0), l.get(1));
    }
}
