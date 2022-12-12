/*
 * Dijkstra's Algorithm:
 * function dijkstra(G, S)
 * for each vertex V in G
 *      distance[V] <- infinite
 *      previous[V] <- NULL
 *      If V != S, add V to Priority Queue Q
 * distance[S] <- 0
 * 
 * while Q IS NOT EMPTY
 *      U <- Extract MIN from Q
 *      for each unvisited neighbour V of U
 *          tempDistance <- distance[U] + edge_weight(U, V)
 *          if tempDistance < distance[V]
 *              distance[V] <- tempDistance
 *              previous[V] <- U
 * return distance[], previous[]
 */
public class Dijkstra {

    public int[] dijkstra(int[][] graph, int source){

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

        return dist;
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
