
package projetoles.web.viewhelper;

import projetoles.dominio.EntidadeDominio;
import projetoles.nucleo.aplicacao.Resultado;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface iViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	
	public void setView(Resultado resultado,
                        HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException;
	
}
