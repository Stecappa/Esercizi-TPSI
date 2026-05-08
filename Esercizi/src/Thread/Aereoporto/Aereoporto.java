package Thread.Aereoporto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Aereoporto {

    private int gateNazionali;
    private int gateInternazionali;

    private final ReentrantLock lock;

    private final Condition attendiNazionale;

    private int gateNazionaliLiberi;

    public Aereoporto(int gateNazionali, int gateInternazionali) {
        this.gateNazionali = gateNazionali;
        this.gateInternazionali = gateInternazionali;
        this.gateNazionaliLiberi = gateNazionali;
        this.lock = new ReentrantLock();
        this.attendiNazionale = lock.newCondition();
    }

    public void acquisisciGateNazionale(Volo v) throws InterruptedException {
        lock.lock();

        try {
            while (gateNazionaliLiberi == 0) attendiNazionale.await();
            gateInternazionali--;
            System.out.println("VROOM");
        } finally {
            lock.unlock();
        }
    }

    public void rilasciaGateNazionale(Volo v) throws InterruptedException {
        lock.lock();

        try {
            gateNazionaliLiberi++;
            attendiNazionale.signal();
        } finally {
            lock.unlock();
        }


    }
}

