package projetoles.web.viewhelper;

import CoreAplicacao.Resultado;
import Dominio.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
   Essa classe se parece com um carrinho tendo uma lista de pedidos a ser gerenciada
   A diferença é que ela serve apenas para o cliente visualizar o estado do pedido (despachado, em transporte,
   entregue, em devolucao) e solicitar alguma ação como solicitar devolução.
 */
public class EmprestimoViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
                    
                    String operacao = request.getParameter("operacao");

                    if(operacao.equals("VISUALIZAR")){
                        // lista de emprestimos na session
                        EmprestimoGeral eGeral = (EmprestimoGeral)request.getSession().getAttribute("ListaEmprestimo");
                        List<Emprestimo> lEmprestimo = eGeral.getListaEmprestimos();
                        // Emprestimo
                        Emprestimo emp = null;
                            String txtId = request.getParameter("txtIdEmprestimo");
                            int id=0;
                            if(txtId != null && !txtId.trim().equals("")){
                                    id = Integer.parseInt(txtId);
                            }
                            for(Emprestimo e: lEmprestimo)
                            {
                                if(e.getId()==id){
                                    emp = e;
                                }
                            }
                            return emp;
                       
                    }
                    else
                    {
                        Emprestimo emp = new Emprestimo();
                        emp.setCliente(new Cliente());
                        emp.setLivro(new Livro());
                        String idEmprestimo = null;
                        String status = "";
                        if(operacao.equals("SALVAR"))
                        {
                            // o primeiro status sempre será emprestado
                            status = "EMPRESTADO";
                        }
                        else
                        {// caso seja alterar ou excluir                            
                            idEmprestimo = request.getParameter("txtIdEmprestimo");
                            status = request.getParameter("status");
                        }
                        String idLivro = request.getParameter("txtIdLivro");
                        String idCliente = request.getParameter("txtIdCliente");
                        String idBibliotecaEmprestimo = request.getParameter("biblioEmprestimo");
                        if(idLivro!=null&&!idLivro.trim().equals(""))
                        {
                            emp.getLivro().setId(Integer.parseInt(idLivro));
                        }
                        if(idCliente!=null&&!idCliente.trim().equals(""))
                        {
                            emp.getCliente().setId(Integer.parseInt(idCliente));
                        }
                        if(idBibliotecaEmprestimo!=null&&!idBibliotecaEmprestimo.trim().equals(""))
                        emp.setIdBibliotecaEmprestimo(Integer.parseInt(idBibliotecaEmprestimo));
                        if(status!=null&&status.trim().equals(""))
                        emp.setStatus(status);

                        return emp;
                    }
        }
        // tem que corrigir
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException{
                RequestDispatcher d=null;
                String operacao = request.getParameter("operacao");
                request.getSession().setAttribute("resultado", resultado); 
		
		if(operacao.equals("VISUALIZAR")||operacao.equals("ALTERAR")){
                     d = request.getRequestDispatcher("FormEmprestimo.jsp"); 
                }
                else
                {
                    if(resultado.getEntidades().size()==0){
                    resultado.setMsg("Não foram encontrados emprestimos com estes filtros");
                    }
                    d = request.getRequestDispatcher("ConsultaEmprestimo.jsp"); 
                }
		d.forward(request,response);
        }
}
