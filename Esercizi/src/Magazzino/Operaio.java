package Magazzino;

import java.util.Random;

public class Operaio extends Thread {
    private final Magazzino magazzino;
    private final int pacchiDaProdurre = 5;
    private final Random rand = new Random();

    public Operaio(String nome, Magazzino m) {
        super(nome);
        this.magazzino = m;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= pacchiDaProdurre; i++) {
                Thread.sleep(1000 + rand.nextInt(2000)); 
                String pacco = getName() + i;
                magazzino.deposita(pacco);
            }
            System.out.println(getName() + " ha finito.");
        } catch (InterruptedException e) {
            System.out.println("Sistema fallito");
        }
    }
}
