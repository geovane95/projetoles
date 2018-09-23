/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoles.web.viewhelper;

import CoreAplicacao.Resultado;
import Dominio.EntidadeDominio;
import Dominio.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Daniel Seiji Seguchi
 */
public class LoginViewHelper implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha("txtSenhaL");
        return  usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    }
    
}
