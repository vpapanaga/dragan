package md.papanaga.usm.tap.laborator2;

// Clasa derivata "SteaGigantaRosie" care extinde clasa "Stea" si implementeaza interfata "Dimensiune"
public class SteaGigantaRosie extends Stea implements Dimensiune {
    private int diametru;

    public SteaGigantaRosie(String nume, float temperatura, int diametru) {
        super(nume, temperatura);
        this.diametru = diametru;
    }

    public int getDiametru() {
        return diametru;
    }

    @Override
    public void straluceste() {
        System.out.println("Stea gigantă roșie strălucește!");
    }

    @Override
    public void afisareDimensiune() {
        System.out.println("Diametrul stelei gigante roșii: " + diametru);
    }
}
