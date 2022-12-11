import java.util.*;

public class Main {
    public static final int INF = 999;
 
    public static void main(String[] args) {
        int adj_matrix[][];
        int n;              // number of vertices
 
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = scan.nextInt();
 
        adj_matrix = new int[n + 1][n + 1];
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                adj_matrix[i][j] = scan.nextInt();
                if (i == j)
                {
                    adj_matrix[i][j] = 0;
                    continue;
                }
                if (adj_matrix[i][j] == 0)
                {
                    adj_matrix[i][j] = INF;
                }
            }
        }

        scan.close();
        runFloydWarshalls(adj_matrix, n);
    }

    public static void runFloydWarshalls (int[][] adj_matrix, int n) {
        System.out.println("Floyd-Warshall Algorithm: ");

        // Start timer
        long startTime = System.nanoTime();

        // Calculate all pairs shortest paths
        FloydWarshalls obj1 = new FloydWarshalls(n);
        obj1.floydwarshallWorking(adj_matrix);

        // End timer
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Total Time to Execute Program (in ns): " + totalTime);
    }
    
}
