import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        HashSet<String> set = new HashSet<String>();

        // Solution 1
        // full solution (but it's slow) - running time[O(n^2)]

        for(int i=0; i < s1.length(); i++)              // makes set of all substrings of s1 string
        {
            set.add(String.valueOf(s1.charAt(i)));
            for(int j=i+1; j < s1.length(); j++)
            {
                set.add(s1.substring(i, j+1));
            }
        }
        System.out.println(set);

        for(int k=0; k < s2.length(); k++)                // cheaks is substrings in s2 are also occure in set made by (s1 substrings)
        {
            if(set.contains(String.valueOf(s2.charAt(k))))
            {
                return "YES";
                
            }  

            for(int z=k+1; z < s2.length(); z++)
            {
                if(z+1 == s2.length())
                {
                    if(set.contains(s2.substring(k)))
                    {
                        return "YES";
                    }
                }
                if(set.contains(s2.substring(k, z+1)))
                {
                    return "YES";
                    
                }
            }
        }


        // Solution 2
        // only cheaks for chars (fast and serves the need of this perticuler question) - running time[O(n)]

        for(int i=0; i < s1.length(); i++)           // makes SET of s1 string chars
        {
            set.add(String.valueOf(s1.charAt(i)));
        }

        for(int j=0; j < s2.length(); j++)           // cheaks if s2 string chars present in set form by s1 string chars
        {
            if(set.contains(String.valueOf(s2.charAt(j))))
            {
                return "YES";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


