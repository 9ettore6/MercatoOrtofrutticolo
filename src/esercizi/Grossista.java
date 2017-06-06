package esercizi;

/**
 * Created by Michele on 06/06/2017.
 */
public class Grossista extends Thread {
    private Mercato mrc;

    public Grossista(Mercato mrc) {
        this.mrc = mrc;
    }

    @Override
    public void run() {
        while (true) {
            int v = (int) (1 + Math.random() * 10);
            try {
                int guadagno = mrc.comproCiliegie(v);
                System.out.println(getName() + " grossista guadagna " + guadagno);
            } catch (InterruptedException r) {
            }
        }
    }
}
