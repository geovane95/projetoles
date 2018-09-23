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
public class Cupom extends EntidadeDominio{
    private int idCupom;
    private int idCliente;
    private Double valor;
    private String estado;

    /**
     * @return the idCupom
     */
    public int getIdCupom() {
        return idCupom;
    }

    /**
     * @param idCupom the idCupom to set
     */
    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
