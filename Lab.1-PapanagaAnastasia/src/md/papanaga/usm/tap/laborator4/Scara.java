package md.papanaga.usm.tap.laborator4;

import java.util.ArrayList;
import java.util.List;

public class Scara {
    String numarScara;
    List<Etaj> etaje;

    public Scara() {
        etaje  = new ArrayList<Etaj>();
    }

    public Scara(String numarScara, List<Etaj> etaje) {
        this.numarScara = numarScara;
        this.etaje = etaje;
    }

    public String getNumarScara() {
        return numarScara;
    }

    public void setNumarScara(String numarScara) {
        this.numarScara = numarScara;
    }

    public List<Etaj> getEtaje() {
        return etaje;
    }

    public void setEtaje(List<Etaj> etaje) {
        this.etaje = etaje;
    }

    @Override
    public String toString() {
        return "      "+numarScara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scara scara = (Scara) o;

        return numarScara.equals(scara.numarScara);
    }

    @Override
    public int hashCode() {
        return numarScara.hashCode();
    }
}
