import java.util.*;
import java.io.*;

public class Main {
    public static final int INFINITY = 999;
 
    public static void main(String[] args) {
        int adj_matrix[][];
        int n;              // number of vertices
 
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = scan.nextInt();
 
        adj_matrix = new int[n + 1][n + 1];
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int js = 1; js <= n; js++)
        {
            for (int id = 1; id <= n; id++)
            {
                adj_matrix[js][id] = scan.nextInt();
                if (js == id)
                {
                    adj_matrix[js][id] = 0;
                    continue;
                }
                if (adj_matrix[js][id] == 0)
                {
                    adj_matrix[js][id] = INFINITY;
                }
            }
        }

        scan.close();
        runFloydWarshalls(adj_matrix, n);
    }

    public static void runFloydWarshalls (int[][] adj_matrix, int n) {
        System.out.println("Floyd -Warshall Algorithm: ");
        
        FloydWarshalls obj1 = new FloydWarshalls(n);
        obj1.floydwarshallWorking(adj_matrix);
       
    }
    
}
