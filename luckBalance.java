import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        
        int luck = 0;
        Arrays.sort(contests, new Comparator<int[]>(){         // sort the 2D array considering column 1
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] > b[0])
                {
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });

        for(int i=0; i < contests.length; i++)          
        {
            //System.out.println(contests[i][0]);

            if(contests[i][1] == 0)                   // add value of not important matches that can we lost 
            {
                luck += contests[i][0];
            }
            else
            {
                if(k > 0)                            // first lost at most k matches and add their value
                {
                    k--;
                    luck += contests[i][0];
                }
                else{
                    luck -= contests[i][0];         // remaining mathces should be win as limit exides (k) and subtract their values 
                }

            }
        }

        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
