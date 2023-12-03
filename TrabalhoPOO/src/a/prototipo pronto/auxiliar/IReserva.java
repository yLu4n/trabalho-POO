/**
 * A interface `IReserva` define o contrato para efetivação de reservas no sistema de reserva de laboratórios da Ucsal.
 * Implementada por classes que desejam realizar a efetivação de uma reserva.
 *
 * @author Guilherme Souza
 * @version 1.0
 * @since 28/11/2023
 */
package auxiliar;

import java.util.List;

/**
 * A interface `IReserva` define o contrato para efetivação de reservas no sistema de reserva de laboratórios da Ucsal.
 * Implementada por classes que desejam realizar a efetivação de uma reserva.
 */
public interface IReserva {
    /**
     * Efetiva a reserva do laboratório, adicionando-a às listas de reservas gerais e aprovadas.
     *
     * @param reserva        A reserva a ser efetivada.
     * @param listaReservas  A lista geral de reservas.
     * @param listaAprovadas A lista de reservas aprovadas.
     */
    void efetivar(Reserva reserva, List<Reserva> listaReservas, List<Reserva> listaAprovadas);
}
