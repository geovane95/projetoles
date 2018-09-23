/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoles.dominio;

import java.util.List;

/**
 *
 * @author Daniel Seiji Seguchi
 */
public class Carrinho extends EntidadeDominio{
    private List<Emprestimo> lPedido;

    /**
     * @return the lPedido
     */
    public List<Emprestimo> getlPedido() {
        return lPedido;
    }
    /**
     * @param lPedido the lPedido to set
     */
    public void setlPedido(List<Emprestimo> lPedido) {
        this.lPedido = lPedido;
    }
}
