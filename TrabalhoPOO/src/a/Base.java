package a;

import java.util.List;

public interface Base {
	List<Laboratorio> getLaboratorios();
	List<Departamento> getDepartamento();
	List<Professor> getProfessor();
	List<Disciplina> getDisciplina();
	List<Aluno> getAlunos(int qtd, int inicio);
}
