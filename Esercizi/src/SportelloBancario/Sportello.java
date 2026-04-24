package SportelloBancario;

public class Sportello {

    private int cassieriLiberi = 2;

    public synchronized boolean accedi(long timeout) throws InterruptedException {
        long start = System.currentTimeMillis();
        long tempoRimanente = timeout;

        while (cassieriLiberi == 0) {
            if (tempoRimanente <= 0) {
                return false;
            }

            wait(tempoRimanente);

            long ora = System.currentTimeMillis();
            tempoRimanente = timeout - (ora - start);
        }


        cassieriLiberi--;
        return true;
    }

    public synchronized void lascia() {
        cassieriLiberi++;
        notifyAll();
    }


}
