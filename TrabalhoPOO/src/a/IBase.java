package a;
import java.util.List;
public interface IBase {
	
	List<Laboratorio> getLaboratorios();
	List<Departamento> getDepartamentos();
	List<Professor> getProfessores();
	List<Disciplina> getDisciplinas();
	List<Aluno> getAlunos(int qtde, int inicio);
}
