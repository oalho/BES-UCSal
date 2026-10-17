package Retângulo;
public class Retangulo{
    private double altura, largura;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double calculoArea(){
        return altura * largura;
    }

    public double calculoPerimetro(){
        return (altura * 2) + (largura * 2);
    }

}