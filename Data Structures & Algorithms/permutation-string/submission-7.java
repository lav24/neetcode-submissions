class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr = s1.toCharArray();   // step 1
        Arrays.sort(arr);               // step 2
        String sorted = new String(arr);
        System.out.println(sorted);

        int i =0;
        for(int j=0;j<s2.length();j++){
            if(j-i+1 == s1.length()){
                String sx = s2.substring(i, j+1);
                char[] arr1 = sx.toCharArray();   // step 1
                Arrays.sort(arr1); 
                String sorted1 = new String(arr1);
                System.out.println(sorted1 + " - i " + i + " - j "+ j);
                if(sorted1.equals(sorted)){
                    return true;
                }
                i++;
            }  
        }
        return false;
        }
}
