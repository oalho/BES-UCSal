public class Paciente extends Pessoa {
    private String condicao;
    private Integer id;

    public Paciente(){
        super();
    }

    public Paciente(String condicao, Integer id){
        this.condicao = condicao;
        this.id = id;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
