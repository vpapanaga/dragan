package md.papanaga.usm.tap.laborator2;

// Clasa derivata "SteaSupernova" care extinde clasa "Stea"
public  class SteaSupernova extends Stea {
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
