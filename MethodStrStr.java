class Solution {
    public int strStr(String haystack, String needle) {
        
        int len = needle.length();
        int lenHay = haystack.length();
        if(lenHay == 0 && len ==0)
        {
            return 0;
        }
        else if (len == 0)
        {
            return 0;
        }
        
        for(int i=0; i < haystack.length(); i++)
        {
            if(needle.charAt(0) == haystack.charAt(i))
            {
                if((i+len) < lenHay+1)
                {
                    String subHayStack = haystack.substring(i, i+len);
                    if(subHayStack.equals(needle))
                    {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

