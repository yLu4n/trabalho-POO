package auxiliar;

import entities.*;

import java.time.*;
import java.util.Set;
import java.util.HashSet;
public class Solicitacao {

    
	private static int contadorId = 0;

    private int id;
    private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private LocalDateTime dataHora;
    private Duration tempo;

    public Solicitacao(Laboratorio laboratorio, Professor professor, Disciplina disciplina,
                       Set<Aluno> alunos, LocalDateTime dataHora, Duration tempo) {
        this.id = gerarIdUnico();
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new HashSet<>(alunos);
        this.dataHora = dataHora;
        this.tempo = tempo;
    }

    public Solicitacao() {
        this.alunos = new HashSet<>();
    }

    private static int gerarIdUnico() {
        return ++contadorId;
    }

    public int getId() {
        return id;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Set<Aluno> getAlunos() {
        return new HashSet<>(alunos);
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = new HashSet<>(alunos);
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Duration getTempo() {
        return tempo;
    }

    public void setTempo(Duration tempo) {
        this.tempo = tempo;
    }

    private String formatarDuracao(Duration duration) {
        long horas = duration.toHours();
        long minutos = duration.toMinutesPart();

        return String.format("%d horas e %d minutos", horas, minutos);
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", laboratorio=" + laboratorio +
                ", professor=" + professor +
                ", disciplina=" + disciplina +
                ", alunos=" + alunos +
                ", data='" + dataHora + '\'' +
                ", tempo=" + formatarDuracao(tempo) +
                '}';
    }
}
