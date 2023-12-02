package universidade.entidades;

public enum Departamento {
    ENG_SOFTWARE(1, "ES", "Engenharia de Software"),
    COMP_ALTO_DESEMPENHO(2, "CAD", "Computação de Alto Desempenho"),
    INFRAESTRUTURA(3, "Infra", "Infraestrutura Computacional");

	private final int id;
    private final String sigla;
    private final String descricao;

    Departamento(int id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public int getId() {
		return id;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
    	return "";
    }
}

