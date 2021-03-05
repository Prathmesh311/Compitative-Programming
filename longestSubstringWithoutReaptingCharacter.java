import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        
        if(s.length() == 0)
        {
            return 0;
        }
        
        for(int i=0; i < s.length(); i++)
        {
            int count = 0;
            for(int j=i; j < s.length(); j++)
            {
                if(!set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j));
                    count++;
                }else
                {
                    break;
                }
            }
            if(count > maxLen)
            {
                maxLen = count;
            }
            set.clear();
        }
        return maxLen;
    }
}
