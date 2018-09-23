
package projetoles.web.command;

import projetoles.dominio.EntidadeDominio;
import projetoles.nucleo.aplicacao.Resultado;


public class VisualizarCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.visualizar(entidade);
	}

}
