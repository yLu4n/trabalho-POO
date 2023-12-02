package universidade.entidades;

public class Laboratorio {
    private static int idCounter = 1;
    private final int id;
    private int capacidade;
    private boolean isAtivo;
    private String descricao;

    public Laboratorio(int capacidade, boolean isAtivo) {
        this.id = idCounter++;
        this.capacidade = capacidade;
        this.isAtivo = isAtivo;
    }

	public static int getIdCounter() {
		return idCounter;
	}

	public int getId() {
		return id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static void setIdCounter(int idCounter) {
		Laboratorio.idCounter = idCounter;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
    	return "";
    }
}