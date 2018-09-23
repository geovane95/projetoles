
package projetoles.web.viewhelper;

import CoreAplicacao.Resultado;
import Dominio.Endereco;
import Dominio.EntidadeDominio;
import Dominio.Fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtRzSocial");
		String cnpj = request.getParameter("txtCnpj");
		String cep = request.getParameter("txtCep");		
		String numero = request.getParameter("txtNumero");
		Fornecedor f = new Fornecedor();
		if(id !=null && !id.trim().equals(""))
			f.setId(Integer.parseInt(id));
		
		f.setNome(nome);
		f.setEndereco(new ArrayList<Endereco>());
		f.getEndereco().get(0).setNumero(numero);
		f.getEndereco().get(0).setCep(cep);
		f.setCnpj(cnpj);
		return f;
	}

	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response) {
            try {
                PrintWriter out = response.getWriter();
                out.println("<html>");
                  out.println("<body>");
                  out.println("teste fornecedor com sucesso");
                  out.println("</body>");
                  out.println("</html>");
            } catch (IOException ex) {
                Logger.getLogger(FornecedorViewHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}
