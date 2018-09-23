package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.EntidadeDominio;
import Dominio.Livro;

public class ValidadorISBN implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Livro){
			Livro livro = (Livro)entidade;
			
			if(livro.getISBN().length() < 13){
				return "CNPJ deve conter 13 digitos!";
			}
			
		}else{
			return "ISBN n�o pode ser v�lidado, pois entidade n�o � um livro!";
		}
		
		
		return null;
	}

}
