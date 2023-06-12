package md.papanaga.usm.tap.examen;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Bucata implements Client {
    short pretul;

    public Pizza(int numarIngrediente, short pretul) {
        super(numarIngrediente);
        this.pretul = pretul;
    }

    @Override
    public void print() {

    }


    @Override
    public void mananca() {

    }

    float functia(byte  a) {
        try {
            if (a==100) new Throwable();
        }  catch (Exception exception) {
            a*=2;
        }
        return a;
    }

    public static void main(String[] args) {

        Pizza info = new Pizza(1,(short)1);
        float result = info.functia((byte) 100);
        System.out.println("result = " + result);


    }
}
