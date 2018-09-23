package projetoles.dominio;

public class Endereco extends EntidadeDominio{

	private String numero;
	private String cep;
        private boolean endereco_entrega;
        private String complemento;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the endereco_entrega
     */
    public boolean isEndereco_entrega() {
        return endereco_entrega;
    }

    /**
     * @param endereco_entrega the endereco_entrega to set
     */
    public void setEndereco_entrega(boolean endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }
}
