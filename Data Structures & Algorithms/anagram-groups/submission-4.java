class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ss1 = new ArrayList<>();
        HashMap<String, List<String>> seenWords = new HashMap<>();
        for(int i=0; i < strs.length; i++){
            char [] sArr =  strs[i].toCharArray();
            Arrays.sort(sArr);
            String s = new String(sArr);
            if(seenWords.containsKey(s)){
                System.out.println(strs[i] + " found appending " + s);
                seenWords.get(s).add(strs[i]);
            }else {
                System.out.println(strs[i] + " not found adding " + s);
                seenWords.put(s, new ArrayList<>(List.of(strs[i])));
            }
        }
        return new ArrayList<>(seenWords.values());
    }

}
