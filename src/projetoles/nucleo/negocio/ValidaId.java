/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.EntidadeDominio;

/**
 *
 * @author Daniel Seiji Seguchi
 */
public class ValidaId implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        try
        {
            
        }catch(NumberFormatException e)
        {
            return "id inválido!!!";
        }
        return null;
       }
    
}
