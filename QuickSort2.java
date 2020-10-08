import java.util.*;
public class Solution {
	    
        static void quickSort(int[] ar)
        {
            quickSort(ar, 0, ar.length-1);
            for(int i=0; i < ar.length; i++)   // printing sorted array
            {
                System.out.print(ar[i] + " ");
            } 	
        }

        static void quickSort(int[] arr,int left,int right)
        {
            /*if(left > right)
            {
                return;
            }*/
            while(left < right)
            {
                int m = partition(arr, left, right);
                quickSort(arr, left, m-1);
                quickSort(arr, m+1, right);
            }
 
        }

        static void ramdomizedPivot(int[] arr, int left, int right)
        {
            Random random = new Random();
            int index = random.nextInt(right-left) + left;
            
        
            int temp = arr[index];
            arr[index] = arr[left];
            arr[left] = temp;

        }

        static int partition(int[] arr,int left,int right)   
        {
            ramdomizedPivot(arr, left, right);
            int temp;
            int pivot = arr[left];
            int j = left;

            for(int i=left+1; i <= right; i++)
            {
                if(arr[i] <= pivot)
                {
                    j = j + 1;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            temp = arr[j];
            arr[j] = arr[left];
            arr[left] = temp;
            
            return j;

        }

 
        static void printArray(int[] ar) 
        {
          for(int n: ar)
          {
            System.out.print(n+" ");
          }
          System.out.println("");
        }
	    
	      public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int i=0;i<n;i++)
            {
	           ar[i]=in.nextInt(); 
	        }
	        quickSort(ar);
	    }    
	}

