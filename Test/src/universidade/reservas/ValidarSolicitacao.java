package universidade.reservas;

import java.util.Date;
import java.util.List;

import universidade.entidades.Reserva;
import universidade.entidades.Solicitacao;

public class ValidarSolicitacao {
    private final List<Reserva> reservas;

    public ValidarSolicitacao(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public CategoriaReserva validarSolicitacao(Solicitacao novaSolicitacao) {
        for (Reserva reservaExistente : reservas) {
            if (reservaExistente.getCategoria() == CategoriaReserva.APROVADA &&
                    reservasConflitantes(novaSolicitacao, reservaExistente)) {
                System.out.println("Solicitação REPROVADA devido a conflito com reserva existente.");
                return CategoriaReserva.REPROVADA;
            }
        }

        int contadorAprovadas = contarReservasAprovadasDoProfessor(novaSolicitacao.getProfessor().getId());
        if (contadorAprovadas >= 6) {
            System.out.println("Solicitação APROVADA. Professor atingiu o limite de 6 reservas aprovadas.");
            return CategoriaReserva.APROVADA;
        }

        System.out.println("Solicitação APROVADA.");
        return CategoriaReserva.APROVADA;
    }

    private boolean reservasConflitantes(Solicitacao novaSolicitacao, Reserva reservaExistente) {
        Date inicioNovaSolicitacao = novaSolicitacao.getData();
        Date fimNovaSolicitacao = new Date(inicioNovaSolicitacao.getTime() + novaSolicitacao.getTempoMinutos() * 60000);

        Date inicioReservaExistente = reservaExistente.getSolicitacao().getData();
        Date fimReservaExistente = reservaExistente.getDataLiberacao();

        return !(fimNovaSolicitacao.before(inicioReservaExistente) || inicioNovaSolicitacao.after(fimReservaExistente));
    }

    private int contarReservasAprovadasDoProfessor(int idProfessor) {
        int contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getCategoria() == CategoriaReserva.APROVADA &&
                    reserva.getSolicitacao().getProfessor().getId() == idProfessor) {
                contador++;
            }
        }
        return contador;
    }
}
