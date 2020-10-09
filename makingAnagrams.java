import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int deletions = 0;

        for(int i=0; i < a.length(); i++)            // count occureance of chars in string a
        {
            char currChar = a.charAt(i);
            if(!map.containsKey(currChar))
            {
                map.put(currChar, 1);
            }
            else
            {
                map.put(currChar, map.get(currChar) + 1);
            }
        }

        for(int i=0; i < b.length(); i++)            // count occurance of chars in string b and subtract the num of occurance number of chars from hashmap of a
        {
            char c = b.charAt(i);
            if(!map.containsKey(c))                  // if char is not in a and it's in b then it needs to be deleted for making Anagram
            {
                deletions++;
            }
            else
            {
                map.put(c, map.get(c) - 1);
            }
        }

        for(Map.Entry chars: map.entrySet())
        {
            deletions += Math.abs((int)chars.getValue());       // count the number of total chars to be deleted
        }

        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
