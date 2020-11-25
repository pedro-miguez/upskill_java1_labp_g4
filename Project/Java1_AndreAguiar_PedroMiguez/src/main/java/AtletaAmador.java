public class AtletaAmador extends AtletaNaoProfissional{

    private int antiguidade;

    private static final int ANTIGUIDADE_OMISSAO = 0;

    public AtletaAmador(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado, Genero genero, Atividade atividade, int antiguidade) {
        super(nome, numIdCivil, idade, freqCardRepouso, premioAcumulado, genero, atividade, antiguidade );
    }

    public AtletaAmador(){
        super();
    }

    public double determinarParcela1() {
        return 0;
    }

    public double determinarParcela2() {
        return 0;
    }
}
