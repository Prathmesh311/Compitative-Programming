import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {

        int pivot = arr[0];
        
        // Method 1
        
        //ArrayList<Integer> left = new ArrayList<Integer>();     // tried using two arraylist and arrays but takes more space
        //ArrayList<Integer> right = new ArrayList<Integer>();
        int[] left = new int[arr.length+1];
        int[] right = new int[arr.length];
        int l=0,r=0;
        for(int i=1; i < arr.length; i++)
        {

            if(pivot > arr[i]) 
            {
                //left.add(arr[i]);
                left[l] = arr[i];
                l++;
            }
            else
            {
                //right.add(arr[i]);
                right[r] = arr[i];
                r++;
            }
        }

        //left.add(pivot);
        left[l] = pivot;
        for(int i=0; i < right.length; i++)
        {
            //left.add(right.get(i));
            left[l] = right[i];
            l++;
        }
        

        // method 2
        
        for(int i=1; i < arr.length; i++)             // use swaping for better space complexity
        {
            if(pivot > arr[i])
            {
                int value = arr[i];
                for(int j=i; j >= 1; j--)
                {
                    arr[j] = arr[j-1];
                }
                arr[0] = value;
            }
        }

        return arr;
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

        //quickSort(arr);

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


