class FloydWarshalls
{
    private int distancematrix[][];
    private int numberofvertices;
   
    public FloydWarshalls(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }
 
    public void floydwarshallWorking(int adjacencymatrix[][])
    {
        for (int i = 1; i <= numberofvertices; i++)
        {
            for (int j = 1; j <= numberofvertices; j++)
            {
                distancematrix[i][j] = adjacencymatrix[i][j];
            }
        }
 
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
        {
            for (int i = 1; i <= numberofvertices; i++)
            {
                for (int j = 1; j <= numberofvertices; j++)
                {
                    if (distancematrix[i][intermediate] + distancematrix[intermediate][j]
                         < distancematrix[i][j])
                        distancematrix[i][j] = distancematrix[i][intermediate] 
                            + distancematrix[intermediate][j];
                }
            }
        }
 
        for (int i = 1; i <= numberofvertices; i++)
            System.out.print("\t" + i);
 
        System.out.println();
        for (int i = 1; i <= numberofvertices; i++)
        {
            System.out.print(i + "\t");
            for (int j = 1; j <= numberofvertices; j++)
            {
                System.out.print(distancematrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
 
}

