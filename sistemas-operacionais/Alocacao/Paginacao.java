import java.util.*;

public class Paginacao {

    // Configurações do Sistema (Exemplo: Páginas de 4KB)
    private static final int TAMANHO_PAGINA = 4096; 
    private final int totalQuadros;
    private final String[] memoriaFisica; // Representa os quadros físicos
    private final Queue<Integer> filaFIFO; // Controla a ordem de entrada para substituição

    // Tabela de Páginas: ID do Processo -> (Número da Página -> Número do Quadro)
    private final Map<String, Map<Integer, Integer>> tabelaPaginasGlobal;

    // CORRIGIDO: Nome do construtor alterado para Paginacao
    public Paginacao(int tamanhoMemoriaFisica) {
        this.totalQuadros = tamanhoMemoriaFisica / TAMANHO_PAGINA;
        this.memoriaFisica = new String[totalQuadros];
        this.filaFIFO = new LinkedList<>();
        this.tabelaPaginasGlobal = new HashMap<>();
        
        // Inicializa a memória física como vazia
        Arrays.fill(memoriaFisica, "LIVRE");
    }

    // Aloca memória para um novo processo
    public void alocarProcesso(String idProcesso, int tamanhoBytes) {
        int paginasNecessarias = (int) Math.ceil((double) tamanhoBytes / TAMANHO_PAGINA);
        System.out.println("\n--- Alocando " + idProcesso + " (" + tamanhoBytes + " bytes = " + paginasNecessarias + " páginas) ---");

        Map<Integer, Integer> tabelaProcesso = new HashMap<>();

        for (int pagina = 0; pagina < paginasNecessarias; pagina++) {
            int quadroAlocado = encontrarQuadroLivre();

            // Se não houver quadro livre, aplica substituição FIFO
            if (quadroAlocado == -1) {
                quadroAlocado = substituirPaginaFIFO();
            }

            // Aloca o quadro
            memoriaFisica[quadroAlocado] = idProcesso + " [Pág " + pagina + "]";
            filaFIFO.add(quadroAlocado);
            tabelaProcesso.put(pagina, quadroAlocado);
            
            System.out.println("Página " + pagina + " mapeada para o Quadro " + quadroAlocado);
        }

        tabelaPaginasGlobal.put(idProcesso, tabelaProcesso);
    }

    // Traduz um endereço lógico do processo para o endereço físico real
    public void traduzirEndereco(String idProcesso, int enderecoLogico) {
        System.out.println("\n--- Traduzindo Endereço para " + idProcesso + " no local: " + enderecoLogico + " ---");
        
        Map<Integer, Integer> tabelaProcesso = tabelaPaginasGlobal.get(idProcesso);
        if (tabelaProcesso == null) {
            System.out.println("Erro: Processo não encontrado.");
            return;
        }

        int numeroPagina = enderecoLogico / TAMANHO_PAGINA;
        // CORRIGIDO: Removido o "(offset)" que quebrava a sintaxe
        int deslocamento = enderecoLogico % TAMANHO_PAGINA;

        Integer numeroQuadro = tabelaProcesso.get(numeroPagina);

        if (numeroQuadro == null) {
            System.out.println("Erro: Page Fault! A página " + numeroPagina + " não está na memória física.");
            return;
        }

        int enderecoFisico = (numeroQuadro * TAMANHO_PAGINA) + deslocamento;
        System.out.println("Endereço Lógico: " + enderecoLogico + " -> Página: " + numeroPagina + ", Offset: " + deslocamento);
        System.out.println("Endereço Físico Real: " + enderecoFisico + " (Quadro: " + numeroQuadro + ", Offset: " + deslocamento + ")");
    }

    // Encontra o primeiro quadro vazio
    private int encontrarQuadroLivre() {
        for (int i = 0; i < totalQuadros; i++) {
            if (memoriaFisica[i].equals("LIVRE")) {
                return i;
            }
        }
        return -1;
    }

    // Algoritmo de Substituição FIFO
    private int substituirPaginaFIFO() {
        int quadroSubstituir = filaFIFO.poll();
        System.out.println("[Substituição] Memória cheia! Removendo conteúdo do Quadro " + quadroSubstituir);
        
        // Remove a referência antiga das tabelas de páginas
        removerReferenciaTabela(quadroSubstituir);
        
        return quadroSubstituir;
    }

    private void removerReferenciaTabela(int quadro) {
        for (Map<Integer, Integer> tabela : tabelaPaginasGlobal.values()) {
            tabela.values().removeIf(q -> q == quadro);
        }
    }

    // Exibe o estado atual da memória RAM simulada
    public void exibirEstadoMemoria() {
        System.out.println("\n====== ESTADO DA MEMÓRIA FÍSICA (RAM) ======");
        for (int i = 0; i < totalQuadros; i++) {
            System.out.printf("Quadro [%02d]: %s\n", i, memoriaFisica[i]);
        }
        System.out.println("============================================");
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        // CORRIGIDO: Instanciado com o nome correto da classe (Paginacao)
        Paginacao simulador = new Paginacao(32768);
        simulador.exibirEstadoMemoria();

        // 1. Aloca Processo A (Precisa de 3 páginas)
        simulador.alocarProcesso("Processo_A", 12000);
        simulador.exibirEstadoMemoria();

        // 2. Aloca Processo B (Precisa de 4 páginas)
        simulador.alocarProcesso("Processo_B", 16000);
        simulador.exibirEstadoMemoria();

        // 3. Tradução de endereço bem-sucedida
        simulador.traduzirEndereco("Processo_A", 5000);

        // 4. Força a falta de memória e a substituição FIFO
        simulador.alocarProcesso("Processo_C", 12000);
        simulador.exibirEstadoMemoria();
    }
}
