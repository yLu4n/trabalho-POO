/**
 * A interface `IBase` define métodos para obter informações essenciais relacionadas ao sistema de reserva de laboratórios da Ucsal.
 * Implementada pela classe `Base` para garantir a consistência na obtenção de dados.
 *
 * @author Guilherme Souza e Matheus Requiao
 * @version 1.0
 * @since 25/11/2023
 */
package application;

import entities.*;

import java.util.List;

// Última atualização: 12:58 pm (21/11/2023)
public interface IBase {
    /**
     * Obtém a lista de laboratórios.
     *
     * @return Lista de laboratórios.
     */
    List<Laboratorio> getLaboratorios();

    /**
     * Obtém a lista de departamentos.
     *
     * @return Lista de departamentos.
     */
    List<Departamento> getDepartamentos();

    /**
     * Obtém a lista de professores.
     *
     * @return Lista de professores.
     */
    List<Professor> getProfessores();

    /**
     * Obtém a lista de disciplinas.
     *
     * @return Lista de disciplinas.
     */
    List<Disciplina> getDisciplinas();

    /**
     * Obtém a lista de alunos com base na quantidade desejada e na posição de início especificada.
     *
     * @param qtde   Quantidade de alunos desejada.
     * @param inicio Posição de início para a geração de alunos.
     * @return Lista de alunos.
     */
    List<Aluno> getAlunos(int qtde, int inicio);

    /**
     * Exibe as informações da base de dados da UCSAL, incluindo disciplinas, professores e departamentos.
     */
    void BasePrint();
}