class Solution {
    int c = 0;
    public int countSubstrings(String s) {
        for(int i=0;i< s.length(); i++){
           //odd
           int p1 = i;
           int p2 = i;
           while(p1 >= 0 && p2 < s.length()
            && s.charAt(p1) == s.charAt(p2)){
                c+=1;
                p1 -=1;
                p2+=1;
           }

           //even
           int p3 = i;
           int p4 = i+1;
           while(p3 >= 0 && p4 < s.length()
            && s.charAt(p3) == s.charAt(p4)){    
                c+=1;
                p3 -=1;
                p4+=1;
           }

        }
        return c;
    }
}
