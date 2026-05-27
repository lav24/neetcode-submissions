class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ss1 = new ArrayList<>();
        HashMap<String, List<String>> seenWords = new HashMap<>();
        for(int i=0; i < strs.length; i++){
            int[] freq = new int[26];
            for(char x : strs[i].toCharArray()){
              freq[x - 'a']++;
            }
            StringBuilder b = new StringBuilder();
            for(int i1 : freq){
                b.append(i1).append("#");
            }
            String buidler = b.toString();
            seenWords.putIfAbsent(buidler, new ArrayList<>());
            seenWords.get(buidler).add(strs[i]);
        }
        return new ArrayList<>(seenWords.values());
    }

}
