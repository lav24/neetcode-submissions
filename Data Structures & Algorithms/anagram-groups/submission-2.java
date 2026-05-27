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
        Map<Character, Integer> freq1 = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for(char c : freq1.keySet()){
            if(!freq.getOrDefault(c, 0).equals(freq1.get(c))){
                return false;
            }
        }
        for(char c : freq.keySet()){
            if(!freq1.getOrDefault(c, 0).equals(freq.get(c))){
                return false;
            }
        }
        return true;
    }
}
