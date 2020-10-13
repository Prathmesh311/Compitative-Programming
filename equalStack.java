import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here

        int l1 = 0, l2 = 0, l3 = 0, max = 0;
        for(int i = 0; i < h1.size(); i++)    // find the sum of h1 elements
        {
            l1 += h1.get(i);
        }
        for(int i = 0; i < h2.size(); i++)    // find the sum of h2 elements
        {
            l2 += h2.get(i);
        }
        for(int i = 0; i < h3.size(); i++)    // find the sum of h3 elements
        {
            l3 += h3.get(i);
        }
        //System.out.println(h1);
        max = Math.max(l1,l2);                // find max sum
        max = Math.max(max,l3);

        while(l1 != l2 || l2 != l3 || l1 != l3)     // repeat until all stacks become equal
        {
            if(max == l1)                     // pop from maximum valued stack and reduce sum by poped element
            {
                l1 -= h1.get(0);
                System.out.println(l1);
                h1.remove(0);
            }
            if(max == l2)
            {
                l2 -= h2.get(0);
                h2.remove(0);
            }
            if(max == l3)
            {
                l3 -= h3.get(0);
                h3.remove(0);
            }
            max = Math.max(l1,l2);            // find max of all stacks
            max = Math.max(max,l3);
            System.out.print(max + " ");
        }

        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
