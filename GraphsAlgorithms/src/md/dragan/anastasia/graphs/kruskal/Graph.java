package md.dragan.anastasia.graphs.kruskal;

import java.util.*;

public class Graph {
    /*
    Clasa graf este definită prin:
    - lista de noduri (nodes)
    - lista de arcuri (edges)
    care interconectează două  noduri
     */
    private List<Node> nodes;
    private List<Edge> edges;

    // Ccnstructorul fără parametri initializează lista de noduri și arcuri
    public Graph() {
        edges = new ArrayList<Edge>();
        nodes = new ArrayList<Node>();
    }

    // Metoda care initiază graful cu date initiale
    public void initiateDemoInformation() {
        edges = new ArrayList<Edge>(
                Arrays.asList(
                        new Edge(new Node(0), new Node(1), 4),
                        new Edge(new Node(0), new Node(7), 8),
                        new Edge(new Node(1), new Node(2), 8),
                        new Edge(new Node(1), new Node(7), 11),
                        new Edge(new Node(2), new Node(3), 7),
                        new Edge(new Node(2), new Node(5), 4),
                        new Edge(new Node(2), new Node(8), 2),
                        new Edge(new Node(3), new Node(4), 9),
                        new Edge(new Node(3), new Node(5), 14),
                        new Edge(new Node(4), new Node(5), 10),
                        new Edge(new Node(5), new Node(6), 2),
                        new Edge(new Node(6), new Node(7), 1),
                        new Edge(new Node(6), new Node(8), 6),
                        new Edge(new Node(7), new Node(8), 7)
                )
        );
    }
    // Această metodă are ca scop crearea unui graf de la tastatura
    public void readInfo() {

    }

    // Această metodă sortează arcurile graful după ponderea arcurilor
    public void sortWeigth() {
        edges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });
    }

    // Această metodă sortează arcurile grafului după nodul sursă
    public void sortSource() {
        edges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.source.getValue() - o2.source.getValue();
            }
        });
    }

    // Această metodă sortează arcurile grafului după nodul destinație
    public void sortDestination() {
        edges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.destination.getValue() - o2.destination.getValue();
            }
        });
    }

    // Această metodă afișează numărul de arcuri din graf
    public int getNumberOfEdges() {
        return edges.size();
    }

    // Această metodă întoarce liista  de arcuri din graf
    public List<Edge> getEdges() {
        return edges;
    }

    // Această metodă adaugă un arc  nou în graf
    public void addEdge(Edge edge) {
        edges.add(edge);
        updateNodes();
    }


    // Această metodă afișează  numărul de noduri din graf
    public int getNumberOfNodes() {
       return this.getNodes().size();
    }

    // Această metodă întoarce lista unică de noduri din Graf în baza arcurilor definite.
    public List<Node> getNodes() {
        if ((nodes.size() == 0) && (edges !=null) && (edges.size()>0)) {
            for (Edge edge: edges) {
                if (!nodes.contains(edge.source)) {
                    nodes.add(edge.source);
                }
                if (!nodes.contains(edge.destination)) {
                    nodes.add(edge.destination);
                }
            }
        }
        return nodes;
    }

    // Această metodă recalculează numărul de noduri  în baza arcurilor introduse
    private void updateNodes() {
        if ((edges !=null) && (edges.size()>0)) {
            nodes = new ArrayList<Node>();
            for (Edge edge: edges) {
                if (!nodes.contains(edge.source)) {
                    nodes.add(edge.source);
                }
                if (!nodes.contains(edge.destination)) {
                    nodes.add(edge.destination);
                }
            }
        }
    }
    // Această metodă verifică dacă graful contine deja un nod.
    public boolean containsNode(Node node) {
        if (getNodes()==null) {
            return false;
        }
        return getNodes().contains(node);
    }


    // Această metodă afisează nodurile, arcurile, ponderea din graf
    public void print() {
        if ((edges !=null) && (edges.size()>0)) {
            for (Edge edge: edges) {
                System.out.println(edge);
            }
        } else {
            System.out.println("The Graph did not have any edges!");
        }
    }

}
