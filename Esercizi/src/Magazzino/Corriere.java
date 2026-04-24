package Magazzino;

import java.util.Random;

public class Corriere extends Thread {

    Random rand = new Random();

    private final Magazzino magazzino;
    private int tentativiFalliti = 0;

    public Corriere(Magazzino m) {
        super("Corriere");
        this.magazzino = m;
    }

    @Override
    public void run() {
        try {
            while (tentativiFalliti < 3) {
                String pacco = magazzino.preleva(4000);

                if (pacco == null) {
                    tentativiFalliti++;
                    System.out.println("Magazzino vuoto (tentativo " + tentativiFalliti + ")");
                } else {
                    tentativiFalliti = 0;
                    Thread.sleep(2000 + rand.nextInt(2000)); // 2–4 sec
                    System.out.println("Consegnato " + pacco);
                }
            }

            System.out.println("Corriere termina: nessun pacco dopo 3 tentativi.");
        } catch (InterruptedException e) {
            System.out.println("Sistema fallito");
        }
    }
}
