package SportelloBancario;

import java.util.Random;

public class Cliente extends Thread {

    Random rand = new Random();

    private Sportello sportello;
    private boolean servito = false;


    public Cliente(Sportello s, String nome) {
        super(nome);
        this.sportello = s;
    }

    public boolean isServito() {
        return servito;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " arriva allo sportello");

            boolean ottenuto = sportello.accedi(5000);

            if (!ottenuto) {
                System.out.println(getName() + " rinuncia");
                return;
            }

            System.out.println(getName() + " viene servito");

            servito = true;

            int tempoServizio = 2000 + rand.nextInt(2000);
            Thread.sleep(tempoServizio);

            System.out.println(getName() + " termina il servizio");

            sportello.lascia();

        } catch (InterruptedException e) {
            System.out.println("Sistema fallito");
        }
    }
}
