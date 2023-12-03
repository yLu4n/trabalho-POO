/**
 * A classe `Execucao` representa a execução principal do sistema de reserva de laboratórios da Ucsal.
 * Permite aos usuários solicitar reservas de laboratórios, exibir a base de dados da universidade e finalizar o atendimento.
 * A interação com o usuário é realizada por meio de um menu simples.
 *
 * @author Guilherme Souza
 * @version 1.0
 * @since 25/11/2023
 */
package application;

import auxiliar.*;
import entities.*;
import java.time.*;
import java.util.*;
import java.text.ParseException;



public class Execucao {


    /**
     * Método principal que inicia a execução do sistema de reserva de laboratórios.
     *
     * @param args Argumentos de linha de comando (não são utilizados neste programa).
     * @throws ParseException Exceção lançada em caso de erro na análise de datas.
     */
    public static void main(String[] args) throws ParseException {
        Base bd = new Base(); // Configuração inicial
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.Alunos();

        Scanner ler = new Scanner(System.in);

        System.out.println();
        System.out.println("Ola, seja bem-vindo(a) ao sistema de reserva de laboratórios da Ucsal");
        System.out.println();
        int resposta;
        String answer;
        Reservas reservas = new Reservas();
        List<Reserva> listaReservas = reservas.getListaReservas();
        List<Reserva> listaAprovadas = reservas.getListaAprovadas();
        int reservaID = 0;

        do {
            System.out.println("Para solicitar um laboratório digite 1");
            System.out.println("Para exibir a base de dados da universidade digite 2");
            System.out.println("Para finalizar o atendimento digite 3");
            resposta = ler.nextInt();

            if (resposta == 1) {
                SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(ler, laboratorios, disciplinas, departamentos, professores);
                Solicitacao solicitacao = solicitarLaboratorio.solicitarLab(); // Cria uma solicitação
                System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
                String res1 = ler.next();

                if (res1.equalsIgnoreCase("sim")) {
                    ValidarSolicitacao validacao = new ValidarSolicitacao();
                    boolean aprovacao = validacao.checarConflito(solicitacao, listaAprovadas); //variavel armazena o resultado booleano da checagem
                    LocalDate hoje = LocalDate.now();
                    LocalDateTime hojeAgora = hoje.atTime(LocalTime.now());
                    Reserva novaReserva = new Reserva(solicitacao, aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(), solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);
                    novaReserva.setId(reservaID);
                    novaReserva.efetivar(novaReserva, listaReservas, listaAprovadas);//A reserva aprovada vai para uma lista de aprovadas
                    System.out.println("Lista de Reservas Geral: "+ listaReservas); // é mostrada uma lista geral com todas as reservas
                    reservaID++;
                } else {
                    System.out.println();
                }


            } else if (resposta == 2) {
                System.out.println("Base de dados da UCSAL: ");
                bd.BasePrint();
            } else if (resposta == 3) {
                System.out.println("Atendimento finalizado");
            }

            System.out.println("Deseja realizar uma nova solicitação e reserva? (sim/nao)");
            answer = ler.next();

        } while (answer.equalsIgnoreCase("sim") || resposta !=3);

        System.out.println("Fim do atendimento");

        ler.close();
    }
}