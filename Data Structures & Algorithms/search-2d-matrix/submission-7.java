class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex= searchPotentialRow(matrix,target);
        if(rowIndex == -1){
            return false;
        }else{
            return searchBinary(rowIndex,matrix,target);
        }
    }

    private boolean searchBinary(int rowIndex,int[][] matrix, int target){
        int l=0;
        int r=matrix[0].length-1;
        int mid = (l+r)/2;
        while(l<=r){
            mid = (l+r)/2;
            if(target > matrix[rowIndex][mid]){
                l=mid+1;
            }else if(target < matrix[rowIndex][mid]){
                r=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    private int searchPotentialRow(int[][] matrix, int target){
        //if its smaller than 1st element and bigger than last element then not found as its sorted
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]){
            return -1;
        }
        int l=0;
        int r=matrix.length-1;
        
        while(l<=r){
            int mid=(l+r)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length-1]){
                return mid;
            }
            else if(target < matrix[mid][0]){
                r=mid-1;
            }
            else if(target > matrix[mid][0]){
                l=mid+1;
            }
            
        }
        return -1;
    }
}
