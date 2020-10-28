import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        List<List<Integer>> adj;          // declare adjacancy list
        int size;

        public Graph(int size) {
            adj = new ArrayList<>();
            this.size = size;
            while(size >= 0)
            {
                adj.add(new ArrayList<Integer>());   // inner adj list for every node
                size--;
            }
        }

        public void addEdge(int first, int second) {
            adj.get(first).add(second);             // put values in adj list
            adj.get(second).add(first);
            
        }
        
        public int[] shortestReach(int startId) 
        { 
            HashSet<Integer> visited = new HashSet<Integer>();   // creat set to cheak if node is visited or not
            List<Integer> queue = new LinkedList<Integer>();     // for traversing in graph
            int distance[] = new int[size];                      // for storing distance of each node from source
            Arrays.fill(distance, -1);
 
            visited.add(startId);                                
            distance[startId] = 0;
            queue.add(startId);

            while(!queue.isEmpty())                              // continue until queue is not empty
            {
                int curr = queue.remove(0);                      // remove front of queue
                for(int node : adj.get(curr))                    // traversing through adjacent nodes
                {
                    if(!visited.contains(node))                  // if node is not visited
                    {
                        visited.add(node);                       // make it visited
                        queue.add(node);                         // add to queue for next use
                        distance[node] = distance[curr] + 6;     // updating distance of node from source
                    }

                }
            }
            return distance;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
