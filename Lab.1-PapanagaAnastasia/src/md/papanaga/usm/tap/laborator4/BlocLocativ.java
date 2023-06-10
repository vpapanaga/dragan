package md.papanaga.usm.tap.laborator4;

import java.util.ArrayList;
import java.util.List;

public class BlocLocativ {
    String numarBloc;
    List<Scara> scari;

    public BlocLocativ() {
        scari = new ArrayList<Scara>();
    }

    public BlocLocativ(String numarBloc, List<Scara> scari) {
        this.numarBloc = numarBloc;
        this.scari = scari;
    }

    public String getNumarBloc() {
        return numarBloc;
    }

    public void setNumarBloc(String numarBloc) {
        this.numarBloc = numarBloc;
    }

    public List<Scara> getScari() {
        return scari;
    }

    public void setScari(List<Scara> scari) {
        this.scari = scari;
    }

    @Override
    public String toString() {
        return "    "+numarBloc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlocLocativ that = (BlocLocativ) o;

        if (numarBloc != null ? !numarBloc.equals(that.numarBloc) : that.numarBloc != null) return false;
        return scari != null ? scari.equals(that.scari) : that.scari == null;
    }

    @Override
    public int hashCode() {
        int result = numarBloc != null ? numarBloc.hashCode() : 0;
        result = 31 * result + (scari != null ? scari.hashCode() : 0);
        return result;
    }
}
