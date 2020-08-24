import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int stringLen = s.length();
        int count = 0;

        for(int i=0; i < s.length(); i++)                // counting num of 'a' in string
        {
            if(s.charAt(i) == 'a')
            {
                count++;
            }
        }

        long iterationOfString = n / (long)stringLen ;   // multiplying with num of occurence of string
        long result = count * iterationOfString;
        long lastIteration = n % (long)stringLen;

        for(int j = 0; j < lastIteration; j++)           // finding number of 'a' in last occureance of string
        {
            if(s.charAt(j) == 'a')
            {
                result++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
