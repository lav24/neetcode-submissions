class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    Map<Character,Boolean> visited = new HashMap<>();
    //null -> not visited //false -> visited //true -> on rthe current path
    StringBuilder sb = new StringBuilder();
    public String foreignDictionary(String[] words) {
     
      for (String w : words) {
    for (char c : w.toCharArray()) {
        adj.putIfAbsent(c, new ArrayList<>());
    }
}
      // create adjacency list with rules 
      for(int i=0;i< words.length -1;i++){
        String w1 = words[i] ;
        String w2 = words[i+1] ;
        int minLen = Math.min(w1.length(), w2.length());
        if(w1.length() > w2.length() &&
        w1.substring(0, minLen).equals(w2.substring(0, minLen))
        ){
            return "";
        }
        for(int j=0;j<w1.length();j++){
            if(w1.charAt(j) != w2.charAt(j)){
            
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }
      for(Character c1 : adj.keySet()){
         if(dfs(c1)){
            return "";
         }
      }
      sb.reverse();
      return sb.toString();
    }

    public boolean dfs(Character c){
      if(visited.containsKey(c)){
         return visited.get(c);
      }
      visited.put(c, Boolean.TRUE);
      if(adj.containsKey(c)){
         for(Character c1 : adj.get(c)){
             if(dfs(c1)){
                return Boolean.TRUE;
             }
         }
      }
      visited.put(c, Boolean.FALSE);
      sb.append(c);
      return Boolean.FALSE;
    }
}
