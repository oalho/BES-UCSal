package Dolar;

public class Dolar{
    public double r, d;

    public Dolar(Double d){
        this.d = d;
    }

    public double convert(){
        return d * 5;
    }
}