import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DirectedGraph {
    int maxVertices;
    int[][] adjacencyMatrix;
    Vertex[] vertices;
    int vertexCount;

    public DirectedGraph(int maxVertices){
        this.maxVertices = maxVertices;
        adjacencyMatrix = new int[maxVertices][maxVertices];
        vertices = new Vertex[maxVertices];
        vertexCount = 0;
    }

    /**
     * Adds a vertex to the graph
     * @param label The label of the vertex
     */
    public void addVertex(char label){
        vertices[vertexCount++] = new Vertex(label);
    }

    /**
     * Adds an edge to the adjacency matrix
     * @param start The starting vertex
     * @param end The ending vertex
     */
    public void addEdge(int start, int end){
        adjacencyMatrix[start][end] = 1;
    }

    /**
     * Adds an edge to the adjacency matrix from a line of text
     * Calls from readFile
     * @param line A line of text from a file
     */
    private void readLine(String line){
        String[] tokens = line.split(" ");
        int start = Integer.parseInt(tokens[0]);
        int end = Integer.parseInt(tokens[1]);
        adjacencyMatrix[start][end] = 1;
    }

    /**
     * Reads edges from a file
     * @param fileName The name of the file to read from
     */
    public void readEdgesFromFile(String fileName){
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                readLine(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the adjacency matrix
     */
    public void print(){
        System.out.print("  ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertices[i].label+ " ");
        }
        System.out.println();

        for (int i = 0; i < vertexCount;i++){
            System.out.print(vertices[i].label+" ");
            for (int j =0; j < vertexCount; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Breadth first search
     * In a breadth first search, we visit all the neighbors of a vertex before moving on to the next vertex in the graph.
     * Used a queue to keep track of the vertices we need to visit.
     * @param src source vertex
     */
    public void breadthFirstSearch(int src){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[maxVertices];

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()){
            int vertex = queue.remove();
            System.out.print(vertices[vertex].label + " ");

            for (int i = 0; i < maxVertices; i++){
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * Depth first search
     * In a depth first search, starting from a given source vertex and go the maximum depth possible. Then backtrack and visit the next neighbor.
     * Used a stack to keep track of the vertices we need to visit.
     * @param src source vertex
     */
    public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[maxVertices];
        dfsHelper(src, visited);
    }

    /**
     * Helper method for dfs
     * @param src source vertex
     * @param visited boolean array to keep track of visited vertices
     */
    private void dfsHelper(int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(vertices[src].label + " ");
        for (int i = 0; i < maxVertices; i++) {
            if (adjacencyMatrix[src][i] == 1 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    /**
     * Removes a vertex from the graph
     * @param label The label of the vertex to remove
     */

    // remove vertex by label, remove all edges connected to it and remove it from the adjacency matrix
    public void removeVertex(char label) {
        int index = -1;
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].label == label) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Vertex not found");
            return;
        }
        for (int i = index; i < vertexCount - 1; i++) {
            vertices[i] = vertices[i + 1];
        }
        for (int i = index; i < vertexCount - 1; i++) {
            System.arraycopy(adjacencyMatrix[i + 1], 0, adjacencyMatrix[i], 0, vertexCount);
        }
        for (int i = index; i < vertexCount - 1; i++) {
            for (int j = 0; j < vertexCount; j++) {
                adjacencyMatrix[j][i] = adjacencyMatrix[j][i + 1];
            }
        }
        vertexCount--;
    }

}
