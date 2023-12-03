/**
 * A classe `Reservas` representa a coleção de reservas no sistema de reserva da Ucsal.
 * Mantém listas separadas para todas as reservas e as reservas aprovadas.
 * É responsável por armazenar e fornecer acesso a essas listas.
 *
 * @author Guilherme Souza
 * @version 1.0
 * @since 29/11/23
 */
package auxiliar;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe `Reservas` representa a coleção de reservas no sistema de reserva da Ucsal.
 * Mantém listas separadas para todas as reservas e as reservas aprovadas.
 * É responsável por armazenar e fornecer acesso a essas listas.
 */
public class Reservas {

    private List<Reserva> listaReservas;
    private List<Reserva> listaAprovadas;

    /**
     * Construtor da classe `Reservas`.
     * Inicializa as listas de reservas e reservas aprovadas.
     */
    public Reservas() {
        this.listaReservas = new ArrayList<>();
        this.listaAprovadas = new ArrayList<>();
    }

    /**
     * Obtém a lista de reservas aprovadas.
     *
     * @return A lista de reservas aprovadas.
     */
    public List<Reserva> getListaAprovadas() {
        return listaAprovadas;
    }

    /**
     * Define a lista de reservas aprovadas.
     *
     * @param listaAprovadas A nova lista de reservas aprovadas.
     */
    public void setListaAprovadas(List<Reserva> listaAprovadas) {
        this.listaAprovadas = listaAprovadas;
    }

    /**
     * Obtém a lista de todas as reservas.
     *
     * @return A lista de todas as reservas.
     */
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * Define a lista de todas as reservas.
     *
     * @param listaReservas A nova lista de todas as reservas.
     */
    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

}
