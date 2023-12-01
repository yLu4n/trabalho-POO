package a;
import java.util.List;
public class Solicitacao {
	private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private Date data;
    private int tempoUtilizacao;

	public Solicitacao(Laboratorio laboratorio, Professor professor, Disciplina disciplina, Set<Aluno> alunos, 
			   Date data, int tempoUtilizacao) {
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
	}
}
