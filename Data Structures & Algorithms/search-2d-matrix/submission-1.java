class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        int start = 0;
        int end = c - 1;
        while(end >=0 && start < r){
            if(matrix[start][end] == target){
                return true;
            }
            if(matrix[start][end] < target){
                start+=1;
            }else if(matrix[start][end] > target){
                end-=1;
            }
        }
        return false;
    }
}
