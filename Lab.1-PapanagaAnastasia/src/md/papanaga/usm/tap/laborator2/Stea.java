package md.papanaga.usm.tap.laborator2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Clasa de baza abstracta "Stea"
public abstract class Stea {
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
