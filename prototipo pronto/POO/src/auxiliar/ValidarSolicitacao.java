
package auxiliar;

import java.time.LocalDateTime;
import java.util.List;

public class ValidarSolicitacao {

    private boolean validado = true;

    public boolean existenciaDeConflitos(Solicitacao novaSolicitacao, List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (checarConflitoEntreSolicitacoes(novaSolicitacao, reserva.getSolicitacao())) {
                validado = false;
                break;  // Se houver algum conflito, não é necessário continuar verificando
            }
        }

        showResults();
        return validado;
    }

    private boolean checarConflitoEntreSolicitacoes(Solicitacao novaSolicitacao, Solicitacao existente) {
        LocalDateTime inicioNovaSolicitacao = novaSolicitacao.getDataHora();
        LocalDateTime fimNovaSolicitacao = inicioNovaSolicitacao.plus(novaSolicitacao.getTempo());

        LocalDateTime inicioReservaExistente = existente.getDataHora();
        LocalDateTime fimReservaExistente = inicioReservaExistente.plus(existente.getTempo());

        return !fimNovaSolicitacao.isBefore(inicioReservaExistente) && !inicioNovaSolicitacao.isAfter(fimReservaExistente);
    }

    private void showResults() {
        if (validado) {
            System.out.println("Solicitação aprovada.");
        } else {
            System.out.println("Solicitação recusada devido a conflitos.");
        }
    }

    public boolean isPermitido() {
        return validado;
    }
}
