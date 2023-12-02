package a;

public class Aluno {
	private int id;
	private String matricula;
	private String nome;
	private boolean ativo;
	
	public Aluno(int id, String matricula, String nome, boolean ativo) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.ativo = ativo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", ativo=" + ativo + "]";
	}
}
