package projetoles.nucleo.negocio;

import CoreInterface.IStrategy;
import Dominio.EntidadeDominio;
import Dominio.Fornecedor;

public class ValidadorDadosObrigatoriosFornecedor implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Fornecedor){
			Fornecedor fornecedor = (Fornecedor)entidade;
			
			String nome = fornecedor.getNome();
			String cnpj = fornecedor.getCnpj();
			
			
			if(nome.trim().equals("") || fornecedor.getEndereco().get(0).getCep().trim().equals("") || 
					cnpj.trim().equals("")|| fornecedor.getEndereco().get(0).getNumero().trim().equals("")){
				return "Nome, logradouro, CNPJ e cidade s�o de preenchimento obrigat�rio!";
			}
			
		}else{
			return "Deve ser registrado um fornecedor!";
		}
		
		
		return null;
	}

}
