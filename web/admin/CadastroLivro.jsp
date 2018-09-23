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
            request.getRequestDispatcher("CadastroLivro?operacao=CONSULTAR").forward(request, response);
        }
        if(usuario==null)
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(!usuario.isLogado())
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        
        %>
       <div id="menucliente"></div>
       <div class="container-fluid">

        <form action="LivroOperacao" method="post">
		<label for="Titulo">Titulo:</label>
		<input type="text" id="txtTitulo" name="txtTitulo"/>
		<br />
		<label for="isbn">ISBN:</label>
		<input type="text" id="txtISBN" name="txtISBN"/>
		<br />	
                <label for="autor">Autor:</label>
		<input type="text" id="txtAutor" name="txtAutor"/>
		<br />
                <label for="edicao">Edição:</label>
		<input type="text" id="txtEdicao" name="txtEdicao"/>
		<br />
                <label for="ano">Ano:</label>
		<input type="text" id="txtAno" name="txtAno"/>
		<br />
                <label for="sinopse">Sinopse:</label>
		<input type="text" id="txtSinopse" name="txtSinopse"/>
		<br />
                <label for="nPaginas">Número de paginas:</label>
		<input type="text" id="txtNumeroDePaginas" name="txtNumeroDePaginas"/>
		<br />
                <label for="altura">Altura:</label>
		<input type="text" id="txtAltura" name="txtAltura"/>
		<br />
                <label for="largura">Largura:</label>
		<input type="text" id="txtLargura" name="txtLargura"/>
		<br />
                <label for="profundidade">Profundidade:</label>
		<input type="ext" id="txtProfundidade" name="txtProfundidade"/>
		<br />
                 <label for="peso">Peso:</label>
		<input type="text" id="txtPeso" name="txtPeso"/>
		<br />
                <label for="quantidade">Quantidade:</label>
		<input type="text" id="txtQuantidade" name="txtQuantidade"/>
		<br />
                 Categoria: </br>
                    <%
                    for (int i = 0; i < init.getCategoria().size(); i++) {
                            init.getCategoria().get(i);                                
                            out.print("<input type='checkbox' id='idCategoria' name = 'idCategoria' value='"+init.getCategoria().get(i).getId()+"'>"+init.getCategoria().get(i).getCategoria());				
			}	        
                    %>
                    </br> Editora: </br>
                    <%
                    for (int i = 0; i < init.getEditora().size(); i++) {
                            init.getEditora().get(i);                                
                            out.print("<input type='radio' id='txtEditora' name = 'idEditora' value='"+init.getEditora().get(i).getId()+"'>"+init.getEditora().get(i).getNome());				
			}	        
                    %>
                    </br>
		 <label for="txtStatus">Status: </br>
                     Ativo <input type="radio" name="txtStatus" value="Ativo" checked="checked"/></br>	
                     Inativo <input type="radio" name="txtStatus" value="Inativo" checked=""/>
                </label>
                </br>
                    
		<input type="submit" id="operacao" name="operacao" value="SALVAR"/>
	</form>
    </div>
    <div id="rodape"></div>

    </body>
    <script src="../se/jscript/menuunico.js"></script>
</html>
