package Magazzino;

import java.util.LinkedList;
import java.util.Queue;

public class Magazzino {
    private final int capacita = 4;
    private final Queue<String> buffer = new LinkedList<>();


    public synchronized void deposita(String pacco) throws InterruptedException {
        while (buffer.size() == capacita) {
            wait();
        }
        buffer.add(pacco);
        System.out.println(Thread.currentThread().getName() + " deposita " + pacco +
                " (tot=" + buffer.size() + ")");
        notifyAll();
    }


    public synchronized String preleva(long timeout) throws InterruptedException {
        if (buffer.isEmpty()) {
            wait(timeout);
            if (buffer.isEmpty()) {
                return null;
            }
        }

        String pacco = buffer.poll();
        System.out.println(Thread.currentThread().getName() + " preleva " + pacco +
                " (tot=" + buffer.size() + ")");
        notifyAll();
        return pacco;
    }
}
