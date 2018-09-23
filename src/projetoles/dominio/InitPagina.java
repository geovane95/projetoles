
package projetoles.dominio;

import java.util.List;

public class InitPagina extends EntidadeDominio {

        private List<LCategoria> Categoria;
        private List<LEditora> Editora;  
        
   
    /**
     * @return the Categoria
     */
    public List<LCategoria> getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(List<LCategoria> Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return the Editora
     */
    public List<LEditora> getEditora() {
        return Editora;
    }

    /**
     * @param Editora the Editora to set
     */
    public void setEditora(List<LEditora> Editora) {
        this.Editora = Editora;
    }
	
}
