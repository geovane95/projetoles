
package projetoles.web.command;

import CoreAplicacao.Resultado;
import Dominio.EntidadeDominio;


public class ExcluirCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.excluir(entidade);
	}

}
