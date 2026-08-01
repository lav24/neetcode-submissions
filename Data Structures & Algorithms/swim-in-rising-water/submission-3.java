class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
    boolean[][] seen;
    int [][] directions = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    public int swimInWater(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        pq.offer(new int[]{grid[0][0],0,0});
        seen[0][0] = true;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int w = p[0];
            int r = p[1];
            int c = p[2];
            if(r == grid.length - 1 && c == grid[0].length - 1){
                return w;
            }
            for(int [] d : directions){
                int r1 = r + d[0];
                int c1 = c + d[1];
                if(r1 == grid.length  || c1 == grid[0].length ||
                 r1< 0 | c1 < 0 || seen[r1][c1]
                ){
                  continue;
                }
                pq.offer(new int[]{Math.max(w, grid[r1][c1]),r1,c1});
                seen[r1][c1] = true;
            }
          
        }
        return 0;
    }
}
