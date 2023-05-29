package md.dragan.anastasia.graphs.kruskal;

public class KruskalAlgorithm {

    public Graph apply(Graph source) {
        if (source == null) {
            return source;
        }
        int graphNodes = source.getNumberOfNodes();

        int[] parent = new int[graphNodes];
        for (int i = 0; i < graphNodes; i++) {
            parent[i] = i;
        }
        Graph kruskal = new Graph();
        source.sortWeigth();
        int edgeCount = 0;
        int index = 0;
        while (edgeCount < source.getNumberOfNodes()-1) {
            Edge nextEdge = source.getEdges().get(index++);
            int x = findParent(parent, nextEdge.source.getValue());
            int y = findParent(parent, nextEdge.destination.getValue());
            if (x!=y) {
                kruskal.addEdge(nextEdge);
                union(parent, x, y);
                edgeCount++;
            }

        }

        return kruskal;
    }

    //
    private int findParent(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            return findParent(parent, parent[vertex]);
        return vertex;
    }

    private void union(int[] parent, int x, int y) {
        int xParent = findParent(parent, x);
        int yParent = findParent(parent, y);
        parent[yParent] = xParent;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.initiateDemoInformation();
        System.out.println("-------------------------------------------");
        KruskalAlgorithm algorithm = new KruskalAlgorithm();
        Graph kruskal = algorithm.apply(graph);
        kruskal.print();
    }
}
