package DTO;

public class Agendamento {

    protected String dataHora_chegada;
    protected String dataHora_retirada;
    protected String trabalhador;
    protected String pet;
    protected String cliente;
    protected String servico;

    public String getDataHora_chegada() {
        return dataHora_chegada;
    }

    public void setDataHora_chegada(String dataHora_chegada) {
        this.dataHora_chegada = dataHora_chegada;
    }

    public String getDataHora_retirada() {
        return dataHora_retirada;
    }

    public void setDataHora_retirada(String dataHora_retirada) {
        this.dataHora_retirada = dataHora_retirada;
    }

    public String getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(String trabalhador) {
        this.trabalhador = trabalhador;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
