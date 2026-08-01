class Solution {
    Map<Integer, List<int[]>>  adj = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
    int res = 0;
    public int minCostConnectPoints(int[][] points) {
         //create adj list
        for(int i =0;i< points.length;i++){
              int [] pts = points[i];
              for(int j=i+1;j<points.length;j++){
                  int [] pts2 =  points[j];
                  int dist = Math.abs(pts[0] - pts2[0])  + Math.abs(pts[1] - pts2[1]);
                  adj.putIfAbsent(i, new ArrayList<>());
                  adj.putIfAbsent(j, new ArrayList<>());
                  adj.get(i).add(new int[]{dist, j});
                  adj.get(j).add(new int[]{dist, i});
              }
        }
        primsAlgo(0, points.length);
        return res;
    }

    public void primsAlgo(int i, int size){
        pq.offer(new int[]{0,0});
        while(seen.size() < size){
            int [] p =  pq.poll();
            if(seen.contains(p[1])){
                continue;
            }
            seen.add(p[1]);
            res += p[0];
            if(!adj.containsKey(p[1])){
                return;
            }
            for(int [] nei : adj.get(p[1])){
               if(!seen.contains(nei[1])){
                 pq.offer(new int[]{nei[0],nei[1]});
               }
            }
        }

    }
}
