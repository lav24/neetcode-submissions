class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    Deque<String> dq = new ArrayDeque<>();
    Set<String> seen = new HashSet<>();
    int res = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        //create adjacency list 
        wordList.add(beginWord);

        popAdjList(wordList);
        //traverse the graph via bfs 
        return bfs(beginWord, endWord);
    }

    public int bfs(String beginWord, String endWord){

        dq.addLast(beginWord);
        res = 1;
        seen.add(beginWord);
        while(!dq.isEmpty()){
          int size = dq.size();  
          for(int i =0;i<size; i++){
             String word = dq.removeFirst();
             if(word.equals(endWord)){
               return res;
              }
              char[] c =  word.toCharArray();
              for(int i1=0;i1<c.length;i1++){
                char temp = c[i1];
                c[i1] = '*';
                for(String ls1 : adj.get(new String(c))){
                    if(!seen.contains(ls1)){
                      seen.add(ls1);
                      dq.addLast(ls1);
                    }
                }
                c[i1] = temp;
            }
          }
          res+=1;
        }
        return 0;

    }

    public void popAdjList(List<String> wordList){
        for(String w : wordList){
            char[] s = w.toCharArray();
            for(int i =0;i<s.length;i++){
                char temp = s[i];
                s[i] = '*';
                adj.put(new String(s), new ArrayList<>());
                s[i] = temp;
            }
        }

        for(String v: adj.keySet()){
            for(String w : wordList){
                char[] s = w.toCharArray();
                for(int i =0;i<s.length;i++){
                    char temp = s[i];
                s[i] = '*';
                String s1 = new String(s);
                if(v.equals(s1)){
                    adj.get(v).add(w);
                }
                s[i] = temp;
               }
            }
        }
    }
}
