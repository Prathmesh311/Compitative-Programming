import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        // Method 1
        int index=-1;                                  // try intuitive binary search method but due to sorting it's unable to keep track of indexes
        Arrays.sort(cost);

        for(int i=0; i < cost.length; i++)
        {
            if(cost[i] >= money)
            {
                index = i - 1;
                break;
            }

        }
        if(index == -1)
        {
            index = cost.length -1;
        }

        for(int i = index; i >= 0; i--)
        {
            //System.out.println(i);
            int rem = money - cost[i];
            int secondNumIndex = binarySearch(cost, rem, 0, i-1);
            //System.out.println(secondNumIndex + " " + i);
            
            if(secondNumIndex != -1)
            {
                System.out.println((secondNumIndex+1) + " " + (i+1));
                break;
            }
        }
        
        // Method 2
        Hashtable<Integer, Integer> nums = new Hashtable<Integer, Integer>();        // using hashmap to track cost and it's indexes

        for(int i=0; i < cost.length; i++)
        {
            nums.put(cost[i], i);
        }
        //System.out.println(nums);
        for(int i=0; i < cost.length; i++)
        {
            int rem = money - cost[i];
            if(nums.containsKey(rem) && nums.get(rem) != i)
            {
                System.out.println((i+1) + " " + (nums.get(rem)+1));
                break;

            }
        }
    }

    static int binarySearch(int[] cost, int money, int left, int right)
    {

        while(left <= right)
        {
            int mid = left + (right-left)/2;

            if(cost[mid] == money)
            {
                return mid;
            }

            if(money < cost[mid])
            {
                right = mid - 1;
            }

            if(money > cost[mid])
            {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
