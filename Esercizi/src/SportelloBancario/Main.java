package SportelloBancario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Sportello sportello = new Sportello();

        int serviti = 0;
        int rinunciati = 0;

        List<Cliente> clienti = new ArrayList<>();


        for (int i = 0; i < 8; i++) {
            Cliente c = new Cliente(sportello, "Cliente-" + i);
            clienti.add(c);
            c.start();
        }

        for (Cliente c : clienti) {
            c.join();
            if (c.isServito()) {
                serviti++;
            } else {
                rinunciati++;
            }
        }

        System.out.println("Clienti serviti: " + serviti);
        System.out.println("Clienti rinunciati: " + rinunciati);
    }
}