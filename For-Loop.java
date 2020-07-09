import java.util.*;
import java.io.*;
import java.lang.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 1; j < n+1; j++)
            {
                int currvalue = 0;
                for (int k = 0 ; k < j; k++)
                {    
                    currvalue = currvalue +  (int)((Math.pow(2, k)) * b); 
                }
                    int s = a + currvalue; 
                    arr[j-1] = s;

            }
            for(int z=0; z < n; z++)
            {
                System.out.print(arr[z] + " ");
            }
            System.out.println("");
            
        }
    
        in.close();
       
    }
}
