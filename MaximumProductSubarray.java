class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];              // assign all values equal to 1st element
        int currMin = nums[0];
        int finalMax= nums[0];
        
        for(int i=1; i < nums.length; i++)
        {
            int temp = currMax;                                                            // store currMax in temp for furthur use
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));   // find max product from (currNum, maxProduct*currNum, minProduct*currNum) until ith index
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));      // find min product from (currNum, maxProduct*currNum, minProduct*currNum) until ith index
            
            finalMax = Math.max(currMax, finalMax);                                        // store new MaxProduct value in variable 
        }
        
        return finalMax;
    }
}
