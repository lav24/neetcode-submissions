class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t : tickets){
            String from = t.get(0);
            String to = t.get(1);
            adj.putIfAbsent(from , new ArrayList<>());
            adj.get(from).add(to);
        }
        for(List<String> val :adj.values()){
            Collections.sort(val);
        }
        result.add("JFK");
        dfs("JFK", tickets.size());

        return result;
    }

    
    public boolean dfs(String t, int size){
        if(result.size() == size + 1){
         return true;
        }
        if(!adj.containsKey(t)){
          return false;
        }
        List<String> n = new ArrayList<>(adj.get(t));
        for(int i=0;i<n.size();i++){
           String v =  n.get(i);
           result.add(v);
           adj.get(t).remove(i);
           if(dfs(v, size)){
             return true;
           }
           result.remove(result.size() - 1);
           adj.get(t).add(i, v);
        }
        return false;
        
    }
}
