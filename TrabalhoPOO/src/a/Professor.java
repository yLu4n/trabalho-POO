package a;

public class Professor {
	private int id;
	private String nome;
	private boolean ativo;
	private Departamento departamento;
	
	public Professor(int id, String nome, boolean ativo, Departamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.departamento = departamento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", departamento=" + departamento + "]";
	}
}