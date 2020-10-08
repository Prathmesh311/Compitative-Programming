import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        HashMap<Character, Integer> alpha = new HashMap<Character, Integer>();
        HashMap<Integer, Integer> numOcc = new HashMap<Integer, Integer>();
        ArrayList<Integer> diffDetector = new ArrayList<Integer>();

        for(int i=0; i < s.length(); i++)           // counting the frequency of chars
        {
            char currChar = s.charAt(i);
            if(!alpha.containsKey(currChar))
            {
                alpha.put(currChar, 1);
            }
            else
            {
                alpha.put(currChar, alpha.get(currChar) + 1);
            }
        }
        System.out.println(alpha);
        
        int prevValue;
        for(Map.Entry map : alpha.entrySet())       // counting frequency of frequency of chars
        {
            //char key = (char)map.getKey();
            int value = (int)map.getValue();

            if(!numOcc.containsKey(value))
            {
                numOcc.put(value, 1);
            }
            else
            {
                numOcc.put(value, numOcc.get(value) + 1);
            }
            //prevValue = value;
            diffDetector.add(value);
            
        }
        System.out.println(numOcc);

        int min = Collections.min(diffDetector);      // cheaking if diff between frequencies is no more than 1
        int max = Collections.max(diffDetector);
        if(max - min > 1 && min != 1)
        {
            return "NO";
        }

        /*for(int i=0; i < diffDetector.size()-1; i++)
        {
            if(diffDetector.get(i) - diffDetector.get(i+1) > 1 || diffDetector.get(i) - diffDetector.get(i+1) < -1)
            {
                return "NO";
            }
        }*/

        int count = 0;
        int count1 = 0;
        for(Map.Entry nums: numOcc.entrySet())       // detecting how many time freq of freq occures (how many time greter than 1) and (how many times 1)
        {
            int currNumOcc = (int)nums.getValue();

            if(currNumOcc > 1)
            {
                count++;
            }
            if(currNumOcc == 1)
            {
                count1++;
            }
        }

        if(count > 1 || count1 > 1)                   // returning appropriate result
        {
            return "NO";
        }
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
