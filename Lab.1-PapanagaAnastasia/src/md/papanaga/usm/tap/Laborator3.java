package md.papanaga.usm.tap;

import md.papanaga.usm.tap.laborator3.*;
import md.papanaga.usm.tap.laborator3.exception.SteaException;

import java.util.ArrayList;
import java.util.List;

public class Laborator3 {

    public static void main(String[] args) {
        // Exceptie legata  de citirea unui fisier inexistent
        try {
            Stea steaDinFisier = new Stea("dummyInputFile.txt");
        } catch (SteaException e) {
            e.printStackTrace();
        }

        // PExceptie legata de relucrarea datelor eronate la  citire de la tastatura
        try {
            Stea steaDeLaTastaura = new Stea();
            steaDeLaTastaura.citeste();

        } catch (SteaException e) {
            e.printStackTrace();
        }

        // Exemplu cu iesirea din bucla
        boolean flag = false;
        List<Stea> stele = new ArrayList<Stea>();
        do {
            flag = false;
            try {
                Stea info = new Stea();
                info.citeste();
                stele.add(info);
            } catch (SteaException e) {
                flag=true;
            }
        } while (!flag);
        System.out.println("S-au citit de  la tastatura "+ stele.size()+ " stele!");

    }
}
