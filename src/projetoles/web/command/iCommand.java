
package projetoles.web.command;

import projetoles.dominio.EntidadeDominio;
import projetoles.nucleo.aplicacao.Resultado;


public interface iCommand {

	public Resultado execute(EntidadeDominio entidade);
	
}
