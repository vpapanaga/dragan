package md.papanaga.usm.tap.laborator1;

public class Planeta {
    String nume; // char[50]
    float masa;

    public Planeta(String nume, float masa) {
        this.nume = nume;
        this.masa = masa;
    }

    public String toString() {
        return "Numele Planetei: " + nume + " \t| Masa Planetei: " + masa;
    }
}
