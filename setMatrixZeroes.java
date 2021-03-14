import java.util.Arrays; 

class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix[0].length;
        int colLen = matrix.length;
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();

        
        for(int i=0; i < matrix.length; i++)
        {
            for(int j=0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    col.add(i);              // storing the indexes of 0's in 2D array
                    row.add(j);
                }
            }
        }
        
        int index = 0;
        
        while(index < col.size())                    // set rows and columns of stored indexes to 0
        {
            Arrays.fill(matrix[col.get(index)], 0);
            
            for(int i=0; i < colLen; i++)
            {
                matrix[i][row.get(index)] = 0;
            }
            index++;
        }
    }
}
