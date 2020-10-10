import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

         Set<String> set = new HashSet<String>();
         Arrays.sort(a);
         Arrays.sort(b);
         Arrays.sort(c);

         int triplets = 0;

         for(int i=0; i < a.length; i++)
         {
             int valueA = a[i];
             int indexB = binarySearch(b, valueA, 0, b.length-1, 1);
             if(indexB == -1)
             {
                 continue;
             }
             for(int j = indexB; j < b.length; j++)
             {
                 int valueB = b[j];
                 int indexC = binarySearch(c, valueB, 0, c.length - 1, 0);
                 if(indexC == -1)
                 {
                     continue;
                 }
                 for(int k = indexC; k >=0; k--)
                 {
                    int valueC = c[k];
                    String unique = Integer.toString(valueA) + Integer.toString(valueB) + Integer.toString(valueC);
                    if(!set.contains(unique))
                    {
                        triplets++;
                        set.add(unique);
                    }

                 }
                 
             }
         }

         return triplets;
    }

    static int binarySearch(int[] arr,int value,int left,int right,int indicator)
    {
        int ans = -1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;

            if(arr[mid] == value)
            {
                return mid;
            }

            if(value < arr[mid])
            {
                right = mid - 1;
                if(indicator == 1)
                {
                    ans = mid;
                }
            }

            if(value > arr[mid])
            {
                if(indicator == 0)
                {
                    ans = mid;
                }
                left = mid + 1;
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
