package application;

import auxiliar.*;
import entities.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Execucao {

    public static void main(String[] args) throws ParseException {
        Base bd = new Base(); // Configuração inicial
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.getAlunos(100, 0);

        Scanner scanner = new Scanner(System.in);
        Reservas reservas = new Reservas();
        List<Reserva> listaReservas = reservas.getListaReservas();
        List<Reserva> listaAprovadas = reservas.getListaAprovadas();
        int reservaID = 0;

        System.out.println("\nOla, seja bem-vindo(a) ao sistema de reserva de laboratórios da Ucsal\n");

        do {
            int resposta = exibirMenu(scanner);

            switch (resposta) {
                case 1:
                    processarSolicitacao(scanner, laboratorios, disciplinas, departamentos, professores, listaAprovadas, listaReservas, reservaID);
                    break;
                case 2:
                    System.out.println("Base de dados da UCSAL: ");
                    bd.BasePrint();
                    break;
                case 3:
                    System.out.println("Atendimento finalizado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println("Deseja realizar uma nova solicitação e reserva? (sim/nao)");
        } while (scanner.next().equalsIgnoreCase("sim"));

        System.out.println("Fim do atendimento");
        scanner.close();
    }

    private static int exibirMenu(Scanner scanner) {
        System.out.println("Para solicitar um laboratório, digite 1");
        System.out.println("Para exibir a base de dados da universidade, digite 2");
        System.out.println("Para finalizar o atendimento, digite 3");
        return scanner.nextInt();
    }

    private static void processarSolicitacao(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas,
                                             List<Departamento> departamentos, List<Professor> professores,
                                             List<Reserva> listaAprovadas, List<Reserva> listaReservas, int reservaID) throws ParseException {
        SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(scanner, laboratorios, disciplinas, departamentos, professores);
        Solicitacao solicitacao = solicitarLaboratorio.solicitarLab();
        System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
        String res1 = scanner.next();

        if (res1.equalsIgnoreCase("sim")) {
            ValidarSolicitacao validacao = new ValidarSolicitacao();
            boolean aprovacao = validacao.existenciaDeConflitos(solicitacao, listaAprovadas);
            LocalDate hoje = LocalDate.now();
            LocalDateTime hojeAgora = hoje.atTime(LocalTime.now());
            Reserva novaReserva = new Reserva(solicitacao, aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(),
                    solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);
            novaReserva.setId(reservaID);
            novaReserva.processarReserva(novaReserva, listaReservas, listaAprovadas);
            System.out.println("Lista de Reservas Geral: " + listaReservas);
            reservaID++;
        } else {
            System.out.println();
        }
    }
}