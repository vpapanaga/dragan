package md.dragan.anastasia.graphs.kruskal;

/*
Clasa Edge va permite inregistrarea arcurilor din graf
 */
public class Edge {
    Node source; // Nodul de unde pleaca arcul
    Node destination; // Nodul unde ajunge arcul
    int weight; // costul asociat acestui arc

    // Creez constructorul cu parametri pentru clasa Adge
    public Edge(Node source, Node dest, int weight)
    {
        this.source = source;
        this.destination = dest;
        this.weight = weight;
    }

    // Rescriu metoda toString pentru a afisa rezultatele
    public String toString() {
        return "Source: "+this.source +"\tDestination: "+this.destination +"\tWeight:"+this.weight;
    }
}
