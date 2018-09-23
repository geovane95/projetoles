package projetoles.web.controle;


import CoreAplicacao.*;
import Dominio.*;
import WebCommand.*;
import WebViewHelper.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Servlet
 */
//@WebServlet(urlPatterns = {"/Servlet"})

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> MapDeViewHelpers;
	
	
    /**
     * Default constructor. 
     */
    
    public Servlet() {
    	
    	/* Utilizando o command para chamar a fachada e indexando cada command 
    	 * pela opera��o garantimos que esta servelt atender� qualquer opera��o */
    	commands = new HashMap<String, ICommand>();    	
    	commands.put("SALVAR", new SalvarCommand());
    	commands.put("EXCLUIR", new ExcluirCommand());
    	commands.put("CONSULTAR", new ConsultarCommand());
    	commands.put("VISUALIZAR", new VisualizarCommand());
    	commands.put("ALTERAR", new AlterarCommand());    	
    	/* Utilizando o ViewHelper para tratar especifica��es de qualquer tela e indexando 
    	 * cada viewhelper pela url em que esta servlet � chamada no form
    	 * garantimos que esta servelt atender� qualquer entidade */    	
    	MapDeViewHelpers = new HashMap<String, IViewHelper>();
    	/*A chave do mapa � o mapeamento da servlet para cada form que 
    	 * est� configurado no web.xml e sendo utilizada no action do html
    	 */
    	MapDeViewHelpers.put("/Livraria/Admin/TelaLoginAdmin", new InitPaginaViewHelper());
    	MapDeViewHelpers.put("/Livraria/Admin/FormClienteAdmin", new InitPaginaViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/PedidosAdmin", new InitPaginaViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/ConsultaLivro", new InitPaginaViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/ConsultaCliente", new InitPaginaViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/CadastroLivro", new InitPaginaViewHelper());        
        MapDeViewHelpers.put("/Livraria/Admin/FormLivro", new InitPaginaViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/sair", new InitPaginaViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/TelaLoginAdminOperacao", new AdminViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/PedidosOperacaoAdmin", new EmprestimoViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/AdmGeral", new InitPaginaViewHelper());
       	MapDeViewHelpers.put("/Livraria/Admin/ClienteOperacao", new ClienteViewHelper()); //operacao cliente admin
        MapDeViewHelpers.put("/Livraria/Admin/LivroOperacao", new LivroViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/EmprestimoOperacao", new EmprestimoViewHelper());
        MapDeViewHelpers.put("/Livraria/Admin/Fornecedor", new FornecedorViewHelper());



        //vhs.put("/Livraria/Admin/FormConsultarProduto", new ProdutoViewHelper());
    }    
    /** 
     * TODO Descri��o do M�todo
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    		IOException {
    	doProcessRequest(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcessRequest(request, response);
	}	
	protected void doProcessRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			
                //Obtem a uri que invocou esta servlet (na action do form da pagina, é reconhecido na web.xml), serve para definir o objeto
		String uri = request.getRequestURI();
                IViewHelper vh = MapDeViewHelpers.get(uri);              
                //Operacao: SALVAR, ALTERAR, CONSULTAR, VISUALIZAR, EXCLUIR
		String operacao = request.getParameter("operacao");  		
		ICommand command = commands.get(operacao);                
                //Preenche a entidade e valida os caracteres
    		EntidadeDominio entidade =  vh.getEntidade(request);			 
		//Executa o command certo de acordo com a operacao e pega o Resultado
		Resultado resultado = command.execute(entidade);		
		//A View Helper do objeto
		vh.setView(resultado, request, response);
                /*
                Apliquei validações e regras de negócio antes de preencher o objeto,
                pois se colocar caracteres invalidos ele da excessão e trava tudo.
                */	
	}
}
