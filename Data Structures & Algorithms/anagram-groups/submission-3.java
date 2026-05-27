class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ss1 = new ArrayList<>();
        HashMap<String, Boolean> m = new HashMap<>();
        for(int i=0; i < strs.length; i++){
            if(m.containsKey(strs[i])){
                continue;
            }
            m.put(strs[i], true);
            List<String> ss = new ArrayList<>();
            ss.add(strs[i]);
            for(int j=0; j < strs.length; j++){               
                if(i != j && isAnagram(strs[i], strs[j])){
                    ss.add(strs[j]);
                    m.put(strs[j], true);
               }
            }
            ss1.add(ss);
        }
        return ss1;
    }


    public boolean isAnagram(String s, String t) { 
        if(s.equals(t)){
            return true;
        }       
        char [] sArr =  s.toCharArray();
        char [] tArr =  t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        String s1= new String(sArr);
        String s2= new String(tArr);
        return s1.equals(s2);
    }
}
