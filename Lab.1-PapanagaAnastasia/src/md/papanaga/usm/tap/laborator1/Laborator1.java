package md.papanaga.usm.tap.laborator1;

import md.papanaga.usm.tap.laborator1.Planeta;
import md.papanaga.usm.tap.laborator1.Stea;

import java.util.ArrayList;
import java.util.List;

public class Laborator1 {


    private static void testConstructor() {
        Stea soare = new Stea();
        soare.setMasa(4454F);
        soare.setDenumirea("Soare");
        soare.setNumarulDePlanete(9);
        // soare.masa = 2324234F;
        System.out.println(soare);

        Stea aldebaran = new Stea(25, 563343256F, "Aldebaran");
        System.out.println(aldebaran);

        // Obiect Creat prin constructor cu copiere
        Stea mixta = new Stea(aldebaran);
        mixta.setDenumirea(soare.getDenumirea());
        System.out.println(aldebaran);
    }


    private static void initWithArray() {
        Planeta marte = new Planeta("Marte", 2344455.0F);
        List<Planeta> planeteleStelei = new ArrayList<Planeta>();
        planeteleStelei.add(new Planeta("Mercur",187F));
        planeteleStelei.add(new Planeta("Venus",245F));
        planeteleStelei.add(new Planeta("Uranus",435F));
        planeteleStelei.add(new Planeta("Jupiter",434534F));

        Stea soare = new Stea(4,planeteleStelei,3435343534534F,"Soare");
        System.out.println(soare);
    }

    private static void gauraNeagra(Stea info, Stea info1) {
        if (info.compara(info1)==1) {
            info.absorb(info1);
        } else {
            info1.absorb(info);
        }
    }

    public static void main(String[] args) {
       // testGauraNeagra();
/*        Stea soare = new Stea("Info.txt");
      //  soare.citesteDinFisier("Info.txt");
        System.out.println(soare);

        soare.salveazaInFisier("InfoNou.txt");*/

        Stea prima = new Stea();
        prima.init();
        Stea aDoua = new Stea();
        aDoua.init();

        prima.dump();
        aDoua.dump();

    }

    private static void testGauraNeagra() {
        // Testare de constructori
        // testConstructor();
        //
        // initWithArray();
        Stea info = new Stea();
        //   info.citeste();

        // initializez obiectul cu valori aleatoare
        info.init();
        System.out.println(info);
        System.out.println("Masa Tuturor planetelor este: " + info.calculeazaMasaPlanete());
        System.out.println("----------------------------------------------------------");

        // Creez alt obiect de tip stea cu valori aleatoare
        Stea info1 = new Stea();
        info1.init();
        System.out.println(info1);
        System.out.println("Masa Tuturor planetelor este: " + info1.calculeazaMasaPlanete());

        System.out.println("----------------------------------------------------------");
        // Compara stelele
        info.comparaStele(info1);

        System.out.println(info.compara(info1));
        System.out.println(info1.compara(info));
        System.out.println(info.compara(info));

        gauraNeagra(info, info1);
        System.out.println(info);
        System.out.println(info1);
    }
}
