package universidades.execucao;

import java.util.ArrayList;
import java.util.List;

import universidade.entidades.Reserva;
import universidade.reservas.BaseDados;
import universidade.reservas.SolicitarLaboratorio;
import universidade.reservas.ValidarSolicitacao;

public class Execucao {
    public static void main(String[] args) {
        BaseDados baseDados = new BaseDados();
        List<Reserva> reservas = new ArrayList<>();
        ValidarSolicitacao validarSolicitacao = new ValidarSolicitacao(reservas);
        SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(baseDados, validarSolicitacao, reservas);

        solicitarLaboratorio.solicitar();
    }
}