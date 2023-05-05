public class BenchMarks {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        DirectedGraph graph1 = new DirectedGraph(7);

        graph1.addVertex('A');
        graph1.addVertex('B');
        graph1.addVertex('C');
        graph1.addVertex('D');
        graph1.addVertex('E');
        graph1.addVertex('F');
        graph1.addVertex('G');

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 6);
        graph1.addEdge(1, 3);
        graph1.addEdge(1, 4);
        graph1.addEdge(2, 1);
        graph1.addEdge(2, 6);
        graph1.addEdge(2, 5);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 2);
        graph1.addEdge(3, 5);

        // benchmark for isAcyclic
        System.out.println("Benchmark for isAcyclic DirectedGraph with cycles");
        long startTime1 = System.nanoTime();
        graph1.isAcyclic();
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;
        System.out.println("Execution time in nanoseconds: " + timeElapsed1);
        System.out.println("Execution time in milliseconds: " + timeElapsed1 / 1000000);

        System.out.println("----------------------------------------------");
        DirectedGraph graph2 = new DirectedGraph(7);

        graph2.addVertex('A');
        graph2.addVertex('B');
        graph2.addVertex('C');
        graph2.addVertex('D');
        graph2.addVertex('E');
        graph2.addVertex('F');
        graph2.addVertex('G');

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 6);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 4);
        graph2.addEdge(2, 5);
        graph2.addEdge(3, 4);
        graph2.addEdge(5, 4);
        graph2.addEdge(6, 2);

        // benchmark for isAcyclic
        System.out.println("Benchmark for isAcyclic DirectedGraph with no cycles");
        long startTime2 = System.nanoTime();
        graph2.isAcyclic();
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime2 - startTime2;
        System.out.println("Execution time in nanoseconds: " + timeElapsed2);
        System.out.println("Execution time in milliseconds: " + timeElapsed2 / 1000000);

    }
}
