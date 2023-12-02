package a;
public class Main {

    public static void main(String[] args) {
    	
    	
        Base baseDados = new Base();
        Laboratorio solLab = new Laboratorio();
        Solicitacao valSol = new Solicitacao();

        
        Impressao.imprimirSolicitacao(solicitacao);
        Impressao.imprimirReservas(solLab.getReservasEfetivadas());
        Impressao.imprimirLaboratorios(baseDados.getLaboratorios());
        Impressao.imprimirProfessores(baseDados.getProfessores());
        Impressao.imprimirDisciplinas(baseDados.getDisciplinas());
        Impressao.imprimirAlunos(baseDados.getAlunos(5, 0));
    }
}
