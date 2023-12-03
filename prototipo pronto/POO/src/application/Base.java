package application;

import auxiliar.Reserva;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Base implements IBase {

	private final int QTDE_PROFESSORES = 15;
    private final int QTDE_DEPARTAMENTOS = 3;
    private final int QTDE_LABORATORIOS = 15;

    private List<Laboratorio> laboratorios = new ArrayList<>();
    private List<Departamento> departamentos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public Base() {
        // Inicialização da base de dados
        inicializarLaboratorios();
        inicializarDepartamentos();
        inicializarDisciplinas();
        inicializarProfessores();
        inicializarAlunos();
    }

    private void inicializarLaboratorios() {
        for (int i = 1; i <= QTDE_LABORATORIOS; i++) {
            int capacidade = (i == 1 || i == 10) ? 30 : (i >= 2 && i <= 7) ? 20 : 15;
            laboratorios.add(new Laboratorio(i, "LAMI" + i, capacidade, true));
        }
    }

    private void inicializarDepartamentos() {
        departamentos.add(new Departamento(1, "ES", "Engenharia de Software", true));
        departamentos.add(new Departamento(2, "CAD", "Computação de Alto Desempenho", true));
        departamentos.add(new Departamento(3, "IC", "Infraestrutura Computacional", true));
    }

    private void inicializarDisciplinas() {
        disciplinas.add(new Disciplina("BES005", "LÓGICA DE PROGRAMAÇÃO E ALGORITMOS", 1, true));
        disciplinas.add(new Disciplina("BES006", "ESTRUTURA DE DADOS", 2, true));
        disciplinas.add(new Disciplina("BES008", "PROGRAMAÇÃO ORIENTADA A OBJETOS", 3, true));
        disciplinas.add(new Disciplina("BES011", "BANCOS DE DADOS", 4, true));
        disciplinas.add(new Disciplina("BES012", "ENGENHARIA DE REQUISITOS", 5, true));
        disciplinas.add(new Disciplina("BES020", "PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS", 6, true));
        disciplinas.add(new Disciplina("BES026", "SISTEMAS DISTRIBUÍDOS", 7, true));
        disciplinas.add(new Disciplina("BES038", "INTELIGÊNCIA ARTIFICIAL", 8, true));
        disciplinas.add(new Disciplina("BES049", "PROGRAMAÇÃO WEB", 9, true));
        disciplinas.add(new Disciplina("BES048", "PROGRAMAÇÃO FRONT END", 10, true));
        // Adicionar as demais disciplinas...
    }
 
    
    private void inicializarProfessores() {
        for (int i = 1; i <= QTDE_PROFESSORES; i++) {
            Departamento dep = (i >= 1 && i <= 10) ? departamentos.get(0) :
                    (i >= 11 && i <= 14) ? departamentos.get(1) :
                            departamentos.get(2);

            ArrayList<Disciplina> pdisciplinas = obterPdisciplinasParaProfessor(i);

            Professor prof = new Professor(true, i + 0, "Professor" + i, dep, pdisciplinas);
            professores.add(prof);
        }
    }
    
    private ArrayList<Disciplina> obterPdisciplinasParaProfessor(int i) {
        ArrayList<Disciplina> pdisciplinas = new ArrayList<>();
        if (i >= 1 && i <= 10) {
            if (disciplinas.size() > 0) pdisciplinas.add(disciplinas.get(0));
            if (disciplinas.size() > 5) pdisciplinas.add(disciplinas.get(5));
            if (disciplinas.size() > 3) pdisciplinas.add(disciplinas.get(3));
        } else if (i >= 11 && i <= 14) {
            if (disciplinas.size() > 2) pdisciplinas.add(disciplinas.get(2));
            if (disciplinas.size() > 4) pdisciplinas.add(disciplinas.get(4));
            if (disciplinas.size() > 1) pdisciplinas.add(disciplinas.get(1));
            if (disciplinas.size() > 8) pdisciplinas.add(disciplinas.get(8));
        } else {
            if (disciplinas.size() > 10) pdisciplinas.add(disciplinas.get(10));
            if (disciplinas.size() > 9) pdisciplinas.add(disciplinas.get(9));
            if (disciplinas.size() > 7) pdisciplinas.add(disciplinas.get(7));
        }
        
        return pdisciplinas;
    }

    private void inicializarAlunos() {
        alunos.addAll(getAlunos(100, 0));
    }

    @Override
    public List<Aluno> getAlunos(int qtde, int inicio) {
        List<Aluno> alunos = new ArrayList<>();
        for (int i = inicio; i < inicio + qtde; i++) {
            alunos.add(new Aluno(i + 1, "Aluno" + (i + 1), "202320" + i, true));
        }
        return alunos;
    }

    public List<Aluno> Alunos() {
        return getAlunos(100, 0);
    }

    public void BasePrint() {
        System.out.println("Disciplinas: " + disciplinas);
        System.out.println("Professores: " + professores);
        System.out.println("Departamentos: " + departamentos);
    }

	@Override
	public List<Laboratorio> getLaboratorios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> getDepartamentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> getProfessores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disciplina> getDisciplinas() {
		// TODO Auto-generated method stub
		return null;
	}
}
