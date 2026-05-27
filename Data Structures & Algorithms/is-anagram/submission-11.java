class Solution {
    public boolean isAnagram(String s, String t) {        
        Map<Character, Integer> freq1 = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println(freq + " - "+ freq1);

        for(char c : freq1.keySet()){
            if(!freq.getOrDefault(c, 0).equals(freq1.get(c))){
                System.out.println("all value dont match freq1" + c + "-" + freq.getOrDefault(c, 0) + "-" +freq1.get(c));
                return false;
            }
        }
         System.out.println("all value match");

        for(char c : freq.keySet()){
            if(!freq1.getOrDefault(c, 0).equals(freq.get(c))){
                System.out.println("all value dont match freq" + c + "-" + freq1.getOrDefault(c, 0) + "-" +freq.get(c));
                return false;
            }
        }
        System.out.println("all value match");
        return true;
    }
}
