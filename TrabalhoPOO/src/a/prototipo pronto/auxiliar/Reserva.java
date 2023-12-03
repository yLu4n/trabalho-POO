/**
 * A classe `Reserva` representa uma reserva de laboratório no sistema de reserva da Ucsal.
 * Implementa a interface `IReserva` para definir o contrato de efetivação de reservas.
 *
 * @author Guilherme Souza
 * @version 1.0
 * @since 28/11/2023
 */
package auxiliar;

import entities.Disciplina;
import entities.Professor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


/**
 * A classe `Reserva` representa uma reserva de laboratório no sistema de reserva da Ucsal.
 * Implementa a interface `IReserva` para definir o contrato de efetivação de reservas.
 */
public class Reserva implements IReserva {

    private int id;
    private Solicitacao solicitacao;
    private SituacaoReserva situacaoReserva;
    private LocalDateTime diaHoraReserva;
    private Duration duracao;
    private Professor professor;
    private Disciplina disciplina;
    private LocalDateTime dataLiberacao;

    /**
     * Construtor da classe `Reserva`.
     *
     * @param solicitacao     A solicitação associada à reserva.
     * @param valido           Indica se a reserva é válida ou não.
     * @param diaHora          A data e hora da reserva.
     * @param duracao          A duração da reserva.
     * @param professor        O professor responsável pela reserva.
     * @param disciplina       A disciplina associada à reserva.
     * @param dataLiberacao    A data de liberação da reserva.
     */
    public Reserva(Solicitacao solicitacao, boolean valido, LocalDateTime diaHora, Duration duracao,
                   Professor professor, Disciplina disciplina, LocalDateTime dataLiberacao) {
        this.id = gerarIdUnico();  // Gerar um id único para a reserva
        this.solicitacao = solicitacao;
        this.situacaoReserva = (valido) ? SituacaoReserva.APROVADA : SituacaoReserva.REPROVADA;
        this.diaHoraReserva = diaHora;
        this.duracao = duracao;
        this.professor = professor;
        this.disciplina = disciplina;
        this.dataLiberacao = dataLiberacao;
    }

    /**
     * Método estático para gerar um id único para a reserva.
     *
     * @return O id gerado.
     */
    private static int gerarIdUnico() {
        // Lógica para gerar um id único (pode ser implementado conforme necessário)
        // Exemplo simples: retornar o valor do relógio em milissegundos
        return (int) System.currentTimeMillis();
    }

    /**
     * Implementação do método da interface `IReserva` para efetivar a reserva.
     * Adiciona a reserva às listas de reservas gerais e aprovadas, se aprovada.
     *
     * @param reserva        A reserva a ser efetivada.
     * @param listaReservas  A lista geral de reservas.
     * @param listaAprovadas A lista de reservas aprovadas.
     */
    @Override
    public void efetivar(Reserva reserva, List<Reserva> listaReservas, List<Reserva> listaAprovadas) {
        listaReservas.add(reserva);
        if (reserva.situacaoReserva == SituacaoReserva.APROVADA) {
            listaAprovadas.add(reserva);
        }
    }

    /**
     * Obtém a data de liberação da reserva.
     *
     * @return A data de liberação da reserva.
     */
    public LocalDateTime getDataLiberacao() {
        return dataLiberacao;
    }

    /**
     * Obtém a data e hora da reserva.
     *
     * @return A data e hora da reserva.
     */
    public LocalDateTime getDiaHoraReserva() {
        return diaHoraReserva;
    }

    /**
     * Define a data e hora da reserva.
     *
     * @param diaHora A nova data e hora da reserva.
     */
    public void setDiaHoraReserva(LocalDateTime diaHora) {
        this.diaHoraReserva = diaHora;
    }

    /**
     * Obtém a duração da reserva.
     *
     * @return A duração da reserva.
     */
    public Duration getDuracao() {
        return duracao;
    }

    /**
     * Define a duração da reserva.
     *
     * @param duracao A nova duração da reserva.
     */
    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    /**
     * Obtém o id da reserva.
     *
     * @return O id da reserva.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id da reserva.
     *
     * @param id O novo id da reserva.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a situação da reserva.
     *
     * @return A situação da reserva.
     */
    public SituacaoReserva getSituacao() {
        return situacaoReserva;
    }

    /**
     * Define a situação da reserva.
     *
     * @param situacaoReserva A nova situação da reserva.
     */
    public void setSituacao(SituacaoReserva situacaoReserva) {
        this.situacaoReserva = situacaoReserva;
    }

    /**
     * Obtém a solicitação associada à reserva.
     *
     * @return A solicitação associada à reserva.
     */
    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    /**
     * Define a solicitação associada à reserva.
     *
     * @param solicitacao A nova solicitação associada à reserva.
     */
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    /**
     * Representação textual da reserva.
     *
     * @return Uma string representando a reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", situacao=" + situacaoReserva +
                ", solicitacao=" + solicitacao +
                ", diaDaReserva='" + diaHoraReserva + '\'' +
                ", duracao=" + duracao +
                '}';
    }
}
