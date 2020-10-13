import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stoneDivision function below.
    static long stoneDivision(long n, long[] s) {

        Arrays.sort(s);
        return stoneDiv(n, s, new HashMap<Long,Long>());

    }

    static long stoneDiv(long num, long[] set,HashMap<Long,Long> map)
    {
        if(num == Long.valueOf(0) || num == Long.valueOf(1))                  // returning 0 if num is 0/1
        {
            return Long.valueOf(0);
        }

        if(map.containsKey(num))                                              // cheaking if value is previously calculated if yes return from hashmap
        {
            return map.get(num);
        }

        long max = Long.valueOf(0);                                           // max is used outside main loop for cheking max of all possibilities
        for(int i=set.length-1; i >= 0; i--)
        {
            long total = Long.valueOf(0);                                     // total is used for internal total operations
            if(num % set[i] == 0 && num != set[i])
            {
                total += stoneDiv(set[i], set,map) * (num/set[i]);
                total += 1;

                max = Math.max(max, total);                                   // take maximum value from max or total (which help to find maximum condition in all types of input
            }
        } 
        map.put(num, max);                                                    // put calculated value in hashmap for memoization
        return max;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            long n = Long.parseLong(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] s = new long[m];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sItems[i]);
                s[i] = sItem;
            }

            long result = stoneDivision(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
