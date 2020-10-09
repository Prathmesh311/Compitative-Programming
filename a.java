       for(int i=0; i < s.length(); i++)
        {
            if(s.charAt(i) != '0' && s.charAt(i) != '1')
            {
                return 0;
            }
        }
        
        int n = s.length();
        int maxPow = 0;
        
        for( int i=0; i < n; i++)
        {
            String subStr = s.substring(0, n);
            if(subStr.charAt(n-1) != '1')
            {   
                int count = 0;
                int num = Integer.parseInt(subStr,2);
                while(num % 2 == 0)
                {
                    count++;
                }
                if(maxPow < count)
                {
                    maxPow = count;
                }
            }
            s = subStr.valueOf(n-1) + subStr.substring(0, n-1);
        }
        return maxPow;

