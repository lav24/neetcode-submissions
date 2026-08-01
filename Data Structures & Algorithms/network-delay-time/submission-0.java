class Solution {
    Map<Integer,  List<int[]>> adj = new HashMap<>();
    PriorityQueue<int[]> pq =
     new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
     int t = 0;
    Set<Integer> seen = new HashSet<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times.length == 0){
         return -1;
        }
        for(int[] e : times){
           adj.putIfAbsent(e[0], new ArrayList<>());
           adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        bfs(k);
        return (n == seen.size()) ? t : -1;
    }

    public void bfs(int n){
       pq.offer(new int[]{0 , n});
       while(!pq.isEmpty()){
           int[] p =  pq.poll();
           int w1 = p[0];
           int n1 = p[1];

           if(seen.contains(n1)){
              continue;
           }
           t = Math.max(t, w1);
           seen.add(n1);
           if(!adj.containsKey(n1)){
              continue;
           }
           for(int[] c : adj.get(n1)){
              if(!seen.contains(c[0])){
                pq.offer(new int[]{w1+ c[1] , c[0]});
              }
           }
       }
    }
}
