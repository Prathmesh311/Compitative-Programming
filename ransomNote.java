import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> mapping = new HashMap<String, Integer>();
        int indicator = 0;

        for(int i=0; i < magazine.length; i++)                // forming hashmap for magazine
        {
            if(!mapping.containsKey(magazine[i]))
            {
                mapping.put(magazine[i], 1);

            }
            else
            {
                mapping.put(magazine[i], mapping.get(magazine[i])+1);
            }
        }
        //System.out.println(mapping);

        for(int j=0; j < note.length; j++)                  // cheaking words in note whether it is present in magazine hashmap
        {
            if(mapping.containsKey(note[j]) && mapping.get(note[j]) != 0)
            {
                mapping.put(note[j], mapping.get(note[j])-1);
            }
            else
            {
                indicator = 1;   
                break;
            }
        }
        
        if(indicator == 0)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

