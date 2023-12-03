/**
 * A classe `Solicitacao` representa uma solicitação de reserva de laboratório no sistema da Ucsal.
 * Contém informações sobre o laboratório desejado, professor responsável, disciplina associada,
 * alunos envolvidos, data e hora da solicitação e a duração desejada.
 *
 *
 * @author BRUNO CASÉ and ZAIRA DUTRA
 * @version 1.0
 * @since 21/11/2023
 */
package auxiliar;

import entities.*;

import java.time.*;
import java.util.Set;

/**
 * Classe que representa uma solicitação de reserva de laboratório.
 */
public class Solicitacao {

    // Atributos
    private int id;
    private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private LocalDateTime dataHora;
    private Duration tempo;

    /**
     * Construtor da classe `Solicitacao`.
     *
     * @param id           O identificador único da solicitação.
     * @param laboratorio  O laboratório desejado para a reserva.
     * @param professor    O professor responsável pela solicitação.
     * @param disciplina   A disciplina associada à solicitação.
     * @param alunos       O conjunto de alunos envolvidos na solicitação.
     * @param dataHora     A data e hora da solicitação.
     * @param tempo        A duração desejada para a reserva.
     */
    public Solicitacao(int id, Laboratorio laboratorio, Professor professor, Disciplina disciplina,
                       Set<Aluno> alunos, LocalDateTime dataHora, Duration tempo) {
        this.id = id;
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.dataHora = dataHora;
        this.tempo = tempo;
    }

    /**
     * Construtor vazio da classe `Solicitacao`.
     */
    public Solicitacao() {
    }

    // Métodos Acessores

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    /**
     * Representação textual da solicitação.
     *
     * @return Uma string representando a solicitação.
     */
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
