package md.dragan.anastasia.graphs.kruskal;

public class Node {
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return ""+value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return this.getValue() == ((Node) obj).getValue();
    }
}
