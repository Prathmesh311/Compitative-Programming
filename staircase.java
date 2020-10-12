import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        int[] arr = new int[n];              // DP approach from bottom up
        if(n <= 2)
        {
            return n;
        }
        if(n==3)
        {
            return 4;
        }
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for(int i=3; i < n; i++)
        {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];     
        }
        return arr[n-1];
    }

    static int numSteps(int n)                            // tried using biginteger for 10000000007 but giving continuous error
    {
        BigInteger big = new BigInteger("10000000007");   // Note: try using bigInteger 

        if(n <= 0)
        {
            return 0;
        }
        if(n <= 2)
        {
            return n;
        }
        if(n == 3)
        {
            return 4;
        }

        return (numSteps(n-1) + numSteps(n-2) + numSteps(n-3))%(big);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
