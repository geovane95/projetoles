
package projetoles.web.viewhelper;

import projetoles.dominio.Administracao;
import projetoles.dominio.EntidadeDominio;
import projetoles.dominio.InitPagina;
import projetoles.nucleo.aplicacao.Resultado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Classe gambis para pegar a lista de categorias, em breve, terá todos os atributos 
//dos livros, que precisam ser consultadas no banco

public class InitPaginaViewHelper implements iViewHelper {
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		InitPagina init = new InitPagina();
		return init;
	}

	
	public void setView(Resultado resultado, HttpServletRequest request,
                        HttpServletResponse response)  throws IOException, ServletException {
                        RequestDispatcher d=null;
                        Administracao usuario = (Administracao)request.getSession().getAttribute("usuario");
                        if(usuario==null){
                            usuario = new Administracao();
                            usuario.setLogado(false);
                        }
			
                        //d= request.getRequestDispatcher("FormConsultaLivro.jsp");
                        String splits[] = request.getRequestURI().split("/");
                        String uri = splits[3];
                        
                        d=request.getRequestDispatcher(uri+".jsp");
                        
                        if(splits[3].equals("sair"))
                        {
                            d = request.getRequestDispatcher("TelaLoginAdmin.jsp");
                            usuario = new Administracao();
                            usuario.setLogado(false);
                        }
                        request.getSession().setAttribute("init", resultado.getEntidades().get(0));  
                        request.getSession().setAttribute("usuario", usuario);
                        d.forward(request,response); 
	}
}