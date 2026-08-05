class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check for row
        for(int row=0;row<9;row++){
            Set<Character> seen = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[row][i] == '.') continue;
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }
        //check for column
        for(int row=0;row<9;row++){
            Set<Character> seen = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][row] == '.') continue;
                if(seen.contains(board[i][row])) return false;
                seen.add(board[i][row]);
            }
        }

        //check for box
        for(int rowBox=0;rowBox<9;rowBox=rowBox+3){
            for(int colBox=0;colBox<9;colBox=colBox+3){
                Set<Character> seen = new HashSet<>();
                for(int i=rowBox;i<rowBox+3;i++){
                    for(int j=colBox;j<colBox+3;j++){
                        if(board[i][j]=='.')continue;
                        if(seen.contains(board[i][j]))return false;
                        seen.add(board[i][j]);
                    }
                }
            }
        }
        return true;
        
    }
}
