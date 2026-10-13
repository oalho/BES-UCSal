package SistemadeFuncionarios;
import java.util.List;
import java.util.ArrayList;

public class Departamento {
    private String nome;
    private Integer codigo;
    private Funcionario funcionario;
    private List <Funcionario> funcionarios = new ArrayList <>();

    public Departamento (String nome, Integer codigo, Funcionario funcionario){
        this.nome = nome;
        this.codigo = codigo;
        this.funcionario = funcionario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
    
    
}