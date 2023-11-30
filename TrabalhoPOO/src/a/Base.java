package a;
import java.util.List;
import java.util.ArrayList;
public abstract class Base implements IBase{
	
	private final Integer QTDE_DEPARTAMENTOS = 3;
	private final Integer QTDE_PROFESSORES = 15;
	private final Integer QTDE_LABORATORIOS = 12;
	private final Integer QTDE_DISCIPLINAS = 10;
	private final Integer QTDE_ALUNOS = 20;
	
	
	@Override
	public List<Laboratorio> getLaboratorios(){
		List<Laboratorio> laboratorios = new ArrayList<>();
		for (int i = 1; i <= QTDE_LABORATORIOS; i++) {
			int capacidade;
			boolean ativo = true;
			
			if (i == 1 || i == 10) {
				capacidade = 30;
			}else if (i >= 2 && i <= 7) {
				capacidade = 20;
			}else {
				capacidade = 15;
			}
			
			Laboratorio lab = new Laboratorio(i, capacidade, ativo);
			laboratorios.add(lab);
		}
		return laboratorios;
	}
	
	@Override
	public List<Departamento> getDepartamentos() {
		List<Departamento> departamentos = new ArrayList<>();
		
		return departamentos;
	}
	
	@Override
	public List<Professor> getProfessores() {
		List<Professor> professores = new ArrayList<>();
		
		return professores;
	}
	
	@Override
	public List<Disciplina> getDisciplinas() {
		List<Disciplina> disciplinas = new ArrayList<>();
		
		return disciplinas;
	}
	
	@Override
	public List<Aluno> getAlunos(int qtde, int inicio) {
		List<Aluno> alunos = new ArrayList<>();
		
		return alunos;
	}
	
	
}
