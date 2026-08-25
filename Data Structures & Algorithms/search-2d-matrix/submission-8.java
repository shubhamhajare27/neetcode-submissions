class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int l=0;
        int r=ROWS*COLS-1;
        while(l<=r){
            int m=(l+r)/2;
            int row = m/COLS;
            int col = m%COLS;
            if(target > matrix[row][col]){
                l=m+1;
            }else if(target < matrix[row][col]){
                r=m-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
