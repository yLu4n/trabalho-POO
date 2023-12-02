package a;

public class Disciplina {
	private int id;
	private String sigla;
	private String descricao;
	private boolean ativa;
	
	public Disciplina(int id, String sigla, String descricao, boolean ativa) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.descricao = descricao;
		this.ativa = ativa;
	}
	
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