package esercizi;

import java.util.concurrent.Semaphore;

/**
 * Created by Michele on 06/06/2017.
 */
public class Mercato {
    private Semaphore mutex;
    private Semaphore ciliegie;
    private Semaphore mercato;
    private static final int Pv = 3;
    private static final int Pa = 2;

    public Mercato(int m) {
        mutex = new Semaphore(1);
        mercato = new Semaphore(m);
        ciliegie = new Semaphore(0);
    }

    public int producoCiliegie(int v) throws InterruptedException {
        mutex.acquire();
        mercato.acquire(v);
        ciliegie.release(v);
        System.out.println("Aggiunte " + v + " totale: " + ciliegie.availablePermits());
        mutex.release();
        return v * Pv;
    }

    public int comproCiliegie(int v) throws InterruptedException {
        mutex.acquire();
        mercato.release(v);
        ciliegie.acquire(v);
        System.out.println("Tolte " + v + " totale: " + ciliegie.availablePermits());
        mutex.release();
        return v * Pa;
    }

}
