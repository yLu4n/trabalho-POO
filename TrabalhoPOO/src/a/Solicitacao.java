package a;

import java.util.Date;
import java.util.Set;

public class Solicitacao {
	private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private Date data;
    private int tempUtilizacao;

	public Solicitacao(Laboratorio laboratorio, Professor professor, Disciplina disciplina, Set<Aluno> alunos, 
			   Date data, int tempoUtilizacao) {
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public Date getData() {
		return data;
	}

	public int getTempUtilizacao() {
		return tempUtilizacao;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setTempUtilizacao(int tempUtilizacao) {
		this.tempUtilizacao = tempUtilizacao;
	}
	
}
