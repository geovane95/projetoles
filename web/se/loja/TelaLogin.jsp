<%@page import="Dominio.Usuario"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="Dominio.InitPagina"%>
<%@page import="CoreAplicacao.Resultado"%>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="import" href="../TodasAsImports.html">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                Resultado resultado = (Resultado) session.getAttribute("resultado");
                InitPagina init = (InitPagina) session.getAttribute("init");
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                String destino = (String)request.getAttribute("destino");
                if(destino!=null)
                {
                    request.setAttribute("destino", destino);
                }
	%>
        <%
        if(init==null)
        {
		request.getRequestDispatcher("TelaLogin?operacao=CONSULTAR").forward(request, response);
	}   
        if(usuario==null)
        {
		request.getRequestDispatcher("TelaLogin?operacao=CONSULTAR").forward(request, response);
	}   
        if(usuario.isLogado())
        {
            request.getRequestDispatcher("Loja?operacao=CONSULTAR").forward(request, response);
        }
	        
	%>
        <div id="menucliente"></div>
        <%
        if(resultado!=null)
            if(resultado.getMsg()!=null)out.print(resultado.getMsg());
        %>
        <div id="actions" class="row container-fluid">
             <hr />
          <div class="col">
              <h1>LOGIN</h1>
                <form action="TelaLoginOperacao">
                    <div class="form-group col-6">
                      <label for="exampleInputEmail1">NOME</label>
                      <input type="email" class="form-control" id="txtUsuario" name="txtUsuario">
                      <small id="emailHelp" class="form-text text-muted">Nome de usuario Email</small>
                    </div>
                    <div class="form-group col-6">
                      <label for="exampleInputPassword">SENHA</label>
                      <input type="password" class="form-control" id="txtSenhaL" name="txtSenhaL">
                    </div>
                    <div class="form-check">
                      <input type="checkbox" class="form-check-input" id="exampleCheck1">
                      <label class="form-check-label" for="exampleCheck1">Mantenha me conectado</label>
                    </div>
                    <button type="submit" class="btn btn-primary" name="operacao" value="CONSULTAR">Submit</button>
                  </form>
            </div>
          <div class="col">
             <!--cadastro de cliente na mesma tela-->
            <h1>CADASTRO</h1>
            <form action="ClienteOperacao" method="post">
            <!-- area de campos do form -->
                    <div class="form-group col-6">
                      <label for="txtNome">Nome</label>
                      <input type="text" class="form-control" id="txtNome" name="txtNome">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtCep">CPF - 11 digitos</label>
                      <input type="text" class="form-control" id="txtCpf" name="txtCpf">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtCep">CEP</label>
                      <input type="text" class="form-control" id="txtCep" name="txtCep">
                    </div>
                    <div class="form-group col-3">
                      <label for="txtNumero">N°</label>
                      <input type="text" class="form-control" id="txtNumero" name="txtNumero">
                    </div>
                    <div class="form-group col-3">
                      <label for="txtComplemento">Complemento</label>
                      <input type="text" class="form-control" id="txtNumero" name="txtComplemento">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtTel">Telefone - 11 digitos</label>
                      <input type="text" class="form-control" id="txtTel" name="txtTelefone">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtEmail1">Email</label>
                      <input type="email" class="form-control" id="txtEmail" name="txtEmail">
                    </div>
                     <div class="form-group col-6">
                      <label for="exampleInputPassword">SENHA</label>
                      <input type="password" class="form-control" id="txtSenha" name="txtSenha">
                    </div>
                    <div class="form-group col-4">
                        Genero:
                        <select name="txtGenero" class="form-control">
                            <option>Masculino</option>
                            <option>Feminino</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-primary" name="operacao" value="SALVAR">Salvar</button>
                        <a href="index.html" class="btn btn-default">Cancelar</a>
                    </div>
              </form>
          </div>
      </div>
      <div id="rodape"></div>

    </body>
    <script src="../jscript/menuunico.js"></script>
</html>
