public class Medicamento{
    private String nome;
    private Integer dosagemMg;
    private String bula;
    private Integer id;

    public Medicamento (String nome, Integer dosagemMg, String bula, Integer id){
        this.nome = nome;
        this.dosagemMg = dosagemMg;
        this.bula = bula;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDosagemMg() {
        return dosagemMg;
    }

    public void setDosagemMg(Integer dosagemMg) {
        this.dosagemMg = dosagemMg;
    }

    public String getBula() {
        return bula;
    }

    public void setBula(String bula) {
        this.bula = bula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
