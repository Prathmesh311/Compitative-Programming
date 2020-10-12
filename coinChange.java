import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
    // Write your code here
        
        Long ways = getWays(n, c, 0, new HashMap<String,Long>());
        return ways;

    }

    public static long getWays(int money, List<Long> c, int index, HashMap<String,Long> memo)
    {
        if(money == 0)
        {
            return Long.valueOf(1);
        }
        if(index >= c.size())
        {
            return Long.valueOf(0);
        }
        int totalMoney = 0;
        int ways = 0;

        String key = money+"-"+index;      // step-2 memoization to reduce same recursive calls
        if(memo.containsKey(key))          // 
        {
            return memo.get(key);
        }
        
        while(totalMoney <= money)        // actual algorithm for coin change
        {
            int rem = money - totalMoney;
            ways += getWays(rem, c, index+1,memo);
            totalMoney += c.get(index);
        }
        memo.put(key, Long.valueOf(ways));  // updating hashmap
        return ways;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> c = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cTemp[i]);
            c.add(cItem);
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
