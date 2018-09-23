
package projetoles.web.viewhelper;

import projetoles.dominio.*;
import projetoles.nucleo.aplicacao.Resultado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class LivroViewHelper implements iViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Livro livro = null;
		// o get parameter funciona com o atributo name, e não com o id.
		if(!operacao.equals("VISUALIZAR")){
			String Titulo = request.getParameter("txtTitulo");
			String id = request.getParameter("txtId");
                        String isbn = request.getParameter("txtISBN");
                        String autor = request.getParameter("txtAutor");
                        String edicao = request.getParameter("txtEdicao");
                        String ano = request.getParameter("txtAno");
                        String sinopse = request.getParameter("txtSinopse");
                        String nPaginas = request.getParameter("txtNumeroDePaginas");
                        String altura = request.getParameter("txtAltura");
                        String largura = request.getParameter("txtLargura");
                        String profundidade = request.getParameter("txtProfundidade");
                        String peso = request.getParameter("txtPeso");
                        String precoCompra = request.getParameter("txtPrecoCompra");
                        String precoVenda = request.getParameter("txtPrecoVenda");
                        String status = request.getParameter("txtStatus");
                        String quantidade = request.getParameter("txtQuantidade");
                        String[] editora = request.getParameterValues("idEditora");      
                        String[] categoria = request.getParameterValues("idCategoria");
                        InitPagina cl = (InitPagina) request.getSession().getAttribute("init");
			//String dtCadastro = request.getParameter("txtDtCadastro");
                        if(cl == null)
                        {
                         CrudLivroDAO crud = new CrudLivroDAO();
                         cl = (InitPagina)crud.consultar(new EntidadeDominio()).get(0);
                        }                        
			livro = new Livro();			
			if(Titulo != null && !Titulo.trim().equals("")){
				livro.setTitulo(Titulo.toUpperCase());
			}
                        
                        if(isbn != null && !isbn.trim().equals("")){
				livro.setISBN(isbn);
			}
                        if(id != null && !id.trim().equals("")){
				livro.setId(Integer.parseInt(id));
			}
                        if(ano != null && !ano.trim().equals("")){
				livro.setAno(Integer.parseInt(ano));
			}
			if(autor != null && !autor.trim().equals("")){
				livro.setAutor(autor.toUpperCase());
			}
                        if(edicao != null && !edicao.trim().equals("")){
				livro.setEdicao(edicao);
			}
                        if(sinopse != null && !sinopse.trim().equals("")){
				livro.setSinopse(sinopse.toUpperCase());
			}
                        if(nPaginas != null && !nPaginas.trim().equals("")){
				livro.setnPaginas(Integer.parseInt(nPaginas));
			}
                        if(altura != null && !altura.trim().equals("")){
				livro.setAltura(Double.parseDouble(altura));
			}
                        if(largura != null && !largura.trim().equals("")){
				livro.setLargura(Double.parseDouble(largura));
			}
                        if(profundidade != null && !profundidade.trim().equals("")){
				livro.setProfundidade(Double.parseDouble(profundidade));
			}
                        if(peso != null && !peso.trim().equals("")){
				livro.setPeso(Double.parseDouble(peso));
			}
                        if(quantidade != null && !quantidade.trim().equals("")){
				livro.setQuantidade(Integer.parseInt(quantidade));
			}else{
                          livro.setQuantidade(1);
                          }
                         if(status != null && !status.trim().equals("")){
                             if(status.equals("Ativo"))
                             {
                             livro.setStatus(true);
                             }
                             else
                            {
                                livro.setStatus(false);
                            }
                         }else livro.setStatus(false);
                        if(editora != null){
                            for(LEditora le: cl.getEditora()){
                                if(le.getId()==Integer.parseInt(editora[0]))
                                livro.setEditora(le);
                            }
			}
                        if(categoria != null)
                        {
                            // cl contem todas as categorias existentes
                            livro.setCategoria(new ArrayList<LCategoria>());
                            for (int i = 0; i < categoria.length; i++) 
                            {
                                    LCategoria ca = new LCategoria();
                                    ca.setId(Integer.parseInt(categoria[i]));
                                    livro.getCategoria().add(ca);
                            }
                        } 
		}
                else // se a operacao for visualizar
                {                   
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			int id=0;
			if(txtId != null && !txtId.trim().equals("")){
				id = Integer.parseInt(txtId);
			}
			for(EntidadeDominio e: resultado.getEntidades()){
				if(e.getId() == id){
					livro = (Livro)e;
				}
			}
		}
		return livro;
	}

	
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response)  throws IOException, ServletException {
		RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
                request.getSession().setAttribute("resultado", resultado); 
		
		if(!operacao.equals("VISUALIZAR")){
                       d = request.getRequestDispatcher("ConsultaLivro.jsp"); 
                }
                else{
                    if(request.getRequestURI().equals("/Livraria/Loja/LojaOperacao"))
                    {
                        d = request.getRequestDispatcher("LivroInformacoes.jsp");
                    }
                    if(request.getRequestURI().equals("/Livraria/Admin/LivroOperacao"))
                    {
                       d = request.getRequestDispatcher("FormLivro.jsp"); 
                    }
                }
		d.forward(request,response); 
		
	}

}
