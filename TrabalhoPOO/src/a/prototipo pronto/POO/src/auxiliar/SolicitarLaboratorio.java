package auxiliar;


import application.Base;
import entities.*;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SolicitarLaboratorio {

    private Scanner scanner;
    private List<Laboratorio> laboratorios;
    private List<Disciplina> disciplinas;
    private List<Departamento> departamentos;
    private List<Professor> professores;

    public SolicitarLaboratorio(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas,
                                List<Departamento> departamentos, List<Professor> professores) {
        this.scanner = scanner;
        this.laboratorios = laboratorios;
        this.disciplinas = disciplinas;
        this.departamentos = departamentos;
        this.professores = professores;
    }

    public Solicitacao solicitarLab() throws ParseException {
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setLaboratorio(obterLaboratorioPorDescricao());

        System.out.println("Informe o nome do professor responsável:");
        solicitacao.setProfessor(obterProfessorPorNome());

        System.out.println("Informe a sigla da disciplina:");
        solicitacao.setDisciplina(obterDisciplinaPorSigla());

        System.out.println("Informe a partir de qual posição (id) na lista de alunos você quer a lista:");
        int inicio = scanner.nextInt();
        solicitarAlunos(solicitacao, inicio);

        solicitarDataHora(solicitacao);

        System.out.println("Informe por quanto tempo (minutos) deseja reservar o laboratório:");
        long minutos = scanner.nextLong();
        solicitarTempo(solicitacao, minutos);

        exibirRevisao(solicitacao);
        return solicitacao;
    }

    private Laboratorio obterLaboratorioPorDescricao() {
        System.out.print("Informe qual laboratório deseja reservar (ex: lami1):");
        String descricao = scanner.next();
        return laboratorios.stream()
                .filter(lab -> lab.getDescricao().equalsIgnoreCase(descricao))
                .findFirst()
                .orElse(null);
    }

    private Professor obterProfessorPorNome() {
        String nome = scanner.next();
        return professores.stream()
                .filter(professor -> professor.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    private Disciplina obterDisciplinaPorSigla() {
        String sigla = scanner.next();
        Solicitacao solicitacao = new Solicitacao();
        return solicitacao.getProfessor().getPdisciplinas().stream()
                .filter(dis -> dis.getSigla().equalsIgnoreCase(sigla))
                .findFirst()
                .orElse(null);
    }

    private void solicitarAlunos(Solicitacao solicitacao, int inicio) {
        Base bd = new Base();
        List<Aluno> alunos = bd.getAlunos(solicitacao.getLaboratorio().getCapacidade(), inicio);
        Set<Aluno> turma = new HashSet<>(alunos);
        solicitacao.setAlunos(turma);
        System.out.println(turma);
        System.out.println();
    }

    private void solicitarDataHora(Solicitacao solicitacao) {
        System.out.print("Informe a data e horário (dd/MM/yy HH:mm) do uso do laboratório: ");
        String dataHoraString = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        try {
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, dateTimeFormatter);
            solicitacao.setDataHora(dataHora);
            System.out.println("Data e horário definidos com sucesso: " + dataHora);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data e horário inválido. Certifique-se de usar o formato dd/MM/yy HH:mm.");
            e.printStackTrace();
        }
    }

    private void solicitarTempo(Solicitacao solicitacao, long minutos) {
        Duration duration = Duration.ofMinutes(minutos);
        solicitacao.setTempo(duration);
    }

    private void exibirRevisao(Solicitacao solicitacao) {
        System.out.println("Aqui está a revisão da sua solicitação:");
        System.out.println(solicitacao);
    }
}