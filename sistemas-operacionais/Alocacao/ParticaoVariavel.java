import java.util.ArrayList;
import java.util.List;

public class ParticaoVariavel {

    // Classe interna para representar uma partição de memória
    private static class Bloco {
        int idProcesso; // -1 se o bloco estiver livre
        int enderecoInicio;
        int tamanho;

        Bloco(int idProcesso, int enderecoInicio, int tamanho) {
            this.idProcesso = idProcesso;
            this.enderecoInicio = enderecoInicio;
            this.tamanho = tamanho;
        }

        boolean estaLivre() {
            return idProcesso == -1;
        }

        @Override
        public String toString() {
            String status = estaLivre() ? "LIVRE" : "Processo P" + idProcesso;
            return String.format("[%d - %d] | Tamanho: %d | Status: %s", 
                    enderecoInicio, enderecoInicio + tamanho - 1, tamanho, status);
        }
    }

    private final List<Bloco> memoria;
    private final int tamanhoTotal;

    public ParticaoVariavel(int tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
        this.memoria = new ArrayList<>();
        // Inicializa a memória com um único grande bloco livre
        this.memoria.add(new Bloco(-1, 0, tamanhoTotal));
    }

    /**
     * Aloca um processo na memória usando a estratégia First-Fit
     */
    public boolean alocar(int idProcesso, int tamanhoRequisitado) {
        for (int i = 0; i < memoria.size(); i++) {
            Bloco blocoAtual = memoria.get(i);

            // Encontra o primeiro bloco livre com tamanho suficiente
            if (blocoAtual.estaLivre() && blocoAtual.tamanho >= tamanhoRequisitado) {
                int sobra = blocoAtual.tamanho - tamanhoRequisitado;

                // Atualiza o bloco atual para o processo
                blocoAtual.idProcesso = idProcesso;
                blocoAtual.tamanho = tamanhoRequisitado;

                // Se sobrou espaço, cria uma nova partição livre logo após
                if (sobra > 0) {
                    Bloco novoBlocoLivre = new Bloco(
                        -1, 
                        blocoAtual.enderecoInicio + tamanhoRequisitado, 
                        sobra
                    );
                    memoria.add(i + 1, novoBlocoLivre);
                }
                
                System.out.println("✔ Processo P" + idProcesso + " alocado com sucesso (" + tamanhoRequisitado + "MB).");
                return true;
            }
        }
        System.out.println("❌ Falha ao alocar P" + idProcesso + ": Memória insuficiente ou muito fragmentada para " + tamanhoRequisitado + "MB.");
        return false;
    }

    /**
     * Libera a memória ocupada por um processo e funde blocos livres adjacentes
     */
    public boolean desalocar(int idProcesso) {
        boolean encontrado = false;

        for (int i = 0; i < memoria.size(); i++) {
            Bloco bloco = memoria.get(i);
            if (bloco.idProcesso == idProcesso) {
                bloco.idProcesso = -1; // Libera o bloco
                System.out.println("♻ Processo P" + idProcesso + " removido da memória.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("⚠ Processo P" + idProcesso + " não encontrado na memória.");
            return false;
        }

        // Executa a fusão (coalescência) de blocos livres vizinhos
        fundirBlocosLivres();
        return true;
    }

    /**
     * Varre a memória unindo blocos livres que estão lado a lado
     */
    private void fundirBlocosLivres() {
        for (int i = 0; i < memoria.size() - 1; i++) {
            Bloco atual = memoria.get(i);
            Bloco proximo = memoria.get(i + 1);

            if (atual.estaLivre() && proximo.estaLivre()) {
                atual.tamanho += proximo.tamanho; // Absorve o tamanho do próximo
                memoria.remove(i + 1);            // Remove o próximo da lista
                i--; // Reavalia a posição atual com o novo vizinho
            }
        }
    }

    /**
     * Exibe o estado atual do mapa de memória
     */
    public void exibirMapaMemoria() {
        System.out.println("\n===== MAPA DE MEMÓRIA =====");
        for (Bloco bloco : memoria) {
            System.out.println(bloco);
        }
        System.out.println("===========================\n");
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        // Cria uma memória total de 1000MB (ou 1000 unidades)
        ParticaoVariavel gm = new ParticaoVariavel(1000);
        gm.exibirMapaMemoria();

        // Cenário de testes
        gm.alocar(1, 200);
        gm.alocar(2, 400);
        gm.alocar(3, 150);
        gm.exibirMapaMemoria();

        // Desaloca o processo 2 (gera um buraco no meio)
        gm.desalocar(2);
        gm.exibirMapaMemoria();

        // Tenta alocar um processo que cabe no buraco do antigo P2
        gm.alocar(4, 300);
        gm.exibirMapaMemoria();

        // Desaloca o processo 3 para testar a fusão de blocos vazios no final
        gm.desalocar(3);
        gm.exibirMapaMemoria();
    }
}
