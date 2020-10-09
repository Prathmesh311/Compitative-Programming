import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

        int lowestDiff = Integer.MAX_VALUE;
        // Method 1
        for(int i=0; i < arr.length; i++)                 // brute force approach for finding minimum diff between any array elements 
        {                                                   // time Complexity - O[(n^2)]
            for(int j=i+1; j < arr.length; j++)
            {
                int diff = Math.abs(arr[i] - arr[j]);
                if(lowestDiff > diff)
                {
                    lowestDiff = diff;
                }
                if(lowestDiff == 0)
                {
                    return 0;
                }
            }
        }
  
        // Method 2
        Arrays.sort(arr);                               // first array sorted 
        for(int i=0; i < arr.length-1; i++)             // then linearly find the min diff between array elements
        {                                               // time Complexity - O[nlogn] 
            int diff = Math.abs(arr[i]-arr[i+1]);
            if(diff < lowestDiff)
            {
                lowestDiff = diff;
            }
        }
        return lowestDiff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
