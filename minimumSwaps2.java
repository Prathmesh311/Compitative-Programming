import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int totalSwaps = 0,temp;
        for(int i=0; i < arr.length-1; i++)
        {
            if(arr[i] != i+1)
            {
                temp = arr[arr[i] - 1];        // immediataly swaping element with it's write position
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                totalSwaps++;
                i--;                           // decrementing index so that just swaped element should not remain in wrong position

                // Selection sort
                //int smallestIndex = i;
                /*for(int j=i+1; j < arr.length; j++)  // Tried using selelction sort but it's running time is O^2
                {
                    if(arr[j] == i+1)
                    {
                        temp = arr[j];    // 
                        arr[j] = arr[i];
                        arr[i] = temp;
                        totalSwaps++;
                        j = arr.length;
                    }
                }*/
            }
            /*if(i != smallestIndex)
            {
                temp = arr[smallestIndex];
                arr[smallestIndex] = arr[i];
                arr[i] = temp;
                totalSwaps++;
            }*/
        }


        /*for(int i=0; i < arr.length; i++)          
        {
            if(arr[i] != i+1)
            {
                temp = arr[arr.indexOf(i+1)];    // this can be used by using indexOf method provided by various liabraries
                arr[arr.indexOf(i+1)] = arr[i];
                arr[i] = temp;
                totalSwaps++;
            }
        }*/


        return totalSwaps;

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

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
