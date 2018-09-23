<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="CoreAplicacao.Resultado, Dominio.*, java.util.*, CoreImplUtil.ConverteDate"%>

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
        Administracao usuario = (Administracao)session.getAttribute("usuario");
        if(init == null)
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(usuario==null){
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(!usuario.isLogado())
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        %>
       <div id="menucliente"></div>
       <div class="container-fluid">
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
                      <label for="txtRg">RG</label>
                      <input type="text" class="form-control" id="txtCpf" name="txtRg">
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
    <div id="rodape"></div>

    </body>
    <script src="../se/jscript/menuunico.js"></script>
</html>
