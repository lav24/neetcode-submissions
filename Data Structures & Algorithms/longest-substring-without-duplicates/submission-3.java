class Solution {
    public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int left = 0;
            int max = 0;
            for(int r = 0;r <s.length();r++){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(r));
                max = Math.max(max, r - left + 1);
            }
            return max;
    }
}
