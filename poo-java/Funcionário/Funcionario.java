package Funcionário;

public class Funcionario{

    private String nome;
    private double salario, imposto, per;

    public String getNome() {
        return nome;
    }
    public double getPer() {
        return per;
    }
    public void setPer(double per) {
        this.per = per;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getImposto() {
        return imposto;
    }
    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    
    public double salarioLiquido(){
        return (salario * 100) / imposto;
    }

    public double aumento(){
        return (salario * per) / 100;
    }
}