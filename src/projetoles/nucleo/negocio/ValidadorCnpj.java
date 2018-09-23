package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.EntidadeDominio;
import Dominio.Fornecedor;

public class ValidadorCnpj implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Fornecedor){
			Fornecedor fornecedor = (Fornecedor)entidade;
			
			if(fornecedor.getCnpj().length() < 14){
				return "CNPJ deve conter 14 digitos!";
			}
			
		}else{
			return "CNPJ n�o pode ser v�lidado, pois entidade n�o � um fornecedor!";
		}
		
		
		return null;
	}

}
