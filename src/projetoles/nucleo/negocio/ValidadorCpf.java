package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.Cliente;
import Dominio.EntidadeDominio;

public class ValidadorCpf implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Cliente){
			Cliente c = (Cliente)entidade;
			if(c.getCpf()!=null){
			if(c.getCpf().length() != 11){
				return "CPF deve conter 11 digitos!";
			}
                        }else{
                        return "campo cpf esta vazio";
                        }
			
		}else{
			return "CPF n�o pode ser v�lidado, pois entidade n�o � um cliente!";
		}
		
		
		return null;
	}

}
