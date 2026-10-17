package SistemadeFuncionarios;
import java.util.Scanner;
public class Execucao {
    public static void main(String[]args){
        Scanner scan = new Scanner (System.in);

        System.out.println("Quadro de Funcionarios");
        System.out.println("quantos funcionarios deseja manipular?");
        int trabalhadores = scan.nextInt();

       
        for (int i = 0; i < trabalhadores; i ++){
            System.out.println("nome do funcionario");
            String nome = scan.next();
            System.out.println("matricula");
            Integer matricula = scan.nextInt();
            System.out.println("salario");
            Float salario = scan.nextFloat();
            Funcionario funcionario = new Funcionario(nome, matricula, salario);
            
            Departamento departamento = new Departamento(nome, matricula, funcionario);
            departamento.addFuncionario(funcionario);
            System.out.println("finalizado. Resumo:s");
            System.out.println(departamento);
        }

        
    scan.close();
    }
}
