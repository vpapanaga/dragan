package md.papanaga.usm.tap;

import md.papanaga.usm.tap.laborator4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Laborator4 {
    private static int MAX_STREETS = 10;
    private static int MAX_APARTAMENTE = 60;
    private static int MAX_SCARI = 5;
    private static int MAX_CAMERE = 5;

    private static int MAX_DIMENSIUNE_CAMERA = 100;

    private static int MAX_LOCUITORI = 5;
    private static int MAX_ETAJE = 16;
    private static int MAX_BLOCKS_STREET = 10;
    private static String LOAD_FILE_LOCUITORI = "./src/md/papanaga/usm/tap/laborator4/data/locuitori.csv";

    private static String LOAD_FILE_STRAZI = "./src/md/papanaga/usm/tap/laborator4/data/strazi.csv";
    private static String CSV_SPLITTER = ",";
    private static List<Locuitor> locuitori;
    private static List<Strada> strazi;

    public static List<Locuitor> getLocuitori() {
        if (locuitori == null) {
            locuitori = loadLocuitori();
        }
        return locuitori;
    }

    public static List<Strada> getStrazi() {
        if (strazi == null) {
            strazi = loadStrazi();
        }
        return strazi;
    }

    // Pentru simplitate citesc numele de locuitori din fisier
    public static List<Locuitor> loadLocuitori() {
        List<Locuitor> locuitori = new ArrayList<Locuitor>();
        try {
            FileReader fileReader = new FileReader(LOAD_FILE_LOCUITORI);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int record = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (record++ > 0) {
                    String[] values = line.split(CSV_SPLITTER);
                    Locuitor locuitor = new Locuitor();
                    locuitor.setNumele(values[0]);
                    locuitor.setVarsta(Integer.parseInt(values[1]));
                    if (values[2].equals("Masculin")) {
                        locuitor.setSexMasculin(true);
                    }
                    if (values[2].equals("Feminin")) {
                        locuitor.setSexMasculin(false);
                    }
                    locuitori.add(locuitor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locuitori;
    }

    // Citesc numele de strazi din fisierul cu strazi
    public static List<Strada> loadStrazi() {
        List<Strada> strazi = new ArrayList<Strada>();
        try {
            FileReader fileReader = new FileReader(LOAD_FILE_STRAZI);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int record = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (record++ > 0) {
                    Strada strada =  new Strada();
                    strada.setNumeleStrazii(line);
                    strazi.add(strada);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strazi;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numarulDeStrazi = random.nextInt(MAX_STREETS);
        List<Strada> chisinau = citesteStraziAleator(numarulDeStrazi);
        System.out.println("Se vor genera " + numarulDeStrazi + " strazi!");

        for (Strada strada: chisinau) {
           strada.setBlocuriLocative(genereazaBlocuriLocative());
        }
        // Verificam datele generate aleator
        System.out.println("=========================== Start Afisarea Datelor Generate ===========================");
        afseazaOrasul(chisinau, true);
        System.out.println("=========================== Gata Cu Afisarea Datelor Generate ===========================");

        System.out.println("\n----------------------------- Interogari in informatia generata -------------------");
        List<Strada> maxFemei = cautaBlocCuNumarMaximDefemei(chisinau);
        System.out.println("1. Blocul cu numarul maxim de femei este: ");
        afseazaOrasul(maxFemei, false);

        // Caut cel mai batran om din oras
        List<Strada> celMaiBatran = cautCelMaiBatranOm(chisinau);
        System.out.println("2. Informatie despre cel mai batran om: ");
        afseazaOrasul(celMaiBatran, true);

        // Caut strada  cu densitatea maxima de populatie
        Strada maxDensitate = cautaStradaCuDensitateMaxima(chisinau);
        System.out.println("3. Strada cu densitatea maxima este: "+maxDensitate);


    }

    private static List<Strada> cautaBlocCuNumarMaximDefemei(List<Strada> chisinau) {
        List<Strada> strazi = new ArrayList<Strada>();
        int numarMaximFemei = 0;
        for(Strada info:chisinau) {
            int numarFemeiBloc=0;
            for (BlocLocativ blocLocativ: info.getBlocuriLocative()) {
                for (Scara scara: blocLocativ.getScari()) {
                    for (Etaj etaj: scara.getEtaje()) {
                        for (Apartament apartament: etaj.getApartamente()) {
                            for (Locuitor locuitor: apartament.getLocuitori()) {
                                if (locuitor.isSexMasculin()!=true)  {
                                    numarFemeiBloc++;
                                }
                            }
                        }
                    }
                }
                if (numarMaximFemei < numarFemeiBloc) {
                    numarMaximFemei=numarFemeiBloc;
                    Strada selectat = info;
                    List<BlocLocativ> blocLocativs = new ArrayList<BlocLocativ>();
                    blocLocativs.add(blocLocativ);
                    info.setBlocuriLocative(blocLocativs);
                    if (strazi.size()>0) {
                        strazi.set(0,selectat);
                    } else {
                        strazi.add(selectat);
                    }
                }
            }
        }
        return strazi;
    }

    private static List<Strada> cautCelMaiBatranOm(List<Strada> chisinau) {
        List<Strada> strazi = new ArrayList<Strada>();
        int varstaMaxima = 0;
        for(Strada info:chisinau) {
            for (BlocLocativ blocLocativ: info.getBlocuriLocative()) {
                for (Scara scara: blocLocativ.getScari()) {
                    for (Etaj etaj: scara.getEtaje()) {
                        for (Apartament apartament: etaj.getApartamente()) {
                            for (Locuitor locuitor: apartament.getLocuitori()) {
                               if (locuitor.getVarsta() > varstaMaxima) {
                                   varstaMaxima = locuitor.getVarsta();
                                   strazi = seteazaStrada(info, blocLocativ, scara, etaj, apartament, locuitor);
                               }
                            }
                        }
                    }
                }
            }
        }
        return strazi;
    }

    private static List<Strada> seteazaStrada(Strada info, BlocLocativ blocLocativ, Scara scara, Etaj etaj, Apartament apartament, Locuitor locuitor) {
        // Creez lista de locuitori
        List<Locuitor> locuitori=new ArrayList<Locuitor>();
        locuitori.add(locuitor);
        // Creez lista de apartamente
        List<Apartament> apartamente = new ArrayList<Apartament>();
        Apartament apartament1 = new Apartament(apartament.getNumarApartament(),locuitori, null);
        apartamente.add(apartament1);
        // Creez etajul
        Etaj et = new Etaj(etaj.getNumarEtaj(), apartamente);
        List<Etaj> etajele = new ArrayList<Etaj>();
        etajele.add(et);
        // Creez scara
        Scara sc = new Scara(scara.getNumarScara(), etajele);
        List<Scara> scaraList = new ArrayList<Scara>();
        scaraList.add(sc);
        // Creez Blocul
        BlocLocativ bl = new BlocLocativ(blocLocativ.getNumarBloc(),scaraList);
        List<BlocLocativ> blocLocativList = new ArrayList<BlocLocativ>();
        blocLocativList.add(bl);
        // Creez strazile
        Strada st = new Strada(info.getNumeleStrazii(), blocLocativList);
        List<Strada> stradaList = new ArrayList<Strada>();
        stradaList.add(st);
        return stradaList;
    }

    private static Strada cautaStradaCuDensitateMaxima(List<Strada> chisinau) {
        Strada select = new Strada();
        double densitatea = 0;
        for (Strada strada: chisinau) {
            double densitateaStrazii = calculeazaDensitatea(strada);
            if (densitatea < densitateaStrazii) {
                densitatea = densitateaStrazii;
                select = strada;
            }
        }
        return select;
    }

    private static double calculeazaDensitatea(Strada strada) {
        double densitatea = 0;
        densitatea = calculeazaSuprafata(strada) / calculeazaLocuitori(strada);
        return densitatea;
    }

    private static int calculeazaLocuitori(Strada strada) {
        int total=0;
        for (BlocLocativ blocLocativ: strada.getBlocuriLocative()) {
            for (Scara scara: blocLocativ.getScari()) {
                for (Etaj etaj: scara.getEtaje()) {
                    for (Apartament apartament: etaj.getApartamente()) {
                        total+=apartament.getLocuitori().size();
                    }
                }
            }
        }
        return total;
    }

    private static double calculeazaSuprafata(Strada strada) {
       double total = 0;
       for (BlocLocativ blocLocativ: strada.getBlocuriLocative()) {
            for (Scara scara: blocLocativ.getScari()) {
                for (Etaj etaj: scara.getEtaje()) {
                    for (Apartament apartament: etaj.getApartamente()) {
                        for (Camera camera: apartament.getCamere()) {
                            total+=camera.getAria();
                        }
                    }
                }
            }
       }
       return total;
    }


    private static void afseazaOrasul(List<Strada> chisinau, boolean all) {
        for (Strada str: chisinau) {
            System.out.println(str);
            for (BlocLocativ bloc: str.getBlocuriLocative()) {
                System.out.println(bloc);
                if (all) {
                    for (Scara scara: bloc.getScari()) {
                        System.out.println(scara);
                        for(Etaj etaj: scara.getEtaje()) {
                            System.out.println(etaj);
                            for(Apartament apartament: etaj.getApartamente()) {
                                System.out.println(apartament);
                                System.out.println("              ------------- Lista Locatarilor ---------------");
                                for(Locuitor locuitor:apartament.getLocuitori()) {
                                    System.out.println(locuitor);
                                }
                                System.out.println("              ------------- Lista Camerelor ---------------");
                                if (apartament.getCamere()!=null) {
                                    for(Camera camera:apartament.getCamere()) {
                                        System.out.println(camera);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private static List<BlocLocativ> genereazaBlocuriLocative() {
        Random random = new Random();
        int blocksCount = 1+random.nextInt(MAX_BLOCKS_STREET-1);
        List<BlocLocativ> blocuri = new ArrayList<BlocLocativ>();
        int counter = 0;
        do {
            BlocLocativ bloc = new BlocLocativ();
            bloc.setNumarBloc(String.valueOf(1+random.nextInt(MAX_BLOCKS_STREET-1)));
            if (!blocuri.contains(bloc)) {
                bloc.setScari(genereazaScari());
                blocuri.add(bloc);
                counter++;
            }
        } while (counter!=blocksCount);
       return blocuri;
    }

    private static List<Scara> genereazaScari() {
        List<Scara> scari = new ArrayList<Scara>();
        Random random = new Random();
        int scariCount = 1+random.nextInt(MAX_SCARI-1);
        for (int i=0; i< scariCount; i++) {
            Scara scara = new Scara();
            scara.setNumarScara(String.valueOf(1+i));
            scara.setEtaje(genereazaEtaje());
            scari.add(scara);
        }
        return scari;
    }

    private static List<Etaj> genereazaEtaje() {
        List<Etaj> etaje = new ArrayList<Etaj>();
        Random random = new Random();
        int etajCount = 1+random.nextInt(MAX_ETAJE-1);
        for (int i=0; i< etajCount; i++) {
            Etaj etaj = new Etaj();
            etaj.setNumarEtaj(1+i);
            etaj.setApartamente(genereazaApartamente());
            etaje.add(etaj);
        }
        return etaje;
    }

    private static List<Apartament> genereazaApartamente() {
        List<Apartament> apartamente = new ArrayList<Apartament>();
        Random random = new Random();
        int maxApartamente = 1+random.nextInt(MAX_APARTAMENTE-1);
        for (int i=0; i< maxApartamente; i++) {
            Apartament apartament = new Apartament();
            apartament.setNumarApartament(1+i);
            apartament.setLocuitori(genereazaLocuitori());
            apartament.setCamere(genereazaCamere());
            apartamente.add(apartament);
        }
        return apartamente;
    }

    private static List<Camera> genereazaCamere() {
        List<Camera> camere = new ArrayList<Camera>();
        Random random = new Random();
        int numarCamere = 1+random.nextInt(MAX_CAMERE);
        for(int i=0;i<numarCamere;i++) {
            Camera info = new Camera();
            info.setCameraType(Camera.CameraType.Bucatarie);
            info.setAria(random.nextDouble()*MAX_DIMENSIUNE_CAMERA);
            camere.add(info);
        }
        return camere;
    }

    private static List<Locuitor> genereazaLocuitori() {
        List<Locuitor> locuitori = new ArrayList<Locuitor>();
        Random random = new Random();
        int maxApartamente = 1+random.nextInt(MAX_LOCUITORI-1);
        for (int i=0; i< maxApartamente; i++) {
            int index = random.nextInt(getLocuitori().size());
            if ((index>0)&&(index==getLocuitori().size())) {
                index--;
            }
            Locuitor locuitor = getLocuitori().get(index);
            locuitori.add(locuitor);
        }
        return locuitori;
    }



    private static List<Strada> citesteStraziAleator(int numarulDeStrazi) {
        Random random = new Random();
        List<Strada> list = new ArrayList<Strada>();
        int counter=0;
        do {
            int index = random.nextInt(getStrazi().size());
            if ((index>1) && (index==getStrazi().size())) {
                index--;
            }
            Strada info = getStrazi().get(index);
            if (!list.contains(info)) {
                list.add(info);
                counter++;
            }
        } while (counter!=numarulDeStrazi);
        return list;
    }


}
