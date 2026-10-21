public class ProdutoImportado extends Produto {
    private String nome;
    private Double preco;
    private Double taxa;

    public ProdutoImportado(){
        super();
    }

    public ProdutoImportado (String nome, Double preco, Double taxa){
        super(nome, preco);
        this.taxa = taxa;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double precoTotal(){
        return preco * taxa;
    }

    @Override
    public String toString() {
        return "ProdutoImportado [nome=" + nome + ", preco=" + preco + ", taxa=" + taxa + "]";
    }
 
}