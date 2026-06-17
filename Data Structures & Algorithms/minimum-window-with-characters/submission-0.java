class Solution {
    public String minWindow(String s, String t) {
         if (s.length() == 0 || t.length() == 0) return "";
        int missing = t.length();
        int[] need = new int[128];
        int left = 0, right = 0, start = 0;
        int minlen = Integer.MAX_VALUE;
        for(int c : t.toCharArray()){
            need[c]++;
        }
       
        while(right < s.length()){
            char r = s.charAt(right);
            if(need[r] > 0){
                missing--;
            }
            need[r]--;
            right++;

            while(missing == 0){
                if(right - left < minlen){
                    start = left;
                    minlen = right - left;
                }
                char l = s.charAt(left);
                need[l]++;
 
                if (need[l] > 0) {
                    missing++;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}
