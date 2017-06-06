package esercizi;

/**
 * Created by Michele on 06/06/2017.
 */
public class Produttore extends Thread {
    private Mercato mrc;

    public Produttore(Mercato mrc) {
        this.mrc = mrc;
    }

    @Override
    public void run() {
        while (true) {
            int v = (int) (1 + Math.random() * 10);
            try {
                int guadagno = mrc.producoCiliegie(v);
                System.out.println(getName() + " produttore guadagna " + guadagno);
            } catch (InterruptedException r) {
            }
        }
    }
}
