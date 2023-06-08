package md.papanaga.usm.tap.laborator1;

import java.io.*;
import java.util.*;

public class Stea {
    String denumirea;
    double masa;
    int numarulDePlanete;
    List<Planeta> planete;
    static int numarulDeObiecte;

    // Constructor fara parametri
    public Stea() {
        planete = new ArrayList<Planeta>();
    }

    // Constructor cu 4 parametri
    public Stea(int numarulDePlanete, List<Planeta> planete, double masa, String denumirea) {
        this.numarulDePlanete = numarulDePlanete;
        this.planete = new ArrayList<Planeta>(planete);
        this.masa = masa;
        this.denumirea = denumirea;
    }

    // Constructor cu 3 parametri
    public Stea(int numarulDePlanete, double masa, String denumirea) {
        this.numarulDePlanete = numarulDePlanete;
        this.masa = masa;
        this.denumirea = denumirea;
        planete = new ArrayList<Planeta>();
    }

    // Constructor de copiere
    public Stea(Stea info) {
        this.numarulDePlanete = info.numarulDePlanete;
        this.denumirea = info.denumirea;
        this.masa = info.masa;
        if ((info.planete!=null) && (info.planete.size()>0)) {
            this.planete = new ArrayList<Planeta>(info.planete);
        } else {
            this.planete = new ArrayList<Planeta>();
        }
    }

    // La tiparirea obiectului
    public String toString() {
        String info = "Stea | denumirea: " + denumirea + "\t| Masa: = " + masa + "\t| Numarul de planete: " + numarulDePlanete;
        for(Planeta planeta:planete) {
            info += "\n\t--> "+planeta;
        }
        return info;
    }

    public int getNumarulDePlanete() {
        return numarulDePlanete;
    }

    public void setNumarulDePlanete(int numarulDePlanete) {
        this.numarulDePlanete = numarulDePlanete;
    }

    public List<Planeta> getPlanete() {
        return planete;
    }

    public void setPlanete(List<Planeta> planete) {
        this.planete = planete;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public String getDenumirea() {
        return denumirea;
    }

    public void setDenumirea(String denumirea) {
        this.denumirea = denumirea;
    }

    public static int getNumarulDeObiecte() {
        return numarulDeObiecte;
    }

    public static void setNumarulDeObiecte(int numarulDeObiecte) {
        Stea.numarulDeObiecte = numarulDeObiecte;
    }

    public void citeste() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Introduceti informatiile despre stea");
        System.out.println("-------------------------------------------------");
        System.out.println("Denumirea: ");
        this.denumirea = reader.next();
        System.out.println("Masa Stelei: ");
        this.masa = reader.nextDouble();
        System.out.println("Numarul de planete: ");
        this.numarulDePlanete = reader.nextInt();
        if (numarulDePlanete > 0) {
            for (int i = 0; i<numarulDePlanete; i++) {
                System.out.println("Introduceti informatii despre planeta: " + (i+1));
                System.out.println("\tDenumirea: ");
                String denumireaPlanetei = reader.next();
                System.out.println("\tMasa:");
                float masaPlaneta = reader.nextFloat();
                this.planete.add(new Planeta(denumireaPlanetei,masaPlaneta));
            }
        }

        Stea.numarulDeObiecte++;
    }

    public void init() {
        long MAX_STRING = 999999999L;
        this.denumirea = String.valueOf((long) (Math.random() * MAX_STRING));
        this.masa = (Math.random() * MAX_STRING);
        this.numarulDePlanete = (int) (Math.random() * 10);
        if (numarulDePlanete > 0) {
            for (int i = 0; i<numarulDePlanete; i++) {
                String denumireaPlanetei = String.valueOf((long) (Math.random() * MAX_STRING));
                float masaPlaneta = (float)(Math.random() * MAX_STRING);
                this.planete.add(new Planeta(denumireaPlanetei,masaPlaneta));
            }
        }
        Stea.numarulDeObiecte++;
    }

    // Calculeaza masa tuturor planetelor din stea
    public float calculeazaMasaPlanete() {
        float masa =0;
        for(Planeta x: planete) {
            masa+=x.masa;
        }
        return masa;
    }

    public void comparaStele(Stea info) {
        if (masa < info.masa) {
            System.out.println("Masa stelei "+denumirea+ " este mai mica ca masa stelei " + info.denumirea);
        } else {
            System.out.println("Masa stelei "+denumirea+ " este mai mare ca masa stelei " + info.denumirea);
        }

        if (calculeazaMasaPlanete() < info.calculeazaMasaPlanete()) {
            System.out.println("Masa planetelor stelei "+denumirea+ " este mai mica ca masa planetelor stelei " + info.denumirea);
        } else {
            System.out.println("Masa planetelor stelei "+denumirea+ " este mai mare ca masa planetelor stelei " + info.denumirea);
        }

        if (calculeazaMasaPlanete()+masa < info.calculeazaMasaPlanete()+ info.masa) {
            System.out.println("Masa sumara a planetelor + stelei "+denumirea+ " este mai mica ca masa sumara a planetelor stelei " + info.denumirea);
        } else {
            System.out.println("Masa sumara a planetelor + stelei "+denumirea+ " este mai mare ca masa sumara a planetelor stelei " + info.denumirea);
        }
    }

    public int compara(Stea stea) {
        double masaSteaCurenta = calculeazaMasaPlanete() + masa;
        double masaSteaParametru = stea.calculeazaMasaPlanete() + stea.masa;
        if (masaSteaCurenta < masaSteaParametru) {
            return -1;
        } else if (masaSteaCurenta > masaSteaParametru) {
            return 1;
        } else {
            return 0;
        }
    }


    public void absorb(Stea info1) {
        masa+=info1.masa;
        info1.masa = 0;
        for (Planeta planeta: info1.planete) {
            masa+=planeta.masa;
            planeta.masa=0;
        }
    }
    // Constructor care primește ca parametru denumirea fișierului textual și încarcă valorile pentru câmpurile obiectului creat
    public Stea(String denumireaFisierului) {
        planete = new ArrayList<Planeta>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(denumireaFisierului));
            br.readLine();
            denumirea = br.readLine();
            masa = Float.parseFloat(br.readLine());
            numarulDePlanete = Integer.parseInt(br.readLine());
            br.readLine();
            for (int i=0;i<numarulDePlanete;i++) {
                br.readLine();
                String numePlaneta = br.readLine();
                float masaPlaneta = Float.parseFloat(br.readLine());
                planete.add(new Planeta(numePlaneta,masaPlaneta));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salveazaInFisier(String numeFisier) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(numeFisier));
            bw.write("------ Informatie despre stea ------------");
            bw.newLine();
            bw.write(denumirea);
            bw.newLine();
            bw.write(Double.toString(masa));
            bw.newLine();
            bw.write(Integer.toString(numarulDePlanete));
            bw.newLine();
            bw.write("------- Informatii Despre Planete --------");
            bw.newLine();
            int i=0;
            for(Planeta p: planete) {
                bw.write("------- Planeta "+(++i)+" ------------------------");
                bw.newLine();
                bw.write(p.nume);
                bw.newLine();
                bw.write(Float.toString(p.masa));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Salvez informatia in fisier dupa numele: [stelei].txt
    public void dump() {
        salveazaInFisier(this.denumirea+".txt");
    }
}