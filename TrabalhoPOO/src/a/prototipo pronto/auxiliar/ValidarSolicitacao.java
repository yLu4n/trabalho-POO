/**
 * A classe `ValidarSolicitacao` é responsável por verificar se uma solicitação de reserva de laboratório
 * entra em conflito com reservas já existentes. Ela verifica conflitos com base nas informações do professor
 * e do laboratório associados à solicitação, bem como na data, hora e duração da solicitação em relação às
 * reservas existentes.
 *
 * @author Sophia Medonça
 * @version 1.0
 * @since 29/11/2023
 */
package auxiliar;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que valida se uma solicitação de reserva de laboratório entra em conflito com reservas existentes.
 */
public class ValidarSolicitacao {

    // Atributo
    private boolean permitido = true;

    /**
     * Verifica se uma solicitação de reserva entra em conflito com reservas existentes.
     *
     * @param solicitacao A solicitação de reserva a ser verificada.
     * @param reservas    A lista de reservas existentes.
     * @return true se a solicitação for aprovada, false se houver conflito.
     */
    public boolean checarConflito(Solicitacao solicitacao, List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (solicitacao.getProfessor().equals(reserva.getSolicitacao().getProfessor())) {
                verificarConflito(solicitacao, reserva.getSolicitacao());
            }

            if (solicitacao.getLaboratorio().equals(reserva.getSolicitacao().getLaboratorio())) {
                verificarConflito(solicitacao, reserva.getSolicitacao());
            }
        }

        if (isPermitido()) {
            System.out.println("Solicitação aprovada.");
        } else {
            System.out.println("Solicitação recusada devido a conflitos.");
        }

        return isPermitido();
    }

    /**
     * Verifica se há conflito entre duas solicitações com base em suas datas, horas e durações.
     *
     * @param novaSolicitacao A nova solicitação a ser verificada.
     * @param existente        A solicitação existente com a qual a nova será comparada.
     */
    private void verificarConflito(Solicitacao novaSolicitacao, Solicitacao existente) {
        if (novaSolicitacao.getDataHora().toLocalDate().equals(existente.getDataHora().toLocalDate())) {
            LocalDateTime inicioNovaSolicitacao = novaSolicitacao.getDataHora();
            LocalDateTime fimNovaSolicitacao = inicioNovaSolicitacao.plus(novaSolicitacao.getTempo());

            LocalDateTime inicioReservaExistente = existente.getDataHora();
            LocalDateTime fimReservaExistente = inicioReservaExistente.plus(existente.getTempo());

            if (fimNovaSolicitacao.isBefore(inicioReservaExistente) || inicioNovaSolicitacao.isAfter(fimReservaExistente)) {
                permitido = true;
            } else {
                permitido = false;
            }
        }
    }

    /**
     * Verifica se a solicitação está permitida.
     *
     * @return true se a solicitação estiver permitida, false caso contrário.
     */
    public boolean isPermitido() {
        return permitido;
    }
}
