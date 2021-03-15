class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currMax = 0;
        int[] maxArr = new int[prices.length-1];
        
        for(int i=prices.length-1; i > 0; i--)
        {
            if(prices[i] > currMax)
            {
                currMax = prices[i];
                maxArr[i-1] = currMax;
                
            }
            else{
                maxArr[i-1] = currMax;
            }
        }
        
        for(int i=0; i < prices.length-1; i++)
        {
            if(maxArr[i]-prices[i] > maxProfit)
            {
                maxProfit = maxArr[i] - prices[i];
            }
        }
        
        return maxProfit;
    }
}

