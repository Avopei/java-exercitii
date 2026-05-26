// Fisier original: ex6/Exercitiul06.java

import java.util.Random;

class OverSaturated extends Exception{
    public OverSaturated(){
        super("Culoarea este suprasaturata dupa 10 incercari.");
    }
}

public class Exercitiul06{

    static double saturatieHSV(int r, int g, int b){
        int max = r;
        int min = r;

        if(g > max) max = g;
        if(b > max) max = b;
        if(g < min) min = g;
        if(b < min) min = b;

        if(max == 0){
            return 0;
        }

        return ((double)(max - min) / max) * 100.0;
    }

    static int[] genereazaCuloare() throws OverSaturated{
        Random random = new Random();
        int incercari = 0;

        while(incercari < 10){
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            double saturatie = saturatieHSV(r, g, b);

            System.out.println("Incercare " + (incercari + 1) + ": RGB(" + r + ", " + g + ", " + b + ") saturatie = " + saturatie);

            if(saturatie <= 90){
                assert saturatie <= 90 : "Saturatia este prea mare.";
                int culoare[] = new int[3];
                culoare[0] = r;
                culoare[1] = g;
                culoare[2] = b;
                return culoare;
            }

            incercari++;
        }

        throw new OverSaturated();
    }

    public static void main(String[] args){
        try{
            int culoare[] = genereazaCuloare();
            System.out.println("Culoare acceptata: RGB(" + culoare[0] + ", " + culoare[1] + ", " + culoare[2] + ")");
        }
        catch(OverSaturated e){
            System.out.println("Exceptie prinsa.");
            System.out.println(e.getMessage());
        }
    }
}
