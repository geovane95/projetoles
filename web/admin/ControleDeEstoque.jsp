<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="CoreAplicacao.Resultado, Dominio.*, java.util.*, CoreImplUtil.ConverteDate"%>
<!--< jsp:forward page="CrudLivro?operacao=CONSULTAR" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<META http-equiv="Content-Type" content="text/html" charset="UTF-8">
<link rel="import" href="../se/TodasAsImports.html">
<title>:::: CONSULTAR LIVRO::::</title>
</head>
<body>
	<%
                Resultado resultado = (Resultado) session.getAttribute("resultado");
                InitPagina init = (InitPagina) session.getAttribute("init");
                Usuario usuario = (Usuario)session.getAttribute("usuario");
                Administracao adm = null;
	%>
        <%	
	if(init==null)
        {
            request.getRequestDispatcher("ConsultaLivro?operacao=CONSULTAR").forward(request, response);
	}
        if(usuario==null)
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(!usuario.isLogado())
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(usuario.getClass()!=Administracao.class)
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        else{
        adm = (Administracao)usuario;
        }
	%>
        <div id="menucliente"></div> 
        Cadastro e controle de estoque
        <div class="container-fluid">
	<form action="LivroOperacao" method="post">
		<label for="txtId">Id:</label> 
                <input type="text" id="txtId" name="txtId" /></br> 
		<label for="txtTitulo">Titulo:</label> 
                <input type="text" id="txtTitulo" name="txtTitulo" /> </br>
                <label for="txtPreco">Preco:</label> 
                <input type="text" id="txtTitulo" name="txtPreco" /> </br>
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
                            out.print("<input type='radio' id='idEditora' name = 'idEditora' value='"+init.getEditora().get(i).getId()+"' checked=''>"+init.getEditora().get(i).getNome());				
			}	        
                    %>
                    
                <input type="submit" id="operacao" name="operacao" value="CONSULTAR" />
	</form>

	<%	
	if(resultado !=null && resultado.getMsg() != null){
		out.print(resultado.getMsg());
	}        
	%>
<BR>

<TABLE BORDER="5"    WIDTH="50%"   CELLPADDING="4" CELLSPACING="3">
   <TR>
      <TH COLSPAN="3"><BR>
      	<H3>PRODUTOS</H3>
      </TH>
   </TR>
   
   <TR>
      <TH>ID:</TH>
      <TH>Titulo:</TH>
      <TH>Quantidade:</TH> 
   </TR>  
   
   <%   
   if (resultado != null) {
		List<Livro> livros = adm.getLivros();
		StringBuilder sbRegistro = new StringBuilder();
		StringBuilder sbLink = new StringBuilder();	
		
		if(livros != null){
			for (int i = 0; i < livros.size(); i++) {
				Livro p = livros.get(i);
				sbRegistro.setLength(0);
				sbLink.setLength(0);
				
			//	<a href="nome-do-lugar-a-ser-levado">descrição</a>
				
				sbRegistro.append("<TR ALIGN='CENTER'>");
				
				
				sbLink.append("<a href=LivroOperacao?");
					sbLink.append("txtId=");
					sbLink.append(p.getId());						
					sbLink.append("&");
					sbLink.append("operacao=");
					sbLink.append("VISUALIZAR");
					
				sbLink.append(">");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(p.getId());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getTitulo());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getQuantidade());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("</TR>");
				
				
				out.print(sbRegistro.toString());
				
			}
		}
		

	}
   
   %>
   
</TABLE>
</div>
           <div id="rodape"></div>

</body>
<script src="../se/jscript/menuunico.js"></script>

</html>