package esercizi;

/**
 * Created by Michele on 06/06/2017.
 */
public class Principale {
    public static void main(String[] args){
        Mercato mrc = new Mercato(200);
        for (int i = 0; i < 4; i++) {
            Produttore prd = new Produttore(mrc);
            prd.start();
        }
        for (int i = 0; i < 4; i++) {
            Grossista grs = new Grossista(mrc);
            grs.start();
        }
    }
}
