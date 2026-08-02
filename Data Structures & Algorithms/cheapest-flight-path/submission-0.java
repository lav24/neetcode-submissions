class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       int [] s = new int[n];
       Arrays.fill(s, Integer.MAX_VALUE);
       s[src] = 0;

       for(int i =0;i< k+1;i++){ 
          int [] temp = s.clone();
          for(int [] f : flights){
           int source = f[0];
           int dest = f[1];
           int w = f[2];
           if(s[source] == Integer.MAX_VALUE){
              continue;
           }
           if(s[source] + w < temp[dest]){
             temp[dest] = s[source] + w ;
           }
        }
        s = temp;
       }
       return s[dst] == Integer.MAX_VALUE ? -1 : s[dst];
    }
}
