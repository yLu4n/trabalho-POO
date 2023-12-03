package universidade.auxiliar;
import java.util.ArrayList;
import java.util.List;

public class Reservas {

	private List<Reserva> listaReservas = new ArrayList<>();
    private List<Reserva> listaAprovadas = new ArrayList<>();

    public List<Reserva> getListaAprovadas() {
        return new ArrayList<>(listaAprovadas);
    }

    public List<Reserva> getListaReservas() {
        return new ArrayList<>(listaReservas);
    }

    public void adicionarReserva(Reserva reserva) {
        listaReservas.add(reserva);
        if (reserva.getSituacaoReserva() == SituacaoReserva.APROVADA) {
            listaAprovadas.add(reserva);
        }
    }
}
