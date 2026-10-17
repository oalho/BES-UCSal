package Banco;

public class Conta {
    private int n;
    public String titular;
    private float saldo = 0;
    
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public float getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void saque(float valor){
        this.saldo -= (valor + 5);
    }

    public void deposito(float valor){
        this.saldo += valor;
    }
}
