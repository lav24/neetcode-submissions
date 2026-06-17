class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int avail[] = new int[26];
        int need[] = new int[26];
        for(char c : s1.toCharArray()){
            avail[c- 'a']++;
        }

        int i =0;
        int maxCount = 0;
        for(int j=0;j<s2.length();j++){
            need[s2.charAt(j) - 'a']++;
            if(j-i+1 > s1.length()){
                need[s2.charAt(i) - 'a']--;
                i++;
            }
            if(j-i+1 == s1.length()){
                if(Arrays.equals(avail, need)){
                    return true;
                }
            }
        }
        return false;
    }
}
