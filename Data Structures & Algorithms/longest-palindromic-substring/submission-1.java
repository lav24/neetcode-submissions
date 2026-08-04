class Solution {
    String res = "";
    int resLen = 0;
    public String longestPalindrome(String s) {
        char[] cA = s.toCharArray();
        
        for(int i=0;i< s.length(); i++){
           //odd
           int p1 = i;
           int p2 = i;
           while(p1 >= 0 && p2 < s.length()
            && s.charAt(p1) == s.charAt(p2)){
                if(p2 - p1 + 1 > resLen){
                    resLen = p2 - p1 + 1;
                    res = s.substring(p1, p2+1);
                }
                p1 -=1;
                p2+=1;
           }

           //even
           int p3 = i;
           int p4 = i+1;
           while(p3 >= 0 && p4 < s.length()
            && s.charAt(p3) == s.charAt(p4)){
                if(p4 - p3 + 1 > resLen){
                    resLen = p4 - p3 + 1;
                    res = s.substring(p3, p4+1);
                }
                p3 -=1;
                p4+=1;
           }

        }
        return res;

    }
}
