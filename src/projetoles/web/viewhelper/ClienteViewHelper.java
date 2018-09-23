
package projetoles.web.viewhelper;

import projetoles.dominio.Cliente;
import projetoles.dominio.Endereco;
import projetoles.dominio.EntidadeDominio;
import projetoles.nucleo.aplicacao.Resultado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ClienteViewHelper implements iViewHelper {

	/** 
         * Tem que ter uma lsita de cupons de troca também
	 */
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
            String operacao = request.getParameter("operacao");
            Cliente c = new Cliente();
           if(!operacao.equals("VISUALIZAR")){
               c = new Cliente();
               String id = request.getParameter("txtId");
               String nome = request.getParameter("txtNome");
               String email = request.getParameter("txtEmail");
               String rg = request.getParameter("txtRg");
               String cpf = request.getParameter("txtCpf");  
               String telefone = request.getParameter("txtTelefone");
               String genero = request.getParameter("txtGenero");
               String idEndereco[] = request.getParameterValues("IdEndereco");
               String cep[] = request.getParameterValues("txtCep");
               String numero[] = request.getParameterValues("txtNumero");
               String complemento[] = request.getParameterValues("txtComplemento");
               
               if(id!=null&&!id.trim().equals(""))
               c.setId(Integer.parseInt(id));
               if(nome!=null&&!nome.trim().equals(""))
               c.setNome(nome);
               if(cpf!=null&&!cpf.trim().equals(""))
               c.setCpf(cpf);
               if(email!=null&&!email.trim().equals(""))
               c.setEmail(email);    
               if(genero!=null&&!genero.trim().equals(""))
               c.setGenero(genero);
               if(rg!=null&&!rg.trim().equals(""))
               c.setRg(rg);
               if(telefone!=null&&!telefone.trim().equals(""))
               c.setTelefone(telefone);
               // Cadasra todos os enderecos
               c.setEndereco(new ArrayList<Endereco>());
               if(cep!=null){
                   
                   for(int i=0; i<cep.length; i++){
                       c.getEndereco().add(new Endereco());
                       if(idEndereco!=null)
                       c.getEndereco().get(i).setId(Integer.parseInt(idEndereco[i]));
                       if(cep!=null)
                       c.getEndereco().get(i).setCep(cep[i]); 
                       if(numero!=null)
                       c.getEndereco().get(i).setNumero(numero[i]);
                       if(complemento!=null)
                       c.getEndereco().get(i).setComplemento(complemento[i]);
                   }
               }
               
            }
            else{      
                Resultado resultado = (Resultado) request.getSession().getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			int id=0;
			if(txtId != null && !txtId.trim().equals("")){
				id = Integer.parseInt(txtId);
			}
			for(EntidadeDominio e: resultado.getEntidades()){
				if(e.getId() == id){
					c = (Cliente)e;
				}
			}
            }
           return c;
	}
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException{
	RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
                
                //se houver mensagens de erro
                if(resultado.getMsg() != null)
                {
                    request.getSession().setAttribute("resultado", resultado);
                    d = request.getRequestDispatcher("ConsultaCliente.jsp");
                } // se não houver mensagens de erro
                else
                {
                    if(operacao.equals("VISUALIZAR")||operacao.equals("ALTERAR")){
                            request.getSession().setAttribute("resultado", resultado);
                            d= request.getRequestDispatcher("FormCliente.jsp");  			
                    }else{
                        request.getSession().setAttribute("resultado", resultado);
                        d = request.getRequestDispatcher("ConsultaCliente.jsp");
                    }	
                }
                d.forward(request,response); 
            }
        }

