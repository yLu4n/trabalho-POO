package universidade.entidades;

public class Aluno {
    private static int idCounter = 1;
    private final int id;
    private int matricula;
    private String nome;
    private boolean isActive;

    public Aluno(int matricula, String nome, boolean isActive) {
        this.id = idCounter++;
        this.matricula = matricula;
        this.nome = nome;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
    
    public String toString() {
    	return "";
    }
}
