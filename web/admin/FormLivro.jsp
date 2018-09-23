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
                Livro livro = (Livro) resultado.getEntidades().get(0);
                Usuario usuario = (Usuario) session.getAttribute("usuario");
	%>
        <%
        if(livro == null){
                request.getRequestDispatcher("ConsultaLivro?operacao=CONSULTAR").forward(request, response);
            }  
        if(init==null)
        {
            request.getRequestDispatcher("FormLivro?operacao=CONSULTAR").forward(request, response);
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
        <%
        //out.print(session.getAttribute("menu").toString());
        %>
        <div id="menucliente"></div>
        <div class="container-fluid">
	<form action="LivroOperacao" method="post">
                <label for="txtId">  
                     ID: 
                </label>	
		<input type="text" id="txtId" name="txtId" value=		
		 <%		
                    if(livro != null) out.print("'"+livro.getId()+"' readonly='readonly'>"); 
                    else out.print("' readonly='readonly'>");
                 %>		
		</input>
		</br> 		
		<label for="txtTitulo">Titulo:</label>
		<input type="text" id="txtTitulo" name="txtTitulo" value=
		
		<%		
			if(livro != null) 
				out.print("'"+livro.getTitulo()+"'>"); 
			else 
				out.print(">"); 		
		%>
		
		</input>
		</br>
		<label for="txtQuantidade">Quantidade:</label>
		<input type="text" id="txtQtd" name="txtQuantidade" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getQuantidade()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
                </br>
                <label for="txtISBN">ISBN:</label>
		<input type="text" id="txtISBN" name="txtISBN" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getISBN()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		 <label for="autor">Autor:</label>
		<input type="text" id="txtAutor" name="txtAutor" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getAutor()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
                 <label for="txtEdicao">Edicao:</label>
		<input type="text" id="txtEdicao" name="txtEdicao" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getEdicao()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		 <label for="txtAno">Ano:</label>
		<input type="text" id="txtAno" name="txtAno" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getAno()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		 <label for="txtSinopse">Sinopse:</label>
		<input type="text" id="txtSinopse" name="txtSinopse" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getSinopse()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
                 <label for="txtnPaginas">Numero de páginas:</label>
		<input type="text" id="txtNumeroDePaginas" name="txtNumeroDePaginas" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getnPaginas()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
                <label for="txtAltura">Altura:</label>
		<input type="text" id="txtAltura" name="txtAltura" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getAltura()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
                <label for="txtLargura">Largura:</label>
		<input type="text" id="txtLargura" name="txtLargura" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getAltura()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		<label for="txtProfundidade">Profundidade:</label>
		<input type="text" id="txtProfundidade" name="txtProfundidade" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getProfundidade()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
		</br>
		<label for="txtPeso">Peso:</label>
		<input type="text" id="txtPeso" name="txtPeso" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getPeso()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
                </br>
                   <label for="txtStatus">Status atual: </br>
                       <%   
                       if(livro.getStatus())
                       {
                            out.print("Ativo <input type='radio' name='txtStatus' value='Ativo' checked='checked'/>");	
                            out.print("Inativo <input type='radio' name='txtStatus' value='Inativo'/>");
                       }
                       else{
                            out.print("Ativo <input type='radio' name='txtStatus' value='Ativo'/>");	
                            out.print("Inativo <input type='radio' name='txtStatus' value='Inativo' checked='checked'/>");
                       }
                       %>
                        </label>
                        </br>
                        <label for="txtPeso">Justificativa inativação:</label>
		<input type="text" id="txtJInativacao" name="txtJInativacao" value=
		 
		<%		
			if(livro != null) out.print("'"+livro.getJInativacao()+"'>"); 
			else out.print(">"); 		
		%>
		
		</input>
                </br>
                </br>
		<label for="txtEditora">
                    Editora:
                </label>
                </br>
                
                <%// só tem uma editora por livro
                    for(LEditora c : init.getEditora()){
                        StringBuilder sb = new StringBuilder();
                        sb.append("<input type='radio' id='idEditora' name='idEditora' value='");
                        sb.append(c.getId());                 
                            if (livro.getEditora().getId() == c.getId()) {
                                    sb.append("' checked='checked");
                                }                        
                        sb.append("'>");
                        sb.append(c.getNome());
                        out.print(sb);
                    }	        
                  %>

		</br>
		<label for="txtCategoria">
                    Categoria:
                </label>
                </br>
                <%
                    for(LCategoria c : init.getCategoria()){
                        StringBuilder sb = new StringBuilder();
                        sb.append("<input type='checkbox' id='idCategoria' name='idCategoria' value='");
                        sb.append(c.getId());
                        sb.append("'");
                        for(LCategoria lc : livro.getCategoria()){
                            if (lc.getId() == c.getId()) {
                                    sb.append(" checked='checked'");
                                }
                        }
                        sb.append(">");
                        sb.append(c.getCategoria());
                        out.print(sb);
                    }	        
                  %>
                  <input type="checkbox" name="teste" value="ON" />
		</br>
		<%	
                 	// esse trecho de codigo ta ferrando tudo
			//if(livro != null){
			//	String dtCadastro = ConverteDate.converteDateString(livro.getDtCadastro());
			//	out.print("<label for='txtDtCadastro'>Data de Cadastro:</label>");
			//	out.print("<input type='text' id='txtDtCadastro' name='txtDtCadastro' value='"+dtCadastro+"' readonly>");
			//}	
		
		%>
		
		</input>
		
		
		<%		
			if(livro != null) {
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