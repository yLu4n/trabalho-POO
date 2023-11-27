package a;

public class Disciplina {
	private int id;
	private String sigla;
	private String descricao;
	private boolean ativa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + ", ativa=" + ativa + "]";
	}
}