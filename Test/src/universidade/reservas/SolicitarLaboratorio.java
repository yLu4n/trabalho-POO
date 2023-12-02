package universidade.reservas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import universidade.entidades.Disciplina;
import universidade.entidades.Laboratorio;
import universidade.entidades.Professor;
import universidade.entidades.Reserva;
import universidade.entidades.Solicitacao;

public class SolicitarLaboratorio {
    private final BaseDados baseDados;
    private final ValidarSolicitacao validarSolicitacao;
    private final List<Reserva> reservas;

    public SolicitarLaboratorio(BaseDados baseDados, ValidarSolicitacao validarSolicitacao, List<Reserva> reservas) {
        this.baseDados = baseDados;
        this.validarSolicitacao = validarSolicitacao;
        this.reservas = reservas;
    }

    public void solicitar() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Informe qual laboratório deseja reservar?");
            String nomeLaboratorio = sc.nextLine();

            Laboratorio laboratorio = encontrarLaboratorio(nomeLaboratorio);

            if (laboratorio != null) {
                System.out.println("Informe o nome do professor:");
                String nomeProfessor = sc.nextLine();

                Professor professor = encontrarProfessor(nomeProfessor);

                if (professor != null) {
                    System.out.println("Informe a sigla da disciplina:");
                    String siglaDisciplina = sc.nextLine();

                    Disciplina disciplina = encontrarDisciplina(siglaDisciplina);

                    if (disciplina != null) {
                        System.out.println("Informe a data inicial de uso do laboratório (dd/MM/yyyy):");
                        String dataStr = sc.nextLine();

                        Date data = converterStringParaData(dataStr);

                        System.out.println("Informe a hora inicial de uso do laboratório (HH:mm):");
                        String horaStr = sc.nextLine();

                        Date dataHora = converterStringParaDataHora(dataStr, horaStr);

                        System.out.println("Informe por quantos minutos deseja usar o laboratório:");
                        int tempoMinutos = sc.nextInt();
                        sc.nextLine();

                        Solicitacao solicitacao = new Solicitacao(laboratorio, professor, disciplina,
                                baseDados.getAlunos(5, 10), dataHora, tempoMinutos);

                        CategoriaReserva categoria = validarSolicitacao.validarSolicitacao(solicitacao);
                        if (categoria == CategoriaReserva.APROVADA) {
                            Reserva reserva = new Reserva(solicitacao);
                            reservas.add(reserva);
                        }

                        System.out.println("Deseja fazer outra solicitação? (S/N)");
                        String resposta = sc.nextLine().toUpperCase();
                        if (!resposta.equals("S")) {
                            break;
                        }
                    } else {
                        System.out.println("Disciplina não encontrada. Tente novamente.");
                    }
                } else {
                    System.out.println("Professor não encontrado. Tente novamente.");
                }
            } else {
                System.out.println("Laboratório não encontrado. Tente novamente.");
            }
        } while (true);

        System.out.println("Solicitações finalizadas.");
        sc.close();
    }

    private Laboratorio encontrarLaboratorio(String nome) {
        for (Laboratorio lab : baseDados.getLaboratorios()) {
            if (lab.getDescricao().equalsIgnoreCase(nome)) {
                return lab;
            }
        }
        return null;
    }

    private Professor encontrarProfessor(String nome) {
        for (Professor prof : baseDados.getProfessores()) {
            if (prof.getNome().equalsIgnoreCase(nome)) {
                return prof;
            }
        }
        return null;
    }

    private Disciplina encontrarDisciplina(String sigla) {
        for (Disciplina disc : baseDados.getDisciplinas()) {
            if (disc.getSigla().equalsIgnoreCase(sigla)) {
                return disc;
            }
        }
        return null;
    }

    private Date converterStringParaData(String dataStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Date converterStringParaDataHora(String dataStr, String horaStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return sdf.parse(dataStr + " " + horaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}