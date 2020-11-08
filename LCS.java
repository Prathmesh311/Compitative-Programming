class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        char str1[] = text1.toCharArray();                           // convert string into char array
        char str2[] = text2.toCharArray();        
        int memo[][] = new int[str1.length+1][str2.length+1];        // 2d array for memoization
        
        for(int i=0; i <= str1.length; i++)
        {
            for(int j=0; j <= str2.length; j++)
            {
                if(i == 0 || j == 0)                                 // assign 0 to 1st column and 1st row in memo
                {
                    memo[i][j] = 0;
                }
                else if(str1[i-1] == str2[j-1])                     // if char are equal 
                {
                    memo[i][j] = memo[i-1][j-1] + 1;                // add 1 to diagonal element (evantually LCS)
                }
                else
                {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);       // else assign max from prev column or row
                }
            }
        }
        return memo[str1.length][str2.length];                     // return max length of LCS
    }
    
}

