<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="CoreAplicacao.Resultado, Dominio.*, java.util.*, CoreImplUtil.ConverteDate"%>
<!--< jsp:forward page="CrudLivro?operacao=CONSULTAR" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<META http-equiv="Content-Type" content="text/html" charset="UTF-8">
<link rel="import" href="../se/TodasAsImports.html">
<title>:::: CONSULTAR Emprestimos::::</title>
</head>
<body>
	<%
                Resultado resultado = (Resultado) session.getAttribute("resultado");
                InitPagina init = (InitPagina) session.getAttribute("init");
                Administracao usuario = (Administracao) session.getAttribute("usuario");
                session.setAttribute("usuario", usuario);
       
	if(init==null)
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
	}
        if(usuario == null){
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
        if(!usuario.isLogado()){
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        }
	%>
        <div id="menucliente"></div>
        <div class="container-fluid">
	<form action="EmprestimoOperacao" method="post">
		<label for="txtId">Id:</label> 
                <input type="text" id="txtId" name="txtId" /></br> 
		<label for="txtIdCliente">Id Cliente:</label> 
                <input type="text" id="txtTitulo" name="txtIdCliente" /> </br>
                <label for="txtNomeCliente">Id Livro:</label> 
                <input type="text" id="txtTitulo" name="txtNomeCliente" /> </br>
                <input type="submit" id="operacao" name="operacao" value="CONSULTAR" />
	</form>
        <a href="CadastroEmprestimo.jsp">Novo Emprestimo</a>
	<%	
	if(resultado !=null && resultado.getMsg() != null){
		out.print(resultado.getMsg());
	}        
	%>
<BR>

<TABLE BORDER="5"    WIDTH="50%"   CELLPADDING="4" CELLSPACING="5">
   <TR>
      <TH COLSPAN="3"><BR>
      	<H3>Emprestimos</H3>
      </TH>
   </TR>
   
   <TR>
      <TH>ID:</TH>
      <TH>ID cliente:</TH>
      <TH>Nome cliente:</TH>
      <TH>ID livro:</TH>
      <TH>Nome livro:</TH>
   </TR>  
   
   <%
       // gambis para não dar merda no resto do codigo
   if(resultado != null)
       if(!resultado.getEntidades().isEmpty())
       if(resultado.getEntidades().get(0).getClass()==Emprestimo.class){
                List<EntidadeDominio> entidades = resultado.getEntidades();
		StringBuilder sbRegistro = new StringBuilder();
		StringBuilder sbLink = new StringBuilder();	
		if(entidades != null){
			for (int i = 0; i < entidades.size(); i++) {
				Emprestimo p = (Emprestimo) entidades.get(i);
				sbRegistro.setLength(0);
				sbLink.setLength(0);
				
			//	<a href="nome-do-lugar-a-ser-levado">descrição</a>
				
				sbRegistro.append("<TR ALIGN='CENTER'>");
				
				
				sbLink.append("<a href=EmprestimoOperacao?");
					sbLink.append("txtIdEmprestimo=");
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
				sbRegistro.append(p.getCliente().getId());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getCliente().getNome());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
                                sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getLivro().getId());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getLivro().getTitulo());
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