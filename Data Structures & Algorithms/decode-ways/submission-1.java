class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    public int numDecodings(String s) {
        
        map.put(s.length(), 1);
        return dfs(0, s);


    }

    public int dfs(int i, String s){
       if(map.containsKey(i)){
          return map.get(i);
       }
       if(s.charAt(i) == '0'){
         return 0;
       }
       res = dfs(i+1, s); //till i what is the result
       if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' &&   s.charAt(i+1) <= '6'))){
         res += dfs(i+2, s);
       }
       map.put(i, res);
       return res;
    }
}
