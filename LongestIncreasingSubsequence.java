class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS[] = new int[nums.length];
        Arrays.fill(LIS, 1);                                // set minimum incresing subsequence length equal to 1 for every location
         
        for(int i=1; i < nums.length; i++)                  // 1st pointer iterates through 1 - end of array
        {
            for(int j=0; j < i; j++)                        // second pointer iterates through 0 - (i-1)th index
            {
                if(nums[i] > nums[j])                     
                {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);  
                }
            }
        }
        
        int maxLength = 0;
        for(int i=0; i < nums.length; i++)                   // find maximum value in LIS array
        {
            if(LIS[i] > maxLength)
            {
                maxLength = LIS[i];
            }
        }
        
        return maxLength;
        
    }
}
