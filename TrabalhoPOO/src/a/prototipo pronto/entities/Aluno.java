/**
 * A classe `Aluno` representa um aluno no sistema de reserva de laboratórios da Ucsal.
 * Possui atributos como id, nome, matrícula e status.
 *
 * @author Bruno Casé e Zaira Dutra
 * @version 1.0
 * @since 21/11/2023
 */
package entities;

/**
 * Classe que representa um aluno.
 */
public class Aluno {

    // Atributos
    private long id;
    private String nome;
    private String matricula;
    private boolean status;

    /**
     * Construtor da classe `Aluno`.
     *
     * @param id        O id do aluno.
     * @param nome      O nome do aluno.
     * @param matricula A matrícula do aluno.
     * @param status    O status do aluno.
     */
    public Aluno(long id, String nome, String matricula, boolean status) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.status = status;
    }

    /**
     * Obtém o status do aluno.
     *
     * @return O status do aluno.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Define o status do aluno.
     *
     * @param status O novo status do aluno.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Obtém o id do aluno.
     *
     * @return O id do aluno.
     */
    public long getId() {
        return id;
    }

    /**
     * Define o id do aluno.
     *
     * @param id O novo id do aluno.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtém a matrícula do aluno.
     *
     * @return A matrícula do aluno.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define a matrícula do aluno.
     *
     * @param matricula A nova matrícula do aluno.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtém o nome do aluno.
     *
     * @return O nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     *
     * @param nome O novo nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Representação textual do aluno.
     *
     * @return Uma string representando o aluno.
     */
    @Override
    public String toString() {
        return "Aluno{" +
                " nome='" + nome + '\'' +
                '}';
    }
}
