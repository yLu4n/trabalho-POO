package entities;

import java.util.List;

/**
 * A classe `Professor` representa um professor no sistema da Ucsal.
 * Possui atributos como id, nome, status, departamento e pdisciplinas.
 *
 * @author Bruno Casé e Zaira Dutra
 * @version 1.0
 * @since 21/11/2023
 */
public class Professor {

    // Atributos
    private long id;
    private String nome;
    private boolean status;
    private Departamento departamento;
    private List<Disciplina> pdisciplinas;

    /**
     * Construtor da classe `Professor`.
     *
     * @param ativo        Indica se o professor está ativo.
     * @param id           O id do professor.
     * @param nome         O nome do professor.
     * @param departamento O departamento ao qual o professor está associado.
     * @param pdisciplinas As disciplinas associadas ao professor.
     */
    public Professor(boolean ativo, long id, String nome, Departamento departamento, List<Disciplina> pdisciplinas) {
        this.status = ativo;
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.pdisciplinas = pdisciplinas;
    }

    /**
     * Obtém o departamento do professor.
     *
     * @return O departamento do professor.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Define o departamento do professor.
     *
     * @param departamento O novo departamento do professor.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtém as pdisciplinas associadas ao professor.
     *
     * @return As pdisciplinas associadas ao professor.
     */
    public List<Disciplina> getPdisciplinas() {
        return pdisciplinas;
    }

    /**
     * Define as pdisciplinas associadas ao professor.
     *
     * @param pdisciplinas As novas pdisciplinas associadas ao professor.
     */
    public void setPdisciplinas(List<Disciplina> pdisciplinas) {
        this.pdisciplinas = pdisciplinas;
    }

    /**
     * Verifica se o professor está ativo.
     *
     * @return True se estiver ativo, false se estiver inativo.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o status do professor.
     *
     * @param ativo O novo status do professor.
     */
    public void setStatus(boolean ativo) {
        this.status = ativo;
    }

    /**
     * Obtém o id do professor.
     *
     * @return O id do professor.
     */
    public long getId() {
        return id;
    }

    /**
     * Define o id do professor.
     *
     * @param id O novo id do professor.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do professor.
     *
     * @return O nome do professor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do professor.
     *
     * @param nome O novo nome do professor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Representação textual do professor.
     *
     * @return Uma string representando o professor.
     */
    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", departamento=" + departamento +
                ", pdisciplinas=" + pdisciplinas +
                '}';
    }
}
