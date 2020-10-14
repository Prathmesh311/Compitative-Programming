import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<String> stack = new Stack<String>();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        String editor = "";
        for(int i=1; i <= n; i++)                  // loop for n operations
        {
            int operation = s.nextInt();           // input which operation to perform
            if(operation == 1)
            {
                String appendingStr = s.nextLine();
                appendingStr = appendingStr.substring(1,appendingStr.length());
                editor = editor + appendingStr;   //  append string to existing string
                String memo = operation + "-" + appendingStr;  // push current operation in stack with (operation +appendedstring) for furthur reference
                stack.push(memo);
                //System.out.print(editor);
            }
            if(operation == 2)
            {
                int numOfDelete = s.nextInt();
                String toDelete = editor.substring(editor.length()-numOfDelete, editor.length());  // find delete string
                if(toDelete.equals(editor))
                {
                    editor = "";
                }
                else{
                    editor = editor.substring(0, editor.length()-numOfDelete);       // update original string after deleting
                }
                String memo = operation + "-" + toDelete;                            // push (operation + deleted string) to stack
                stack.push(memo);
                //System.out.print(editor);

            }
            if(operation == 3)
            {
                System.out.println(editor.charAt(s.nextInt()-1));              // print char at specific index
            }
            if(operation == 4)
            {
                String reverseOperation = stack.peek();                        // peek top of stack 
                if(reverseOperation.charAt(0) == '1')                          // if previous operation is append then delete and vise varsa
                {
                    editor = editor.substring(0, editor.length() - (reverseOperation.length() - 2));
                }
                if(reverseOperation.charAt(0) == '2')
                {
                    editor = editor + reverseOperation.substring(2,reverseOperation.length());
                }
                stack.pop();                                                  // pop top of the stack

                
            }
        }
        s.close();


        //stack.push(editor);
        try{
            InputStreamReader inputStream = new InputStreamReader(System.in);       // everything is same but used InputStreamReader for faster opearation
            BufferedReader s = new BufferedReader(inputStream);
            int n = Integer.parseInt(s.readLine());

            String editor = "";     
            stack.push(editor);
            for(int i=1; i <= n; i++)
            {
                //int operation = s.nextInt();
                String input = s.readLine();
                String[] inputArr = input.split(" ");
                int operation = Integer.parseInt(inputArr[0]);
                if(operation == 1)
                {
                    String appendingStr = inputArr[1];
                    //stack.push(appendingStr.substring(1,appendingStr.length()));
                    editor = editor +  appendingStr.substring(1,appendingStr.length());
                    stack.push(editor);
                }
                if(operation == 2)
                {
                    int numOfDelete = Integer.parseInt(inputArr[1]);
                    editor = editor.substring(0, editor.length()-numOfDelete);
                    stack.push(editor);

                }
                if(operation == 3)
                {                
                    int printIndex = Integer.parseInt(inputArr[1]);

                    System.out.println(editor.charAt(printIndex - 1));
                }
                if(operation == 4)
                {
                    stack.pop();

                    editor = stack.peek();
                    
                    //System.out.println(editor);

                    
                }
            }

        }catch (NumberFormatException | IOException e) {
             // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
