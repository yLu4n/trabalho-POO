package a;
import java.util.List;
public class Solicitacao {
	private Laboratorio laboratorio;
	private Professor professor;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	private String data;
	private int tempoUtilizacao;
	
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getTempoUtilizacao() {
		return tempoUtilizacao;
	}
	public void setTempoUtilizacao(int tempoUtilizacao) {
		this.tempoUtilizacao = tempoUtilizacao;
	}
	@Override
	public String toString() {
		return "Solicitacao [laboratorio=" + laboratorio + ", professor=" + professor + ", disciplina=" + disciplina
				+ ", alunos=" + alunos + ", data=" + data + ", tempoUtilizacao=" + tempoUtilizacao + "]";
	}
}