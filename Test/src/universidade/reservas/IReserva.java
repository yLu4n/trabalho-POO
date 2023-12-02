package universidade.reservas;

import universidade.entidades.Solicitacao;

public interface IReserva {
	CategoriaReserva validarSolicitacao(Solicitacao solicitacao);
}
