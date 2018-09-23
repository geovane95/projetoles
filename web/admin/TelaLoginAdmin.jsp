<%@page import="Dominio.Administracao"%>
<%@page import="Dominio.Usuario"%>
<%@page import="Dominio.InitPagina"%>
<%@page import="CoreAplicacao.Resultado"%>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="import" href="../se/TodasAsImports.html">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                InitPagina init = (InitPagina) session.getAttribute("init");
                Administracao usuario = (Administracao) session.getAttribute("usuario");
	%>
        <%	
	if(init==null){
		request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
	} 
        if(usuario==null){
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(usuario.isLogado()){
            request.getRequestDispatcher("ConsultaLivro?operacao=CONSULTAR").forward(request, response);
        }
        %>
        <div id="menucliente"></div>
        <div class="container-fluid">
        <div id="actions" class="row">
             <hr />
          <div class="col">
              <h1>LOGIN</h1>
                <form action="TelaLoginAdminOperacao">
                    <div class="form-group col-6">
                      <label for="exampleInputEmail1">NOME</label>
                      <input type="text" class="form-control" id="txtUsuario" name="txtUsuario">
                      <small id="emailHelp" class="form-text text-muted">Nome de usuario</small>
                    </div>
                    <div class="form-group col-6">
                      <label for="exampleInputPassword">SENHA</label>
                      <input type="password" class="form-control" id="txtSenhaL" name="txtSenhaL">
                    </div>
                    <button type="submit" class="btn btn-primary" name="operacao" value="CONSULTAR">Submit</button>
                  </form>
            </div>
      </div>
           <div id="rodape"></div>
    </div>
    </body>
    <script src="../se/jscript/menuunico.js"></script>
</html>
