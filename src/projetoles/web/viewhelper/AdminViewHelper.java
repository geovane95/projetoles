
package projetoles.web.viewhelper;

import projetoles.dominio.Administracao;
import projetoles.dominio.EntidadeDominio;
import projetoles.dominio.Usuario;
import projetoles.nucleo.aplicacao.Resultado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Essa view helper ira ajudar o administrado a gerenciar o estoque dos livros, a trocar os estados dos pedidos
 * e a alterar os clientes
 */
public class AdminViewHelper implements iViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Usuario adm = (Usuario)request.getSession().getAttribute("usuario");
        Administracao admin = new Administracao();
        String uri = request.getRequestURI();
        String operacao = request.getParameter("operacao");
       
        if(uri.equals("/Livraria/Admin/TelaLoginAdminOperacao")&&operacao.equals("CONSULTAR"))
        {
            admin.setEmail(request.getParameter("txtUsuario"));
            admin.setSenha(request.getParameter("txtSenhaL"));
        }
        else
        {
           if(uri.equals("/Livraria/Admin/PedidosOperacaoAdmin")){
               
           }
        }
        return admin;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String operacao = request.getParameter("operacao");
        RequestDispatcher d = null;
        if(resultado.getMsg() == null && operacao.equals("CONSULTAR"))
        {
                if(request.getRequestURI().equals("/Livraria/Admin/TelaLoginAdminOperacao"))
                {
                    if(resultado.getEntidades().size()>0)
                    {
                        Administracao a = (Administracao)resultado.getEntidades().get(0);
                        a.setLogado(true);
                        request.getSession().setAttribute("usuario", a);
                        d = request.getRequestDispatcher("ConsultaLivro.jsp");
                    }
                    else{
                        resultado.setMsg("Nome ou senha incorretos");
                        request.getSession().setAttribute("resultado", resultado);
                        d = request.getRequestDispatcher("TelaLoginAdmin.jsp");
                    }
                }
                           
        }
        d.forward(request, response);
    }
    
}
