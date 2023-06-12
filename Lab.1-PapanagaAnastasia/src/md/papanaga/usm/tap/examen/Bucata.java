package md.papanaga.usm.tap.examen;

import java.util.List;

public abstract class Bucata {
    int numarIngrediente;
    List<String> denumireIngredient;

    public Bucata() {
    }

    public Bucata(int numarIngrediente) {
        this.numarIngrediente = numarIngrediente;
    }

    public abstract void print();
}
