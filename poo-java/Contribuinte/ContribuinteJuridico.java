package Contribuinte;

public class ContribuinteJuridico extends Contribuinte{
    private String nome;
    private Double rendaAtual;
    private Integer funcionarios;

    public ContribuinteJuridico(){
        super();
    }
    
    public ContribuinteJuridico(String nome, Double rendaAtual, Integer funcionarios){
        this.nome = nome;
        this.rendaAtual = rendaAtual;
        this.funcionarios = funcionarios;
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

    public Integer getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Integer funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Double imposto(){
        if (funcionarios > 10){
            return rendaAtual * 0.14;
        } else {
            return rendaAtual * 0.16;
        }
    }
}
