class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen = 0;
        int[] freq = new int[26];
        int i =0;
        int maxFreq = 0;
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            while ((j-i+1) - maxFreq > k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            maxlen  = Math.max(maxlen , j-i+1);
        }
        return maxlen;
    }
}
