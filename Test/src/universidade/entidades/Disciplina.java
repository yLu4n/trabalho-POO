package universidade.entidades;

public class Disciplina {
    private static int idCounter = 1;
    private final int id;
    private String sigla;
    private String descricao;
    private boolean isActive;

    public Disciplina(String sigla, String descricao, boolean isActive) {
        this.id = idCounter++;
        this.sigla = sigla;
        this.descricao = descricao;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    
    public String toString() {
    	return "";
    }
}