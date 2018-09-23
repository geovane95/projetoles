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
public class EmprestimoGeral extends EntidadeDominio{
    private List<Emprestimo> listaEmprestimos;

    /**
     * @return the listaEmprestimos
     */
    public List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    /**
     * @param listaEmprestimos the listaEmprestimos to set
     */
    public void setListaEmprestimos(List<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

   
}
