package esercizi;

import java.util.concurrent.Semaphore;

/**
 * Created by Michele on 06/06/2017.
 */
public class Mercato {
    private Semaphore ciliegie;
    private Semaphore mercato;
    private static final int Pv = 3;
    private static final int Pa = 2;

    public Mercato(int m) {
        mercato = new Semaphore(m);
        ciliegie = new Semaphore(0);
    }

    public int producoCiliegie(int v) throws InterruptedException {
        mercato.acquire(v);
        ciliegie.release(v);
        System.out.println("Aggiunte " + v + " totale: " + ciliegie.availablePermits());
        return v * Pv;
    }

    public int comproCiliegie(int v) throws InterruptedException {
        mercato.release(v);
        ciliegie.acquire(v);
        System.out.println("Tolte " + v + " totale: " + ciliegie.availablePermits());
        return v * Pa;
    }

}
