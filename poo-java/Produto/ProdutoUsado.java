import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto{
    private String nome;
    private Double preco;
    private LocalDate data;
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ProdutoUsado(){
        super();
    }

    public ProdutoUsado(String nome, Double preco, LocalDate data){
        super(nome, preco);
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ProdutoUsado [nome=" + nome + ", preco=" + preco + ", data=" + data + ", formatador=" + formatador
                + "]";
    }

}
