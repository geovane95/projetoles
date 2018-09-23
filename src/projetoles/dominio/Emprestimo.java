/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoles.dominio;

/**
 * livro - contém o livro do pedido
 * quantidade - a quantidade em transação deste livro
 * tipo - se é compra ou devolucao
 * estado - despachado, em transporte, entregue, em devolucao
 * usuario - o responsavel pelo pedido
 * obs: o cliente pode ter varios pedidos em um mesmo carrinho
 */
public class Emprestimo extends EntidadeDominio{

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    private Livro livro;
    private Cliente cliente;
    private int idBibliotecaEmprestimo;
    private int idBibliotecaDevolucao;
    private String status;
    
    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the idBibliotecaEmprestimo
     */
    public int getIdBibliotecaEmprestimo() {
        return idBibliotecaEmprestimo;
    }

    /**
     * @param idBibliotecaEmprestimo the idBibliotecaEmprestimo to set
     */
    public void setIdBibliotecaEmprestimo(int idBibliotecaEmprestimo) {
        this.idBibliotecaEmprestimo = idBibliotecaEmprestimo;
    }

    /**
     * @return the idBibliotecaDevolucao
     */
    public int getIdBibliotecaDevolucao() {
        return idBibliotecaDevolucao;
    }

    /**
     * @param idBibliotecaDevolucao the idBibliotecaDevolucao to set
     */
    public void setIdBibliotecaDevolucao(int idBibliotecaDevolucao) {
        this.idBibliotecaDevolucao = idBibliotecaDevolucao;
    }
    
}
