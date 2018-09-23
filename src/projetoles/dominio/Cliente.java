
package projetoles.dominio;

import java.util.List;


/**
 * 
 * nas operacoes que se seguem, o cliente pode ter varios pedidos.
 * cada pedido tem um tipo, que pode ser compra, ou devolução
 * a troca é tratada compra, na qual, ao devolver, o cliente ganha um cupom de troca
 * 
 * o tipo do usuario é feito na propria classe
 */
public class Cliente extends Usuario {
	private String cpf;
        private String genero;
        private String telefone;
        private String rg;
        private List<Endereco> endereco;

        public Cliente(){
        }
	/**
	 * M�todo de recupera��o do campo cpf
	 *
	 * @return valor do campo cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Valor de cpf atribu�do a cpf
	 *
	 * @param cpf Atributo da Classe
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    
    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.telefone = Telefone;
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

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }
}
