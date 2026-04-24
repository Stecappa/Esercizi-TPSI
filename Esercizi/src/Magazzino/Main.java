package Magazzino;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Magazzino magazzino = new Magazzino();

        Operaio o1 = new Operaio("Operaio1", magazzino);
        Operaio o2 = new Operaio("Operaio2", magazzino);
        Operaio o3 = new Operaio("Operaio3", magazzino);

        Corriere corriere = new Corriere(magazzino);

        o1.start();
        o2.start();
        o3.start();
        corriere.start();

        o1.join();
        o2.join();
        o3.join();
        corriere.join();

        System.out.println("Simulazione terminata.");
    }
}
