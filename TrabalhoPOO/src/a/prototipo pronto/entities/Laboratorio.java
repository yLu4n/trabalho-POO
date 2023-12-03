package entities;

public class Laboratorio {                                // Powered by: BRUNO CASÉ and ZAIRA DUTRA
    //Last att: 12:58 pm  (21/11/2023)
    private int id;
    private String descricao;
    private int capacidade;
    private boolean status;                             // ATRIBUTOS


    public Laboratorio(int id, String descricao, int capacidade, boolean status) {   // COSNTRUTOR
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.status = status;
    }

    public int getCapacidade() {              // METODOS ACESSORES E MODIFICADORES
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String toString() {                         // TO STRING
        return "Laboratorio[id=" + id + ", descricao=" + descricao + ", capacidade=" + capacidade + ", status=" + status + "]";
    }
}



