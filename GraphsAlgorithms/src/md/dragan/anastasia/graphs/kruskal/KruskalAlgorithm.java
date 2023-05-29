package md.dragan.anastasia.graphs.kruskal;

public class KruskalAlgorithm {

    public Graph apply(Graph source) {
        // Verific dacă graful initial nu este null
        if (source == null) {
            return source;
        }

        // citesc numărul de noduri din graful inițial (graful în baza Kruskal va avea N-1 arce)
        int graphNodes = source.getNumberOfNodes();
        int[] parent = new int[graphNodes];
        for (int i = 0; i < graphNodes; i++) {
            parent[i] = i;
        }
        Graph kruskal = new Graph();
        source.sortWeigth();
        int edgeCount = 0;
        int index = 0;
        while (edgeCount < graphNodes-1) {
            // Citesc informatia din arcul: index
            Edge nextEdge = source.getEdges().get(index);

            // Caut dacă nodul sursă și destinație nu crează buclă (nu se reduc la acelasi nod)
            int x = findParent(parent, nextEdge.source.getValue());
            int y = findParent(parent, nextEdge.destination.getValue());

            // în cazul în care părinții dintre nodul  sursa si destinatie sunt diferiti, înseamnă că avem arc care  nu crează o buclă
            if (x!=y) {
                // adăugăm arcul la graful rezultat
                kruskal.addEdge(nextEdge);
                // setăm
                union(parent, x, y);
                edgeCount++;
            }
            index++;
        }
        return kruskal;
    }

    // Verific părintele nodului în baza recurenței
    private int findParent(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            return findParent(parent, parent[vertex]);
        }
        return vertex;
    }

    // Unim două grafuri, setânt nodului destinație ca părinte, nodul sursă
    private void union(int[] parent, int x, int y) {
        int xParent = findParent(parent, x);
        int yParent = findParent(parent, y);
        parent[yParent] = xParent;
    }

    // Metoda de bază pentru a începe testarea algoritmului
    public static void main(String[] args) {
        Graph graph = new Graph();  // creez un obiect  de tipul Graph
        graph.initiateDemoInformation(); // initiez graful cu
        System.out.println("-------------------------------------------");
        KruskalAlgorithm algorithm = new KruskalAlgorithm();
        Graph kruskal = algorithm.apply(graph);
        kruskal.print();
    }
}
