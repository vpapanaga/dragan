import java.util.Random;

public class MatriceRanduri extends Thread {
    private static final int NUMAR_RANDURI = 5;
    private static final int NUMAR_COLOANE = 5;

    private static int[][] matrice;
    private static double[] rezultate;

    private int rand;

    public MatriceRanduri(int rand) {
        this.rand = rand;
    }

    @Override
    public void run() {
        int numarPozitive = 0;
        int sumaPozitive = 0;

        for (int j = 0; j < NUMAR_COLOANE; j++) {
            if (matrice[rand][j] > 0) {
                numarPozitive++;
                sumaPozitive += matrice[rand][j];
            }
        }

        rezultate[rand] = numarPozitive > 0 ? (double) sumaPozitive / numarPozitive : 0;
    }

    public static void main(String[] args) {
        matrice = new int[NUMAR_RANDURI][NUMAR_COLOANE];
        rezultate = new double[NUMAR_RANDURI];

        Random random = new Random();
        for (int i = 0; i < NUMAR_RANDURI; i++) {
            for (int j = 0; j < NUMAR_COLOANE; j++) {
                matrice[i][j] = random.nextInt(100) - 50; // Generare aleatoare a valorilor matricei
            }
        }

        MatriceRanduri[] fire = new MatriceRanduri[NUMAR_RANDURI];

        for (int rand = 0; rand < NUMAR_RANDURI; rand++) {
            fire[rand] = new MatriceRanduri(rand);
            fire[rand].start();
        }

        try {
            for (int rand = 0; rand < NUMAR_RANDURI; rand++) {
                fire[rand].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double sumaMedii = 0;
        for (int rand = 0; rand < NUMAR_RANDURI; rand++) {
            System.out.println("Rândul " + rand + ": Media aritmetică a numerelor pozitive = " + rezultate[rand]);
            sumaMedii += rezultate[rand];
        }

        double mediaAritmetica = sumaMedii / NUMAR_RANDURI;
        System.out.println("Media aritmetică a tuturor rezultatelor: " + mediaAritmetica);
    }
}
