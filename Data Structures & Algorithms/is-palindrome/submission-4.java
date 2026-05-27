class Solution {
    public boolean isPalindrome(String s) {
    char [] c = new char[s.length()];
    int k = 0;
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
            c[k++] = ch;
        }
        else if ((ch >= 'a' && ch <= 'z') ||
                 (ch >= '0' && ch <= '9')) {
            c[k++] = ch;
        }
    }
    System.out.println(c);
    
    int i = 0;
    int j = k-1;
    while (i < j) {
            if (c[i] != c[j]) {
                return false;   // ❌ mismatch
            }
            i++;
            j--;
        }
    return true;
}
}
