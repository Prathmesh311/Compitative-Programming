class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        char str1[] = text1.toCharArray();                           // convert string into char array
        char str2[] = text2.toCharArray();
        
        return recursiveLCS(str1, str2, str1.length, str2.length);  // recursive method
        
    }
    
    public static int recursiveLCS(char[] str1, char[] str2, int m, int n)
    {
        if(m == 0 || n == 0)                                       // return 0 if reach to bottom case
        {
            return 0;
        }
        
        if(str1[m-1] == str2[n-1])                                // if char are equal
        {
            return 1 + recursiveLCS(str1, str2, m-1, n-1);        // recursively call each index with -1
        } 
        else
        {
            return Math.max(recursiveLCS(str1, str2, m-1, n), recursiveLCS(str1, str2, m, n-1));   // else recursively call m-1 and n-1 and return max value from them
        }
    }
}

