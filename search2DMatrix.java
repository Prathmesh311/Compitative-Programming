class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix[0].length;
        int colLen = matrix.length;
        
        for(int i=0; i < colLen; i++)
        {
            if(matrix[i][0] <= target && target <= matrix[i][rowLen-1])
            {
                for(int j=0; j < rowLen; j++)
                {
                    if(matrix[i][j] == target)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
}

