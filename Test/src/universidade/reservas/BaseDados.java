package universidade.reservas;

import java.util.ArrayList;
import java.util.List;

import universidade.entidades.Aluno;
import universidade.entidades.Departamento;
import universidade.entidades.Disciplina;
import universidade.entidades.Laboratorio;
import universidade.entidades.Professor;

public class BaseDados implements IBase{
    private final List<Laboratorio> laboratorios;
    private final List<Departamento> departamentos;
    private final List<Professor> professores;
    private final List<Disciplina> disciplinas;
    private final List<Aluno> alunos;

    public BaseDados() {
        this.laboratorios = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    @Override
    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    @Override
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    @Override
    public List<Professor> getProfessores() {
        return professores;
    }

    @Override
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public List<Aluno> getAlunos(int quantidade, int inicio) {
        List<Aluno> result = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            result.add(new Aluno(inicio + i, "ALUNO" + (inicio + i), true));
        }
        return result;
    }
}