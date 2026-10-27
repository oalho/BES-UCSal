package Contribuinte;

public class Contribuinte {
    private String nome;
    private Double rendimento;

    public Contribuinte(String nome, Double rendimento){
        this.nome = nome;
        this.rendimento = rendimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendimento() {
        return rendimento;
    }

    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }

}
