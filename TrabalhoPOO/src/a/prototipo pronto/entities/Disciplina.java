/**
 * A classe `Disciplina` representa uma disciplina no sistema de reserva de laboratórios da Ucsal.
 * Possui atributos como sigla, descrição, id e status.
 *
 * @author Bruno Casé e Zaira Dutra
 * @version 1.0
 * @since 21/11/2023
 */
package entities;


/**
 * Classe que representa uma disciplina.
 */
public class Disciplina {

    // Atributos

    private String sigla;
    private String descricao;
    private long id;
    private boolean status;

    /**
     * Construtor da classe `Disciplina`.
     *
     * @param sigla     A sigla da disciplina.
     * @param descricao A descrição da disciplina.
     * @param id        O id da disciplina.
     * @param status    O status da disciplina.
     */
    public Disciplina(String sigla, String descricao, long id, boolean status) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.id = id;
        this.status = status;
    }

    /**
     * Verifica o status da disciplina.
     *
     * @return True se estiver ativa, false se estiver inativa.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o status da disciplina.
     *
     * @param status O novo status da disciplina.
     */
    public void setAtiva(boolean status) {
        this.status = status;
    }

    /**
     * Obtém a descrição da disciplina.
     *
     * @return A descrição da disciplina.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da disciplina.
     *
     * @param descricao A nova descrição da disciplina.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o id da disciplina.
     *
     * @return O id da disciplina.
     */
    public long getId() {
        return id;
    }

    /**
     * Define o id da disciplina.
     *
     * @param id O novo id da disciplina.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtém a sigla da disciplina.
     *
     * @return A sigla da disciplina.
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * Define a sigla da disciplina.
     *
     * @param sigla A nova sigla da disciplina.
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * Representação textual da disciplina.
     *
     * @return Uma string representando a disciplina.
     */
    @Override
    public String toString() {
        return "Disciplina{" +
                " sigla='" + sigla + '\'' +
                "}";
    }
}
