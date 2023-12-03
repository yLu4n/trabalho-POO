package universidade.entidades;


public class Aluno {

    
    private long id;
    private String nome;
    private String matricula;
    private boolean status;

    public Aluno(long id, String nome, String matricula, boolean status) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.status = status;
    }

    
    public boolean getStatus() {
        return status;
    }

   
    public void setStatus(boolean status) {
        this.status = status;
    }

   
    public long getId() {
        return id;
    }

   
    public void setId(long id) {
        this.id = id;
    }

    
    public String getMatricula() {
        return matricula;
    }

    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Override
    public String toString() {
        return "Aluno{" +
                " nome='" + nome + '\'' +
                '}';
    }
}
