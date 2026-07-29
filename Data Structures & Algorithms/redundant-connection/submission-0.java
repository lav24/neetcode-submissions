class Solution {
    int [] par;
    int [] rank;
    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length+1];
        rank = new int[edges.length+1];

        for(int i=0;i<edges.length;i++){
            par[i]= i;
            rank[i]= 1;
        }

        for(int [] i:edges){
            if(!union(i[0], i[1])){
                return new int[]{i[0],i[1]};
            }
        }
        return null;
    }

    public int find(int n1){
       int res = n1;
       while(res != par[res]){
          res = par[res];
       }
       return res;
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1== p2){
            return false;
        }

        if(rank[p2] > rank[p1]){
            par[p1] = p2;
            rank[p2] +=1;
        }else{
            par[p2] = p1;
            rank[p1] +=1;
        }
        return true;
    }
}
