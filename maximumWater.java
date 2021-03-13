class Solution {
    public int maxArea(int[] height) {
        int maximumArea = 0;

         int i=0;
        int j=height.length-1;
        int area=0;
        
        while(i < j)
        {
            if(height[i] <= height[j])
            {
                area = height[i]*(j-i);
                i++;
            }
            else{
                area = height[j]*(j-i);
                j--;
            }
            maximumArea = Math.max(area, maximumArea);
        }
        return maximumArea;
        
        
        /*int mul = 0;
        for(int diff = height.length-1; diff >= (height.length)/2; diff--)
        {
            for(int i=0; i+diff < height.length; i++)
            {
                if(height[i] <= height[i+diff])
                {
                    mul = height[i]*diff;
                }
                else
                {
                    mul = height[i+diff]*diff;
                }
                if(mul > maximumArea)
                {
                    maximumArea = mul;
                }
            }
        }*/
        
        
    }
}
