package Funcionário;
import java.util.Scanner;

public class ExecutarFuncionario{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Funcionario f = new Funcionario();
        
        System.out.println("Prancheta de Salários");
        System.out.println("informe o nome do funcionario");
        f.setNome(scan.nextLine());
        System.out.println("Informe o salário bruto");
        f.setSalario(scan.nextDouble());
        System.out.println("informe o imposto agregado ao salário bruto");
        f.setImposto(scan.nextDouble());

        System.out.println("empregado " + f.getNome() + ", " + f.salarioLiquido());

        System.out.println("qual o percentual de aumento do salário?");
        f.setPer(scan.nextDouble());

        System.out.println("Dados atualizados: " + f.getNome() + ", " + f.aumento());

    scan.close();
    }
}