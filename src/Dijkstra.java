public class Dijkstra {
    public static void dijkstra(int[][] graph, int source){
        int numberOfVertices = graph.length;
        boolean[] visitedV = new boolean[numberOfVertices];
        int[] dist = new int[numberOfVertices];
        
        for (int i = 0; i < numberOfVertices; i++) {
            visitedV[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        dist [source] = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            int u = findMinDistance(dist, visitedV);
            visitedV[u] = true;
        
            for (int v = 0; v < numberOfVertices; v++) {
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
                minDist = i;
            }
        }
        return minDistV;
    }
}
