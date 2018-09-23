
package projetoles.web.command;

import projetoles.nucleo.controle.Fachada;
import projetoles.nucleo.iFachada;


public abstract class AbstractCommand implements iCommand {

	protected iFachada fachada = new Fachada();

}
