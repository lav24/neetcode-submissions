class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int columns  = board[0].length;
        Map<String , Boolean> map = new HashMap<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
              if(board[i][j] == '.'){
                continue;
              }
              int boxIndex = (i / 3) * 3 + (j / 3);
              if(map.containsKey("row_" + i + "_" + board[i][j]) || map.containsKey("col_" + j + "_" + board[i][j]) || map.containsKey("box_" + boxIndex + "_" + board[i][j])){
                  return false;
              }
              map.put("row_" + i + "_" + board[i][j], true);
              map.put("col_" + j + "_" + board[i][j] , true);
              map.put("box_" + boxIndex + "_" + board[i][j], true);
        }
        }
        return true;
    }


}
