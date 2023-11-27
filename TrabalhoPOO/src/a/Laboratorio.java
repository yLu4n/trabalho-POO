package a;

public class Laboratorio {
	private int id;
	private String nome;
	private String descricao;
	private int capacidade;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	@Override
	public String toString() {
		return "Laboratorio [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", capacidade=" + capacidade
				+ "]";
	}
}