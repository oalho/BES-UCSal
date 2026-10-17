package Notas;
public class Notas{
    private String nome;
    private Integer n1, n2, n3;

    public Notas(String nome, Integer n1, Integer n2, Integer n3){
        this.nome = nome;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public float notaFinal(){
        return (n1 + n2 + n3) / 3;
    }

    public float minimo(){
        return 60 - notaFinal();
    }
}