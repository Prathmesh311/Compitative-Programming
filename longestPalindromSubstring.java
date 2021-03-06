class Solution {
    private int Lo;
    private int maxPal;
    public String longestPalindrome(String s) {
        
        if(s.length() < 2)
        {
            return s;
        }
        
        for(int i=0; i < s.length(); i++)
        {
            extendPalindrom(s, i, i);
            extendPalindrom(s, i, i+1);
        }
        return s.substring(Lo, Lo + maxPal);
        
    }
    
    private void extendPalindrom(String s, int j, int k)
    {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k))
        {
            j--;
            k++;
        }
        if(maxPal < k-j-1)
        {
            Lo = j+1;
            maxPal = k-j-1;
        }
    }
}

