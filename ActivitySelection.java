class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)                                              // if their is no interval return 0
        {
            return 0;
        }
        final Comparator<int[]> arrayComparator = new Comparator<int[]>()      // make comparator to compare elements in column 2
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[1] > b[1])
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        };
        Arrays.sort(intervals, arrayComparator);                            // sort array with respect to column 2 elements
        
        int answer = 1;
        int end = intervals[0][1];                                          // set end = end time of 1st interval
        for(int i=1; i < intervals.length; i++)                             
        {
            if(intervals[i][0] >= end)                                      // count maximum intervals possible
            {
                end = intervals[i][1];
                answer++;
            }
        }
        return intervals.length - answer;                                   // return number of intervals which are not possible
    }
}
