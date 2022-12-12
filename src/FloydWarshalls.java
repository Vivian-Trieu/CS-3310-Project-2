class FloydWarshalls
{
    /*
 * Floyd-Warshall Algorithm:
 * n = no of vertices
 * A = matrix of dimension n*n
 * for i = 1 to n
 *      for j = 1 to n
 *          A0[i, j] = w[i, j]
 * for k = 1 to n
 *      for i = 1 to n
 *          for j = 1 to n
 *              Ak[i, j] = min (Ak-1[i, j], Ak-1[i, k] + Ak-1[k, j])
 * return A
 */

    public int[][] floydwarshall(int graph[][], int n) {

        int distMatrix[][] = new int[n][n];
        int u, v, k;

        for (u = 0; u < n; u++) {
            for (v = 0; v < n; v++) {
                distMatrix[u][v] = graph[u][v];
            }
        }

        for (k = 0; k < n; k++) {
            for (u = 0; u < n; u++) {
                for (v = 0; v < n; v++) {
                    if (distMatrix[u][k] + distMatrix[k][v] < distMatrix[u][v]) {
                        distMatrix[u][v] = distMatrix[u][k] + distMatrix[k][v];
                    }
                }
            }
        }
        return distMatrix;
    }
    
    void printMatrix(int matrix[][], int n) {
        for (int i = 0; i < n; i++)
            System.out.print("\t" + i);
        
        System.out.println();

        for (int i = 0; i < n; ++i) {
            System.out.print(i + "\t");
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
          }
    }
    
}
 

