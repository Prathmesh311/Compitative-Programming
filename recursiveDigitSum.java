import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {


        int numTofind = concatinationSuperDigit(n) * k;        // instead of counting again and again only count for single string before concatination and then multiply
        
        return superDigit(Integer.toString(numTofind), new HashMap<String, Integer>());   // counting main function intended for counting sum

    }

    static int concatinationSuperDigit(String n)              
    {
        if(n.length() == 1)
        {
            return Integer.parseInt(n);
        }

        int total = 0;
        for(int i=0; i < n.length(); i++)
        {
            total += concatinationSuperDigit(n.substring(i,i+1));
        }
        return total;
    }

    static int superDigit(String n, HashMap<String,Integer> map)
    {
        System.out.println(n);

        if(n.length() == 1)
        {
            return Integer.parseInt(n);
        }
        if(map.containsKey(n))                               // using hashmap for avoiding repeating counting of same string
        {
            return map.get(n);
        }
        
        int total = 0;
        int mid = n.length()/2;

        total += superDigit(n.substring(0,mid),map) + superDigit(n.substring(mid, n.length()), map);         // spliting string in half half and recursion call it again
        map.put(n, total);

        return superDigit(Integer.toString(total),map);           
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
