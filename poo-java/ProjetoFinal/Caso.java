public class Caso {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private Medicamento medicamento;    

    public Caso(Integer id, Paciente paciente, Medico medico, Medicamento medicamento){
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.medicamento = medicamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    
}
