package Contribuinte;

public class ContribuinteFisico extends Contribuinte{
    private String nome;
    private Double rendaAtual;
    private Double gastosSaude;

    public ContribuinteFisico(){
        super();
    }

    public ContribuinteFisico(String nome, Double rendaAtual, Double gastosSaude){
        this.nome = nome;
        this.rendaAtual = rendaAtual;
        this.gastosSaude = gastosSaude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAtual() {
        return rendaAtual;
    }

    public void setRendaAtual(Double rendaAtual) {
        this.rendaAtual = rendaAtual;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    public Double imposto(){
        if (rendaAtual < 20000.0){
            return (rendaAtual * 0.15) - (gastosSaude * 0.5);
        } else if (rendaAtual > 20000.0){
            return (rendaAtual* 0.25) - (gastosSaude * 0.5);
        }
    }
}
