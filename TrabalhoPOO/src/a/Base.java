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
    public List<Laboratorio> getLaboratorios() {
        List<Laboratorio> laboratorios = new ArrayList<>();

        // Criando laboratórios conforme a história
        for (int i = 1; i <= QTDE_LABORATORIOS; i++) {
            int capacidade;
            boolean ativo = true;

            if (i == 1 || i == 10) {
                capacidade = 30;
            } else if (i >= 2 && i <= 7) {
                capacidade = 20;
            } else {
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

        // Criando departamentos conforme a história
        for (int i = 1; i <= QTDE_DEPARTAMENTOS; i++) {
            Departamento dept = new Departamento(i, "Dept" + i, "Descrição do Dept" + i);
            departamentos.add(dept);
        }

        return departamentos;
    }

    @Override
    public List<Professor> getProfessores() {
        List<Professor> professores = new ArrayList<>();

        // Criando professores conforme a história
        for (int i = 1; i <= QTDE_PROFESSORES; i++) {
            int deptId;
            if (i <= 10) {
                deptId = 1;  // Engenharia de Software
            } else if (i <= 14) {
                deptId = 2;  // Computação de Alto Desempenho
            } else {
                deptId = 3;  // Infraestrutura Computacional
            }

            Departamento departamento = getDepartamentoById(deptId);

            Professor prof = new Professor(i, "Professor" + i, true, departamento);
            professores.add(prof);
        }

        return professores;
    }

    @Override
    public List<Disciplina> getDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();

        // Criando disciplinas conforme a história
        String[] siglas = {"BESO05", "BESO06", "BESO08", "BES011", "BES012", "BES020", "BES026", "BES038", "BES049", "BES048"};
        String[] descricoes = {"Lógica de Programação e Algoritmos", "Estrutura de Dados", "Programação Orientada a Objetos",
                "Bancos de Dados", "Engenharia de Requisitos", "Programação para Dispositivos Móveis",
                "Sistemas Distribuídos", "Inteligência Artificial", "Programação Web", "Programação Front End"};

        for (int i = 1; i <= QTDE_DISCIPLINAS; i++) {
            Disciplina disciplina = new Disciplina(i, siglas[i - 1], descricoes[i - 1], true);
            disciplinas.add(disciplina);
        }

        return disciplinas;
    }

    @Override
    public List<Aluno> getAlunos(int qtde, int inicio) {
        List<Aluno> alunos = new ArrayList<>();

        // Criando alunos conforme a história
        for (int i = inicio; i < inicio + qtde; i++) {
            Aluno aluno = new Aluno(i, "2023" + i, "Aluno" + i, true);
            alunos.add(aluno);
        }

        return alunos;
    }

    // Método auxiliar para obter um departamento pelo ID
    private Departamento getDepartamentoById(int id) {
        // Supondo que a lista de departamentos já foi preenchida
        return getDepartamentos().stream().filter(dept -> dept.getId() == id).findFirst().orElse(null);
    }
}
