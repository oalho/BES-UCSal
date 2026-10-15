package JogoDaVelha;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        boolean vez = true, vitoria = false, fim = false, jogadavalida = false;
        String nome1, nome2, jogada;
        char resposta, simbolo1, simbolo2;

        System.out.print("começaremos o jogo da velha");

        System.out.println("nome do jogador 1:");
        nome1 = scan.next();
        System.out.println(nome1 + " vc vai querer (X) ou (O) para te representar?");
        resposta = scan.next().charAt(0);

        if(resposta == 'X' || resposta == 'x'){
            if (!vez){
                jogada = "X";
            }
        } else if(resposta == 'O' || resposta == 'o'){
            if (vez){
                jogada = "O";
            }
        } else {
            System.out.println("por favor, escolha 'X' ou 'O'");
        }

        System.out.println("nome do jogador 2:");
        nome2 = scan.next();

        System.out.println("A partida começa!");

        for(int i = 0; i < 3; i++){
                System.out.print("|");
            for(int j = 0; j < 3; j++){
                System.out.println("______________");
            }
        }

        do{
            
            if(vez){
                System.out.println(nome1 + " é a sua vez");
            } else if (!vez){
                System.out.println(nome2 + " é a sua vez");
            }

            

            if(vez){
                vez = false;
            } else if (!vez){
                vez = true;
            }

        }while(!vitoria);

    scan.close();
    }
}