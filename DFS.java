import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS {
    public static void DFS(ArrayList<Integer>[] adj)
    {
        int[] visited = new int[adj.length];
        Arrays.fill(visited, 0);

        for(int i=0; i < adj.length; i++)
        {
            if(visited[i] == 0)
            {
                explore(visited, adj, i);
            }
        }
    }

    public static void explore(int[] visited, ArrayList<Integer>[] adj, int x)
    {
        visited[x] = 1;
        System.out.print((x+1) + " ");

        for(int i: adj[x])
        {
            if(visited[i] == 0)
            {
                explore(visited, adj, i);
            }
        }
    }

    public static void main(String []args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];            // Array of arraylists

        for(int i = 0; i < n; i++)
        {
            adj[i] = new ArrayList<Integer>();                 // creat arraylist for every array location
        }

        for(int i=0; i < m; i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj[x-1].add(y-1);
            adj[y-1].add(x-1);
        }
        DFS(adj);
    }

}
