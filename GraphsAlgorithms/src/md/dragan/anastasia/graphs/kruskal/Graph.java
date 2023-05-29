package md.dragan.anastasia.graphs.kruskal;

import java.util.*;

public class Graph {
    private List<Edge> graphEdges;
    private List<Node> nodes;

    public Graph() {
        graphEdges = new ArrayList<Edge>();
        nodes = new ArrayList<Node>();
    }

    public void initiateDemoInformation() {
        graphEdges = new ArrayList<Edge>(
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
    // This method will implement reading of the graph from keyboard
    public void readInfo() {

    }

    //
    public void sortWeigth() {
        graphEdges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });
    }

    public void sortSource() {
        graphEdges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.source.getValue() - o2.source.getValue();
            }
        });
    }

    public void sortDestination() {
        graphEdges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.destination.getValue() - o2.destination.getValue();
            }
        });
    }

    // Display the number of edges in Graph
    public int getNumberOfEdges() {
        return graphEdges.size();
    }

    public List<Edge> getEdges() {
        return  graphEdges;
    }

    public void addEdge(Edge edge) {
        graphEdges.add(edge);
        updateNodes();
    }


    // Get the number of nodes  in the graph
    public int getNumberOfNodes() {
       return this.getNodes().size();
    }

    public List<Node> getNodes() {
        if ((nodes.size() == 0) && (graphEdges!=null) && (graphEdges.size()>0)) {
            for (Edge edge: graphEdges) {
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

    private void updateNodes() {
        if ((graphEdges!=null) && (graphEdges.size()>0)) {
            nodes = new ArrayList<Node>();
            for (Edge edge: graphEdges) {
                if (!nodes.contains(edge.source)) {
                    nodes.add(edge.source);
                }
                if (!nodes.contains(edge.destination)) {
                    nodes.add(edge.destination);
                }
            }
        }
    }
    // Get the number of nodes  in the graph
    public boolean containsNode(Node node) {
        if (getNodes()==null) {
            return false;
        }
        return getNodes().contains(node);
    }


    public void print() {
        if ((graphEdges!=null) && (graphEdges.size()>0)) {
            for (Edge edge: graphEdges) {
                System.out.println(edge);
            }
        } else {
            System.out.println("The Graph did not have any edges!");
        }
    }

}
