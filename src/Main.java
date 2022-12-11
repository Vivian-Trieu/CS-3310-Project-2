import java.util.*;

public class Main {
    public static final int INF = 999;
 
    public static void main(String[] args) {
        int n = 10;              // number of vertices
        Random r = new Random();
        int adj_matrix[][] = createMatrix(n, r, 0, 1);
        fillMatrix(adj_matrix, n, r, 1, 10);
 
        /* Scanner scan = new Scanner(System.in);
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

        scan.close(); */

        System.out.println("Adjacency Matrix:");

        
        printMatrix(adj_matrix, n);

        //runFloydWarshalls(adj_matrix, n);
        runDijkstra(adj_matrix, n);
    }

    public static void runFloydWarshalls (int[][] adj_matrix, int n) {
        System.out.println("Floyd-Warshall Algorithm: ");

        // Start timer
        long startTime = System.nanoTime();

        // Calculate all pairs shortest paths
        floydWarshall graph = new floydWarshall();
        graph.algo(adj_matrix);

        // End timer
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Total Time to Execute Program (in ns): " + totalTime);
    }
    
    public static void runDijkstra (int[][] adj_matrix, int n) {
        System.out.println("Dijkstra's Algorithm: ");

        // Start timer
        long startTime = System.nanoTime();

        // Calculate all pairs shortest paths
        Dijkstra graph = new Dijkstra();
        graph.algo(adj_matrix, 0);

        // End timer
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Total Time to Execute Program (in ns): " + totalTime);
    }

    private static void printMatrix(int M[][], int n) {
        
        for (int i = 0; i < n; i++)
            System.out.print("\t" + i);
        
        System.out.println();

        for (int i = 0; i < n; i++){
            System.out.print(i + "\t");
            for (int j = 0; j < n; j++){
                System.out.print(M[i][j] + "\t");               
            }
            System.out.println();
        }
    }

    // Creates matrix of 0s and 1s, 0 if no edge and 1 if there is an edge
    private static int[][] createMatrix(int n, Random random, int min, int max) {
        int [][] m = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = random.nextInt(max - min + 1) + min;
            }
        }

        return m;
    }

    private static int[][] fillMatrix(int[][] m, int n, Random random, int min, int max) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 1) 
                    m[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return m;
    }
}
