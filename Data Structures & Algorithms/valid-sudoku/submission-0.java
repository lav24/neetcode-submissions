class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int columns  = board[0].length;
        Map<String , Boolean> rowsMap = new HashMap<>();
        Map<String , Boolean> colsMap = new HashMap<>();
        Map<String , Boolean> boxMap = new HashMap<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
              if(board[i][j] == '.'){
                continue;
              }
              int boxIndex = (i / 3) * 3 + (j / 3);
              if(rowsMap.containsKey("row_" + i + "_" + board[i][j]) || colsMap.containsKey("col_" + j + "_" + board[i][j]) || boxMap.containsKey("box_" + boxIndex + "_" + board[i][j])){
                  return false;
              }
              rowsMap.put("row_" + i + "_" + board[i][j], true);
              colsMap.put("col_" + j + "_" + board[i][j] , true);
              boxMap.put("box_" + boxIndex + "_" + board[i][j], true);
        }
        }
        return true;
    }


}
