/**
 * A classe `Base` é responsável por fornecer informações fundamentais para o sistema de reserva de laboratórios da Ucsal,
 * incluindo dados sobre laboratórios, departamentos, professores, disciplinas e alunos.
 * Implementa a interface `IBase` para garantir a consistência na obtenção de informações.
 *
 * @author Guilherme Souza e Matheus Requiao
 * @version 1.0
 * @since 25/11/2023
 */
package application;

import auxiliar.Reserva;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Última atualização: 12:58 pm (21/11/2023)
public class Base implements IBase {

    private List<Laboratorio> laboratorios;
    private List<Departamento> departamentos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;

    private final int QTDE_PROFESSORES = 15;
    private final int QTDE_DEPARTAMENTOS = 3;
    private final int QTDE_LABORATORIOS = 15;

    /**
     * Construtor da classe `Base`. Inicializa as listas de laboratórios, departamentos, professores, disciplinas e alunos.
     */
    public Base() {
        laboratorios = new ArrayList<>();
        departamentos = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    /**
     * Obtém a lista de laboratórios, populando-a com dados fictícios se necessário.
     *
     * @return Lista de laboratórios.
     */
    public List<Laboratorio> getLaboratorios() {
        for (int i = 1; i <= QTDE_LABORATORIOS; i++) {
            int capacidade = (i == 1 || i == 10) ? 30 : (i >= 2 && i <= 7) ? 20 : 15;
            laboratorios.add(new Laboratorio(i, "LAMI" + i, capacidade, true));
        }
        return laboratorios;
    }

    /**
     * Obtém a lista de departamentos, adicionando departamentos fictícios.
     *
     * @return Lista de departamentos.
     */
    public List<Departamento> getDepartamentos() {
        departamentos.add(new Departamento(1, "ES", "Engenharia de Software", true));
        departamentos.add(new Departamento(2, "CAD", "Computação de Alto Desempenho", true));
        departamentos.add(new Departamento(3, "IC", "Infraestrutura Computacional", true));
        return departamentos;
    }

    /**
     * Obtém a lista de disciplinas, adicionando disciplinas fictícias.
     *
     * @return Lista de disciplinas.
     */
    public List<Disciplina> getDisciplinas() {
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
        return disciplinas;
    }

    /**
     * Obtém a lista de professores, adicionando professores fictícios.
     *
     * @return Lista de professores.
     */
    public List<Professor> getProfessores() {
        getDisciplinas();
        getDepartamentos();

        for (int i = 1; i <= QTDE_PROFESSORES; i++) {
            Departamento dep = (i >= 1 && i <= 10) ? departamentos.get(0) :
                    (i >= 11 && i <= 14) ? departamentos.get(1) :
                            departamentos.get(2);

            ArrayList<Disciplina> pdisciplinas = new ArrayList<>();
            if (i >= 1 && i <= 10) {
                pdisciplinas.add(disciplinas.get(0));
                pdisciplinas.add(disciplinas.get(5));
                pdisciplinas.add(disciplinas.get(3));
            } else if (i >= 11 && i <= 14) {
                pdisciplinas.add(disciplinas.get(2));
                pdisciplinas.add(disciplinas.get(4));
                pdisciplinas.add(disciplinas.get(1));
                pdisciplinas.add(disciplinas.get(8));
            } else {
                pdisciplinas.add(disciplinas.get(10));
                pdisciplinas.add(disciplinas.get(9));
                pdisciplinas.add(disciplinas.get(7));
            }

            Professor prof = new Professor(true, i + 0, "Professor" + i, dep, pdisciplinas);
            professores.add(prof);
        }
        return professores;
    }

    /**
     * Obtém a lista de alunos, adicionando alunos fictícios com base na quantidade e posição de início especificadas.
     *
     * @param qtde   Quantidade de alunos desejada.
     * @param inicio Posição de início para a geração de alunos.
     * @return Lista de alunos.
     */
    public List<Aluno> getAlunos(int qtde, int inicio) {
        List<Aluno> alunos = Alunos();
        List<Aluno> turma = new ArrayList<>();
        for (int i = inicio; i < qtde; i++)
            turma.add(new Aluno(i + 1, "Aluno" + (i + 1), "202320" + i, true));
        return alunos;
    }

    /**
     * Obtém uma lista fixa de 100 alunos fictícios.
     *
     * @return Lista de 100 alunos.
     */
    public List<Aluno> Alunos() {
        for (int i = 0; i < 100; i++)
            alunos.add(new Aluno(i + 1, "Aluno" + (i + 1), "202320" + i, true));
        return alunos;
    }

    /**
     * Exibe as informações da base de dados da UCSAL, incluindo disciplinas, professores e departamentos.
     */
    public void BasePrint() {
        System.out.println("Disciplinas: " + getDisciplinas());
        System.out.println("Professores: " + getProfessores());
        System.out.println("Departamentos: " + getDepartamentos());
    }
}
