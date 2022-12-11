public class Dijkstra {

    public void algo(int[][] graph, int source){

        int n = graph.length;   // number of vertices
        boolean[] visitedV = new boolean[n];
        int[] dist = new int[n];
        
        for (int i = 0; i < n; i++) {
            visitedV[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        dist [source] = 0;
        for (int i = 0; i < n; i++) {
            int u = findMinDistance(dist, visitedV);
            visitedV[u] = true;
        
            for (int v = 0; v < n; v++) {
                if (!visitedV[v] && graph[u][v] != 0 && (dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
        System.out.println(String.format("Distance from %s to %s is %s", source, i, dist[i]));
      }
    }

    private static int findMinDistance(int[] dist, boolean[] visitedV) {
        int minDist = Integer.MAX_VALUE;
        int minDistV = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visitedV[i] && dist[i] < minDist) {
                minDist = dist[i];
                minDistV = i;
            }
        }
        return minDistV;
    }
}
