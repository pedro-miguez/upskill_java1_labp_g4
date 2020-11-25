import com.sun.xml.internal.bind.v2.model.core.ID;

public abstract class Atleta {

    private String nome;
    private int numIdCivil;
    private int idade;
    private double freqCardRepouso;
    private double premioAcumulado;
    private Genero genero;
    private Atividade atividade;
    private ObjectivoTreino objectivoTreino;

    private static final String NOME_OMISSAO = "Sem nome";
    private static final int NUMID_OMISSAO = 0;
    private static final int IDADE_OMISSAO = 0;
    private static final double FCR_OMISSAO = 0;
    private static final double PREMIO_OMISSAO = 0;
    private static final Genero GENERO_OMISSAO = Genero.MASCULINO;
    private static final Atividade ATIVIDADE_OMISSAO = Atividade.CAMINHADA;
    private static final ObjectivoTreino OBJECTIVO_TREINO_OMISSAO = ObjectivoTreino.QUEIMA_GORDURA;
    
    private static double QUEIMA_IT = 0.6;
    private static double CARDIO_IT = 0.75;

    private static final double IRS = 0.1;

    public Atleta(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado, Genero genero, Atividade atividade, ObjectivoTreino objectivo) {
        this.nome = nome;
        this.numIdCivil = numIdCivil;
        this.idade = idade;
        this.freqCardRepouso = freqCardRepouso;
        this.premioAcumulado = premioAcumulado;
        this.setGenero(genero);
        this.setAtividade(atividade);
        this.setObjectivoTreino(objectivo);
    }

    public Atleta(){
        this.setNome(NOME_OMISSAO);
        this.setNumIdCivil(NUMID_OMISSAO);
        this.setIdade(IDADE_OMISSAO);
        this.setFreqCardRepouso(FCR_OMISSAO);
        this.setPremioAcumulado(PREMIO_OMISSAO);
        this.setGenero(GENERO_OMISSAO);
        this.setAtividade(ATIVIDADE_OMISSAO);
        this.setObjectivoTreino(OBJECTIVO_TREINO_OMISSAO);
        
    }

    public static double getIRS() {
        return IRS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumIdCivil() {
        return numIdCivil;
    }

    public void setNumIdCivil(int numIdCivil) {
        this.numIdCivil = numIdCivil;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getFreqCardRepouso() {
        return freqCardRepouso;
    }

    public void setFreqCardRepouso(double freqCardRepouso) {
        this.freqCardRepouso = freqCardRepouso;
    }

    public double getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(double premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public void addPremio(double valor){
        setPremioAcumulado(getPremioAcumulado() + valor);
    }

    public String getGenero() {
        return genero.toString();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * @return the atividade
     */
    public String getAtividade() {
        return atividade.toString();
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }


    /**
     * @return the objectivoTreino
     */
    public String getObjectivoTreino() {
        return objectivoTreino.toString();
    }

    /**
     * @param objectivoTreino the objectivoTreino to set
     */
    public void setObjectivoTreino(ObjectivoTreino objectivoTreino) {
        this.objectivoTreino = objectivoTreino;
    }

    public double calcularPagamento() {
        return determinarParcela1() + determinarParcela2();
    }

    public abstract double determinarParcela1();

    public abstract double determinarParcela2();

    public double freqCardTrabalho(){
        return getFreqCardRepouso() + (determinarIT() * (freqCardMax() - getFreqCardRepouso()));
    }

    public double freqCardMax(){
        if (this.atividade == Atividade.CAMINHADA || this.atividade == Atividade.CORRIDA){
            return 208.75 - (0.73 * getIdade());
        }
        else {
            if (this.atividade == Atividade.NATACAO){
                return 204 - (1.7 * getIdade());
            }
            else {
                if (this.atividade == Atividade.CICLISMO && this.genero == Genero.FEMININO){
                    return 189 - (0.56 * getIdade());
                    }
                else {
                    return 202 - (0.72 * getIdade());
                }
            }
        }
    }

    public double determinarIT(){
        if (this.objectivoTreino == ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA){
            return CARDIO_IT;
        }
        else{
            return QUEIMA_IT;
        }
    }

}
