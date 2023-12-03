package auxiliar;

import java.util.List;

public interface IReserva {

    void processarReserva(Reserva reserva, List<Reserva> listaReservas, List<Reserva> listaAprovadas);
}
