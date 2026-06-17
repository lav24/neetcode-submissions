class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> st = new Stack<>();
         int [] leftMost  = new int[heights.length];
         int [] rightMost  = new int[heights.length];
         for(int i=0;i<heights.length;i++){
            leftMost[i] = -1;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
               leftMost[i] = st.peek();
            }
             
             st.push(i);
         }
         
         st.clear();
         for(int i=heights.length-1;i>=0;i--){
            rightMost[i] = heights.length;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
               rightMost[i] = st.peek();
            }
             st.push(i);
         }

         int maxArea = 0;
         for(int i=0;i<heights.length;i++){
            leftMost[i] +=1;
            rightMost[i] -=1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i]  - leftMost[i] + 1));
         }
         return maxArea;
    }
}
