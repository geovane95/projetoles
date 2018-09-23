<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="CoreAplicacao.Resultado, Dominio.*, java.util.*, CoreImplUtil.ConverteDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' type='text/css' href='cssmenu.css'>
<link rel="import" href="../se/TodasAsImports.html">
<title>:::: Visualizar Livro::::</title>
</head>
<body>
        <%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
                InitPagina init = (InitPagina) session.getAttribute("init");
                Administracao usuario = (Administracao) session.getAttribute("usuario");
                Emprestimo emp = null;
	%>
        <% 
        if(init==null)
        {
            request.getRequestDispatcher("FormEmprestimo?operacao=CONSULTAR").forward(request, response);
        }
        if(usuario==null)
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(!usuario.isLogado())
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        } 
        if(resultado!=null)
        if(resultado.getEntidades().get(0).getClass()==Emprestimo.class)
        {
            emp = (Emprestimo)resultado.getEntidades().get(0);
        }
        %>
        <div id="menucliente"></div>
        <div class="container-fluid">
	<form action="EmprestimoOperacao" method="post">
                <label for="txtIdEmprestimo">  
                     ID: 
                </label>	
		<input type="text" id="txtId" name="txtIdEmprestimo" value=		
		 <%		
                    if(emp != null) out.print("'"+emp.getId()+"' readonly='readonly'>"); 
                    else out.print(">");
                 %>		
		</input>
		</br> 		
		<label for="txtIdCliente">Id Cliente:</label>
		<input type="text" id="txtIdCliente" name="txtIdCliente" value=
		
		<%		
			if(emp != null) 
				out.print("'"+emp.getCliente().getId()+"'readonly='readonly'>"); 
			else 
				out.print(" >"); 		
		%>
		
		</input>
		</br>
		<label for="txtNomeCliente">Nome cliente</label>
		<input type="text" id="txtNomeCliente" name="txtNomeCliente" value=
		 
		<%		
			if(emp != null) out.print("'"+emp.getCliente().getNome()+"' readonly='readonly'>"); 
			else out.print(">"); 		
		%>
		
		</input>
                </br>
                <label for="txtIdLivro">Id livro:</label>
		<input type="text" id="txtIdLivro" name="txtIdLivro" value=
		 
		<%		
			if(emp != null) out.print("'"+emp.getLivro().getId()+"' readonly='readonly'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		 <label for="txtTituloLivro">Titulo Livro:</label>
		<input type="text" id="txtTituloLivro" name="txtTituloLivro" value=
		 
		<%		
			if(emp != null) out.print("'"+emp.getLivro().getTitulo()+"' readonly='readonly'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		<%		
			if(emp != null) {
				out.print("<input type='submit' id='operacao' name='operacao' value='ALTERAR'/>");	
				out.print("<input type='submit' id='operacao' name='operacao' value='EXCLUIR'/>");	
			}else{
				out.print("<input type='submit' id='operacao' name='operacao' value='SALVAR'/>");
			}				
		%>
	</form>
        
        </div>
           <div id="rodape"></div>

</body>
<script src="../se/jscript/menuunico.js"></script>
</html>