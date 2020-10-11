import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {

        BigInteger[] arr = new BigInteger[n];                     // using bigInteger because answer becames very big
        arr[0]=BigInteger.ZERO;                                   // even though using bigInteger all test cases are not solved (look for this issue) solved with python
        arr[1]=BigInteger.ONE;

        for(int i=2; i < n; i++)
        {
            arr[i] = arr[i-2].add(arr[i-1].multiply(arr[i-1]));
        }

        return arr[n-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
