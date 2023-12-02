package universidade.reservas;

import java.util.List;

import universidade.entidades.Aluno;
import universidade.entidades.Departamento;
import universidade.entidades.Disciplina;
import universidade.entidades.Laboratorio;
import universidade.entidades.Professor;

public interface IBase {
	List<Laboratorio> getLaboratorios();
	List<Departamento> getDepartamentos();
	List<Professor> getProfessores();
	List<Disciplina> getDisciplinas();
	List<Aluno> getAlunos(int quantidade, int inicio);
}
