import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Queue<T>{                            // This Queue class moves data for dequeue operation from 1 stack1 to stack2

    Stack<T> newStack = new Stack<T>();
    Stack<T> oldStack = new Stack<T>();

    public void enqueue(T value)
    {
        oldStack.push(value);
    }

    public void dequeue()
    {
        while(!oldStack.empty())                          // transfer data to newStack
        {
            newStack.push(oldStack.peek());
            oldStack.pop();
        }
        newStack.pop();                                  // pop data from newstack (which in the sence pop front of oldStack)
        while(!newStack.empty())                         // move data again in it's place
        {
            oldStack.push(newStack.peek());
            newStack.pop();
        }
    }

    public void printFront()
    {   
        System.out.println(oldStack.firstElement());         // return the bottom element in the stack
    }
}

/* 1. this OptimalQueue class saves data moving in dequeue operation every time
   2. for first time dequeue move all element from oldStack to newStack
   3. then for every pop operation pop element from newStack 
   4. emqueue every element in oldStack
   5. if newStack is empty repeat from second processure
*/
class OptimalQueue<T>{                                      

    Stack<T> newStack = new Stack<T>();
    Stack<T> oldStack = new Stack<T>();

    public void enqueue(T value)
    {
        oldStack.push(value);
    }

    public void dequeue()
    {
        cheack();
        newStack.pop();
    }

    public void printFront()
    {   cheack();
        System.out.println(newStack.peek());         // print front element in the stack
    }

    public void cheack()
    {
        if(newStack.empty())                         // cheack is newStack empty if yes rearrange data again
        {
            while(!oldStack.empty())
            {
                newStack.push(oldStack.peek());
                oldStack.pop();
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Queue<Integer> Q = new Queue<Integer>();
        OptimalQueue<Integer> Q = new OptimalQueue<Integer>();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i=1; i <= n; i++)
        {
            int num = s.nextInt();
            if(num == 1)
            {
                Q.enqueue(s.nextInt());
            }
            if(num == 2)
            {
                Q.dequeue();
            }
            if(num == 3)
            {
                Q.printFront();
            }
        }

        s.close();
    }
}
