package exe;

import BaseDeDados.Base;
import auxiliar.*;
import entidades.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Execucao {

    public static void main(String[] args) throws ParseException {
    	Base bd = new Base();
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.Alunos();

        Scanner ler = new Scanner(System.in);

        System.out.println("Seja bem-vindo ao servico de reservas de laboratorios.");
        System.out.println();
        String answer;
        Reservas reservas = new Reservas();
        List<Reserva> listaReservas = reservas.getListaReservas();
        List<Reserva> listaAprovadas = reservas.getListaAprovadas();
        int reservaID = gerarIdUnico();

        do {
            System.out.println("O que voce gostaria de fazer?");
            System.out.println("- Solicitar laboratorio");
            System.out.println("- Exibir base de dados da universidade");
            System.out.println("- Finalizar atendimento");

            String escolha = ler.nextLine().toLowerCase(); 

            switch (escolha) {
                case "solicitar laboratorio":
                    SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(ler, laboratorios, disciplinas, departamentos, professores);
                    Solicitacao solicitacao = solicitarLaboratorio.solicitarLab();
                    System.out.println("Gostaria de continuar com a reserva? (sim/nao)");
                    String res1 = ler.next();

                    if (res1.equalsIgnoreCase("sim")) {
                        ValidarSolicitacao validacao = new ValidarSolicitacao();
                        boolean aprovacao = validacao.existenciaDeConflitos(solicitacao, listaAprovadas);
                        LocalDateTime hojeAgora = LocalDateTime.now();
                        Reserva novaReserva = new Reserva(solicitacao, aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(), solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);
                        novaReserva.setId(reservaID);
                        novaReserva.processarReserva(novaReserva, listaReservas, listaAprovadas);
                        System.out.println("Lista geral de reservas: " + listaReservas);
                        reservaID++;
                    } else {
                        System.out.println();
                    }
                    break;

                case "exibir base de dados da universidade":
                    System.out.println("Base de dados da UCSAL: ");
                    bd.BasePrint();
                    break;

                case "finalizar atendimento":
                    System.out.println("Atendimento finalizado");
                    break;

                default:
                    System.out.println("Opção invalida. Por favor, escolha novamente.");
            }

            System.out.println("Deseja realizar uma nova solicitacao e reserva? (sim/nao)");
            answer = ler.next();
            ler.nextLine(); 

        } while (answer.equalsIgnoreCase("sim"));

        System.out.println("Fim do atendimento");

        ler.close();
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
    
    private static int gerarIdUnico() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }
    
}