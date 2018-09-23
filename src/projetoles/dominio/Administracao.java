
package projetoles.dominio;

import java.util.List;

/*
   Essa classe foi criada para facilitar o desenvolvimento das tarefas do
    administrador referentes ao gerenciamento de emprestimos e o gerenciamento de estoque.
    o cadastro e a exclusão de livros e clientes, serão feitas pelas ViewHelpers de Livros e Clientes
    cada pedido pertence a um usuario, um usuario pode ter varios emprestimos
   cada pedido tem estados como entregue ou em transporte por exemplo.
   livros a administracao deve poder alterar a quantidade de livros do estoque
*/public class Administracao extends Usuario{
    private List<Emprestimo> emprestimos;
    private List<Livro> livros;
    private List<Cliente> clientes;

    public Administracao(){
    }
    /**
     * @return the livros
     */
    public List<Livro> getLivros() {
        return livros;
    }

    /**
     * @param livros the livros to set
     */
    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the emprestimos
     */
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    /**
     * @param emprestimos the emprestimos to set
     */
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
