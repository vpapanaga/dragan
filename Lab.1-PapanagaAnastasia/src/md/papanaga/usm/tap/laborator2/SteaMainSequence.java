package md.papanaga.usm.tap.laborator2;

// Clasa derivata "SteaMainSequence" care extinde clasa "Stea" si implementeaza interfata "Stralucire"
public class SteaMainSequence extends Stea implements Stralucire {
    private float magnitudine;

    public SteaMainSequence(String nume, float temperatura, float magnitudine) {
        super(nume, temperatura);
        this.magnitudine = magnitudine;
    }

    public float getMagnitudine() {
        return magnitudine;
    }

    @Override
    public void straluceste() {
        System.out.println("Stea de secvență principală strălucește!");
    }

    @Override
    public void afisareStralucire() {
        System.out.println("Magnitudinea stelei de secvență principală: " + magnitudine);
    }
}