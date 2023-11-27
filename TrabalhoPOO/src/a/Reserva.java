package a;

public class Reserva {
	private Solicitacao solicitacao;
	private StatusReserva StatusReserva;
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	public StatusReserva getStatus() {
		return StatusReserva;
	}
	public void setStatus(StatusReserva status) {
		this.StatusReserva = status;
	}
	@Override
	public String toString() {
		return "Reserva [solicitacao=" + solicitacao + ", status=" + StatusReserva + "]";
	}
}