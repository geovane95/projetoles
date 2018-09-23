/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.Cliente;
import Dominio.EntidadeDominio;

/**
 *
 * só valida a quantidade de numeros para o telefone
 */
public class ValidaTelefone implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente)entidade;
        if(cliente.getTelefone().length()>11)     
            return "Telefone deve possuir no maximo 11 numeros";
        return null;
    }
}
