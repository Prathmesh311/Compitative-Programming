class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        
        if(strs.length == 0)
        {
            return result;
        }
        
        for(int i=0; i < strs[0].length(); i++)
        {
            for(int j=0; j < strs.length; j++)
            {
                if(strs[j].length()-1 >= i && strs[0].charAt(i) == strs[j].charAt(i))
                {
                    continue;
                }
                else{
                    return result;
                }
            }
            result = result + strs[0].charAt(i);
        }
        return result;
    }
}
