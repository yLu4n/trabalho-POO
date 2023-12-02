package universidade.entidades;

public class Professor {
    private static int idCounter = 1;
    private final int id;
    private String nome;
    private boolean isActive;
    private Departamento departamento;

    public Professor(String nome, boolean isActive, Departamento departamento) {
        this.id = idCounter++;
        this.nome = nome;
        this.isActive = isActive;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public String toString() {
    	return "";
    }
}