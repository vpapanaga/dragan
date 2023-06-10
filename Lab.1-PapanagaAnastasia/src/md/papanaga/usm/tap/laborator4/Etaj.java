package md.papanaga.usm.tap.laborator4;

import java.util.ArrayList;
import java.util.List;

public class Etaj {
    int numarEtaj;
    List<Apartament> apartamente;

    public Etaj() {
        apartamente =  new ArrayList<Apartament>();
    }

    public Etaj(int numarEtaj, List<Apartament> apartamente) {
        this.numarEtaj = numarEtaj;
        this.apartamente = apartamente;
    }

    public int getNumarEtaj() {
        return numarEtaj;
    }

    public void setNumarEtaj(int numarEtaj) {
        this.numarEtaj = numarEtaj;
    }

    public List<Apartament> getApartamente() {
        return apartamente;
    }

    public void setApartamente(List<Apartament> apartamente) {
        this.apartamente = apartamente;
    }

    @Override
    public String toString() {
        return "        " +numarEtaj;
    }
}
