import java.util.Scanner;
import java.io.*;

// Clasa de baza abstracta "Stea"
abstract class Stea {
    private String nume;
    private float temperatura;

    public Stea(String nume, float temperatura) {
        this.nume = nume;
        this.temperatura = temperatura;
    }

    public String getNume() {
        return nume;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public abstract void straluceste();

    public static void randomize() {
        System.out.println("Randomize in clasa de baza");
    }

    public void introducereDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numele stelei: ");
        nume = scanner.nextLine();
        System.out.print("Introduceti temperatura stelei: ");
        temperatura = scanner.nextFloat();
    }

    public void inscriereInFisier(String numeFisier) {
        try {
            FileWriter writer = new FileWriter(numeFisier, true);
            writer.write("Nume: " + nume + ", Temperatura: " + temperatura + "\n");
            writer.close();
            System.out.println("Datele au fost inregistrate in fisier.");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier.");
            e.printStackTrace();
        }
    }
}

// Interfata "Stralucire"
interface Stralucire {
    void afisareStralucire();
}

// Interfata "Dimensiune"
interface Dimensiune {
    void afisareDimensiune();
}

// Clasa derivata "SteaMainSequence" care extinde clasa "Stea" si implementeaza interfata "Stralucire"
class SteaMainSequence extends Stea implements Stralucire {
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

// Clasa derivata "SteaGigantaRosie" care extinde clasa "Stea" si implementeaza interfata "Dimensiune"
class SteaGigantaRosie extends Stea implements Dimensiune {
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

// Clasa derivata "SteaSupernova" care extinde clasa "Stea"
class SteaSupernova extends Stea {
    private boolean explozie;

    public SteaSupernova(String nume, float temperatura, boolean explozie) {
        super(nume, temperatura);
        this.explozie = explozie;
    }

    public boolean hasExplozie() {
        return explozie;
    }

    @Override
    public void straluceste() {
        System.out.println("Stea supernovă strălucește!");
    }

    public static void staticMethod() {
        System.out.println("Aceasta este o metoda statica.");
    }
}

// Clasa finala "SteaFinala"
final class SteaFinala {
    public static void finalMethod() {
        System.out.println("Aceasta este o metoda finala.");
    }
}

public class Main {
    public static void main(String[] args) {
        SteaMainSequence steaMainSequence1 = new SteaMainSequence("Stea1", 5000.0f, 3.5f);
        SteaGigantaRosie steaGigantaRosie1 = new SteaGigantaRosie("Stea2", 4000.0f, 1000);
        SteaSupernova steaSupernova1 = new SteaSupernova("Stea3", 10000.0f, true);

        Stea[] stele = new Stea[3];
        stele[0] = steaMainSequence1;
        stele[1] = steaGigantaRosie1;
        stele[2] = steaSupernova1;

        for (Stea stea : stele) {
            stea.straluceste();
            stea.randomize();
            stea.introducereDate();
            stea.inscriereInFisier("date.txt");
            System.out.println();
        }

        if (steaMainSequence1 instanceof Stralucire) {
            Stralucire stralucire = (Stralucire) steaMainSequence1;
            stralucire.afisareStralucire();
        }

        if (steaGigantaRosie1 instanceof Dimensiune) {
            Dimensiune dimensiune = (Dimensiune) steaGigantaRosie1;
            dimensiune.afisareDimensiune();
        }

        SteaSupernova.staticMethod();
        SteaFinala.finalMethod();
    }
}
