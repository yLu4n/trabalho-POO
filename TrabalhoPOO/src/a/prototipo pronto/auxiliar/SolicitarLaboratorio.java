/**
 * A classe `SolicitarLaboratorio` é responsável por gerenciar a solicitação de reserva de laboratório,
 * coletando informações como laboratório desejado, professor responsável, disciplina associada, turma de alunos,
 * data e horário de uso do laboratório, e a duração da reserva.
 *
 * @author Guilherme Souza
 * @version 1.0
 * @since 25/11/2023
 */
package auxiliar;


import application.Base;
import entities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class SolicitarLaboratorio {


    private Scanner scanner;
    private List<Laboratorio> laboratorios;
    private List<Disciplina> disciplinas;
    private List<Departamento> departamentos;
    private List<Professor> professores;

    /**
     * Construtor da classe `SolicitarLaboratorio`.
     *
     * @param scanner      Scanner para entrada de dados.
     * @param laboratorios Lista de laboratórios disponíveis.
     * @param disciplinas  Lista de disciplinas associadas aos professores.
     * @param departamentos Lista de departamentos.
     * @param professores  Lista de professores disponíveis.
     */
    public SolicitarLaboratorio(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas,
                                List<Departamento> departamentos, List<Professor> professores) {
        this.scanner = scanner;
        this.laboratorios = laboratorios;
        this.disciplinas = disciplinas;
        this.departamentos = departamentos;
        this.professores = professores;

    }

    /**
     * Método para solicitar a reserva de laboratório, coletando todas as informações necessárias.
     *
     * @return Um objeto `Solicitacao` contendo os detalhes da solicitação.
     * @throws ParseException Caso ocorra um erro durante a análise de datas.
     */
    public Solicitacao solicitarLab() throws ParseException {
        Solicitacao solicitacao = new Solicitacao();

        // Definindo o laboratório
        System.out.print("Informe qual laboratório deseja reservar (ex: lami1):");
        String lami = scanner.next();

        for (Laboratorio lab : laboratorios) {
            if (lab.getDescricao().equalsIgnoreCase(lami)) {
                solicitacao.setLaboratorio(lab);
            }
        }

        // Definindo o professor
        System.out.println("Informe o nome do professor responsável (ex: professor1) :");
        String prof = scanner.next();
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(prof)) {
                solicitacao.setProfessor(professor);
                System.out.println(professor);
            }
        }

        // Definindo a disciplina
        System.out.println("Informe a sigla da disciplina (ex: bes005):");
        String sigla = scanner.next();
        for (Disciplina dis : solicitacao.getProfessor().getPdisciplinas()) {
            if (dis.getSigla().equalsIgnoreCase(sigla)) {
                solicitacao.setDisciplina(dis);
                System.out.println(dis);
            }
        }

        // Definindo a turma
        System.out.println("Informe a partir de qual posição (id) na lista de alunos você quer a lista :");
        int inicio = scanner.nextInt();
        scanner.nextLine();
        Base bd = new Base();
        List<Aluno> alunos = bd.getAlunos(solicitacao.getLaboratorio().getCapacidade(), inicio);
        Set<Aluno> turma = new HashSet<>(alunos);
        System.out.println(turma);
        solicitacao.setAlunos(turma);
        System.out.println();

        // Solicitar data e hora ao mesmo tempo
        System.out.print("Informe a data e horário (dd/MM/yy HH:mm) do uso do laboratório: ");
        String dataHoraString = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        try {
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, dateTimeFormatter);
            solicitacao.setDataHora(dataHora);
            System.out.println("Data e horário definidos com sucesso: " + dataHora);

            // Aqui você pode usar 'dataHora' conforme necessário, por exemplo, definindo em 'solicitacao.setDataHora(dataHora)'
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data e horário inválido. Certifique-se de usar o formato dd/MM/yy HH:mm.");
            e.printStackTrace();
        }

        System.out.println("Informe quanto por quanto tempo (minutos) deseja reservar o laboratório:");

        long minutos = scanner.nextLong();

        // Criar uma Duration a partir dos segundos inseridos pelo usuário
        Duration duration = Duration.ofMinutes(minutos);
        solicitacao.setTempo(duration);

        System.out.println("Aqui está a revisão da sua solicitação:");
        System.out.println(solicitacao);
        return solicitacao;
    }

}
