package md.papanaga.usm.tap.laborator4;

import java.util.ArrayList;
import java.util.List;

public class Apartament {
    int numarApartament;
    List<Locuitor> locuitori;
    List<Camera> camere;

    public Apartament() {
        locuitori =  new ArrayList<Locuitor>();
        camere = new ArrayList<Camera>();
    }

    public Apartament(int numarApartament, List<Locuitor> locuitori, List<Camera> camere) {
        this.numarApartament = numarApartament;
        this.locuitori = locuitori;
        this.camere = camere;
    }

    public int getNumarApartament() {
        return numarApartament;
    }

    public void setNumarApartament(int numarApartament) {
        this.numarApartament = numarApartament;
    }

    public List<Locuitor> getLocuitori() {
        return locuitori;
    }

    public void setLocuitori(List<Locuitor> locuitori) {
        this.locuitori = locuitori;
    }

    public List<Camera> getCamere() {
        return camere;
    }

    public void setCamere(List<Camera> camere) {
        this.camere = camere;
    }

    @Override
    public String toString() {
        return "            "+numarApartament;
    }
}
