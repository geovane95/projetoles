
package projetoles.dominio;

import java.util.List;

public class Livro extends EntidadeDominio {

	private String Titulo;
        private String ISBN;
	private Integer Quantidade;
        private Integer Ano;
        private String Autor;
        private String JInativacao;
        private String Sinopse;
        private List<LCategoria> Categoria;
        private String Edicao;
        private LEditora Editora;        
        private Double PrecoCompra; 
        private Double PrecoVenda;
        private Double Altura;
        private Double Largura;
        private Double Profundidade;
        private Double Peso;
        private Integer nPaginas;
        private Boolean Status;

	    
	public int getQuantidade() {
		return Quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.Quantidade = quantidade;
	}    
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getEdicao() {
        return Edicao;
    }
    public void setEdicao(String Edicao) {
        this.Edicao = Edicao;
    }
    public List<LCategoria> getCategoria() {
        return Categoria;
    }
    public void setCategoria(List<LCategoria> Categoria) {
        this.Categoria = Categoria;
    }
    public Double getAltura() {
        return Altura;
    }
    public void setAltura(Double Altura) {
        this.Altura = Altura;
    }
    public LEditora getEditora() {
        return Editora;
    }
    public void setEditora(LEditora Editora) {
        this.Editora = Editora;
    }
    public Double getLargura() {
        return Largura;
    }
    public void setLargura(Double Largura) {
        this.Largura = Largura;
    }
    public Double getProfundidade() {
        return Profundidade;
    }
    public void setProfundidade(Double Comprimento) {
        this.Profundidade = Comprimento;
    }
    public Double getPeso() {
        return Peso;
    }
    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    public Integer getAno() {
        return Ano;
    }
    public void setAno(Integer Ano) {
        this.Ano = Ano;
    }
    public String getSinopse() {
        return Sinopse;
    }
    public void setSinopse(String Sinopse) {
        this.Sinopse = Sinopse;
    }
   
    public Integer getnPaginas() {
        return nPaginas;
    }
    public void setnPaginas(Integer nPaginas) {
        this.nPaginas = nPaginas;
    }
    public Boolean getStatus() {
        return Status;
    }
    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    /**
     * @return the JInativacao
     */
    public String getJInativacao() {
        return JInativacao;
    }

    /**
     * @param JInativacao the JInativacao to set
     */
    public void setJInativacao(String JInativacao) {
        this.JInativacao = JInativacao;
    }

    /**
     * @return the PrecoCompra
     */
    public Double getPrecoCompra() {
        return PrecoCompra;
    }

    /**
     * @param PrecoCompra the PrecoCompra to set
     */
    public void setPrecoCompra(Double PrecoCompra) {
        this.PrecoCompra = PrecoCompra;
    }

    /**
     * @return the PrecoVenda
     */
    public Double getPrecoVenda() {
        return PrecoVenda;
    }

    /**
     * @param PrecoVenda the PrecoVenda to set
     */
    public void setPrecoVenda(Double PrecoVenda) {
        this.PrecoVenda = PrecoVenda;
    }
}
