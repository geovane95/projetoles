package projetoles.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dominio.EntidadeDominio;

/**
 *
 * @author Daniel Seiji Seguchi
 */
public class LEdicao extends EntidadeDominio{
    private int nEdicao;
    
    /**
     * @return the nEdicao
     */
    public int getnEdicao() {
        return nEdicao;
    }

    /**
     * @param nEdicao the nEdicao to set
     */
    public void setnEdicao(int nEdicao) {
        this.nEdicao = nEdicao;
    }
    
}
