public class Main {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');


        graph.readEdgesFromFile("src/edges.txt");

//        graph.print();
//
//        System.out.println();
//
//        graph.breadthFirstSearch(0);
//
//        System.out.println();
//
//        graph.depthFirstSearch(0);
//
//        System.out.println();

//        graph.removeVertex('F');

//        graph.print();
//
//        System.out.println();
//
//        int sink = graph.findSink();
//        if (sink == -1) {
//            System.out.println("No sink");
//        } else {
//            System.out.println("Sink: " + graph.vertices[sink].label);
//        }
//
//        System.out.println();
//
//        graph.isAcyclic();
//
//        System.out.println();
//
//        graph.printAllCycles();
//        
        // benchmark for isAcyclic
        long startTime = System.nanoTime();
        graph.isAcyclic();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}