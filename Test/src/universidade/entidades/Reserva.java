package universidade.entidades;

import java.util.Date;

import universidade.reservas.CategoriaReserva;
import universidade.reservas.IReserva;

public class Reserva implements IReserva {
    private static int idCounter = 1;
    private final int id;
    private final Solicitacao solicitacao;
    private final CategoriaReserva categoria;
    private final Date dataReserva;
    private final int duracaoMinutos;
    private final Date dataLiberacao;

    public Reserva(Solicitacao solicitacao) {
        this.id = idCounter++;
        this.solicitacao = solicitacao;
        this.categoria = CategoriaReserva.REPROVADA;
        this.dataReserva = new Date();
        this.duracaoMinutos = solicitacao.getTempoMinutos();
        this.dataLiberacao = new Date(dataReserva.getTime() + duracaoMinutos * 60000);
    }

    @Override
    public CategoriaReserva validarSolicitacao(Solicitacao solicitacao) {
       
        return null;
    }
    
    public static int getIdCounter() {
		return idCounter;
	}

	public int getId() {
		return id;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public CategoriaReserva getCategoria() {
		return categoria;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public Date getDataLiberacao() {
		return dataLiberacao;
	}

	public static void setIdCounter(int idCounter) {
		Reserva.idCounter = idCounter;
	}

	public String toString() {
    	return "";
    }
   
}