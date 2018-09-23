package projetoles.dominio;

import java.util.List;

public class Fornecedor extends Usuario{

	private String cnpj;
	private List<Endereco> endereco;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

    /**
     * @return the endereco
     */
    public List<Endereco> getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
	
	
	
}
