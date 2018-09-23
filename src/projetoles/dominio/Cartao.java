/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoles.dominio;

/**
 *
 * @author Daniel Seiji Seguchi
 */
public class Cartao extends EntidadeDominio{
    private int idCartao;
    private String numero;
    private String bandeira;
    private String validade;
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bandeira
     */
    public String getBandeira() {
        return bandeira;
    }

    /**
     * @param bandeira the bandeira to set
     */
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    /**
     * @return the validade
     */
    public String getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }

    /**
     * @return the idCartao
     */
    public int getIdCartao() {
        return idCartao;
    }

    /**
     * @param idCartao the idCartao to set
     */
    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }
}
