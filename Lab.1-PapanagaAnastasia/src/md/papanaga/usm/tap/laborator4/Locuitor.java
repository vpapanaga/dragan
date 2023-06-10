package md.papanaga.usm.tap.laborator4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Locuitor {
    int varsta;
    String numele;
    boolean sexMasculin;

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNumele() {
        return numele;
    }

    public void setNumele(String numele) {
        this.numele = numele;
    }

    public boolean isSexMasculin() {
        return sexMasculin;
    }

    public void setSexMasculin(boolean sexMasculin) {
        this.sexMasculin = sexMasculin;
    }

    public Locuitor(int varsta, String numele, boolean sexMasculin) {
        this.varsta = varsta;
        this.numele = numele;
        this.sexMasculin = sexMasculin;
    }

    public Locuitor() {
    }

    public void random() {
        Random random = new Random();
        String[] names = {"Petru", "Mihaela", "Anna", "Angela", "Pavel", "Ilie", "Dumitru", "Maria", "Gheorghe"};
        this.varsta = random.nextInt(100);
        this.numele = names[random.nextInt(names.length)];
        this.sexMasculin = random.nextBoolean();
    }



    @Override
    public String toString() {
        return "              " + numele + " (varsta: " +varsta + ", barbat: " + sexMasculin+ ")";
    }
}
