package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.EntidadeDominio;
import Dominio.Livro;

public class ValidadorQtdLivro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Livro){
			Livro c = (Livro)entidade;
			
			if(c.getQuantidade() < 1){
				return "Quantidade deve ser no minimo 1!";
			}
			
		}else{
			return "Quantidade n�o pode ser v�lidado, pois entidade n�o � um produto!";
		}
		
		
		return null;
	}

}
