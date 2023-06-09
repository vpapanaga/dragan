package md.papanaga.usm.tap;

import md.papanaga.usm.tap.laborator2.*;

import java.util.ArrayList;
import java.util.List;

public class Laborator2 {

    public static void main(String[] args) {
        SteaMainSequence steaMainSequence = new SteaMainSequence("Stea1", 5000.0f, 3.5f);
        SteaGigantaRosie steaGigantaRosie = new SteaGigantaRosie("Stea2", 4000.0f, 1000);
        SteaSupernova steaSupernova = new SteaSupernova("Stea3", 10000.0f, true);

        List<Stea> stele = new ArrayList<Stea>();
        stele.add(steaMainSequence);
        stele.add(steaGigantaRosie);
        stele.add(steaSupernova);

        for (Stea stea : stele) {
            stea.straluceste();
            stea.randomize();
            stea.introducereDate();
            stea.inscriereInFisier("date.txt");
            System.out.println();
        }

        if (steaMainSequence instanceof Stralucire) {
            Stralucire stralucire = (Stralucire) steaMainSequence;
            stralucire.afisareStralucire();
        }

        if (steaGigantaRosie instanceof Dimensiune) {
            Dimensiune dimensiune = (Dimensiune) steaGigantaRosie;
            dimensiune.afisareDimensiune();
        }

        SteaSupernova.staticMethod();
        SteaFinala.finalMethod();
    }
}
