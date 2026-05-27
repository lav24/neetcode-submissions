class Solution {

    public String encode(List<String> strs) {
       StringBuilder builder = new StringBuilder();
       for(String s : strs){
           builder.append(s.length()).append("#").append(s);
       }
       return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i =0;
        int j=i;
        while(i < str.length()){
            j=i;
            while(str.charAt(j) != '#') {
                j++;
            }

           int length = Integer.parseInt(str.substring(i,j));
           j++;
           list.add(str.substring(j , j + length));
           i = j + length;
        }
        return list;
    }
}
