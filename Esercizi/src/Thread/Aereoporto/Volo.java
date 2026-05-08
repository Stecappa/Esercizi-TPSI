package Thread.Aereoporto;

public class Volo extends Thread{

    private static final int MAX_ITERATION = 2;

    private Aereoporto aereoporto;
    private TipoVolo type;

    public Volo(String nome, Aereoporto aereoporto, TipoVolo type) {
        setName(nome);
        this.aereoporto = aereoporto;
        this.type = type;
    }

    @Override
    public void run() {

        for (int i = 0; i < MAX_ITERATION; i++){

            try{
                sleep(2000);

                if (type == TipoVolo.NAZIONALE){
                    aereoporto.acquisisciGateNazionale(this);
                }

                sleep(4500);


            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }


        }
    }
}
