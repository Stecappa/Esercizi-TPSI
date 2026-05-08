package Aereoporto;

public class Main {

    private static final int GATE_NAZIONALI = 3;
    private static final int GATE_INTERNAZIONALI = 2;

    public static void main(String[] args) {

        Aereoporto aereoporto = new Aereoporto(GATE_NAZIONALI, GATE_INTERNAZIONALI);

        Volo[] voli = {
                new Volo("nex-01", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-02", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-03", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-04", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-05", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-001", aereoporto, TipoVolo.INTERNAZIONALE),
                new Volo("nex-002", aereoporto, TipoVolo.INTERNAZIONALE),
        };

    }
}
