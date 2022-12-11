class FloydWarshalls
{
    private int distanceMatrix[][];
    private int numberOfVertices;
   
    public FloydWarshalls(int numberOfVertices)
    {
        distanceMatrix = new int[numberOfVertices + 1][numberOfVertices + 1];
        this.numberOfVertices = numberOfVertices;
    }
 
    public void floydwarshallWorking(int graph[][])
    {
        for (int i = 1; i <= numberOfVertices; i++)
        {
            for (int j = 1; j <= numberOfVertices; j++)
            {
                distanceMatrix[i][j] = graph[i][j];
            }
        }
 
        for (int intermediate = 1; intermediate <= numberOfVertices; intermediate++)
        {
            for (int i = 1; i <= numberOfVertices; i++)
            {
                for (int j = 1; j <= numberOfVertices; j++)
                {
                    if (distanceMatrix[i][intermediate] + distanceMatrix[intermediate][j]
                         < distanceMatrix[i][j])
                        distanceMatrix[i][j] = distanceMatrix[i][intermediate] 
                            + distanceMatrix[intermediate][j];
                }
            }
        }
 
        for (int i = 1; i <= numberOfVertices; i++)
            System.out.print("\t" + i);
 
        System.out.println();
        for (int i = 1; i <= numberOfVertices; i++)
        {
            System.out.print(i + "\t");
            for (int j = 1; j <= numberOfVertices; j++)
            {
                System.out.print(distanceMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
 
}

