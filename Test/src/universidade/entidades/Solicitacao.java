package universidade.entidades;

import java.util.Date;
import java.util.List;

public class Solicitacao {
    private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private Date data;
    private int tempoMinutos;

    public Solicitacao(Laboratorio laboratorio, Professor professor, Disciplina disciplina,
                       List<Aluno> alunos, Date data, int tempoMinutos) {
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.data = data;
        this.tempoMinutos = tempoMinutos;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public Date getData() {
		return data;
	}

	public int getTempoMinutos() {
		return tempoMinutos;
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

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setTempoMinutos(int tempoMinutos) {
		this.tempoMinutos = tempoMinutos;
	}
	
    public String toString() {
        return "Solicitacao [laboratorio=" + laboratorio + ", professor=" + professor + ", disciplina=" + disciplina
                + ", alunos=" + alunos + ", data=" + data + ", tempoMinutos=" + tempoMinutos + "]";
    }
}

