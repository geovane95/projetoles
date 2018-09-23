<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="CoreAplicacao.Resultado, Dominio.*, java.util.*, CoreImplUtil.ConverteDate"%>
<!--< jsp:forward page="CrudLivro?operacao=CONSULTAR" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<META http-equiv="Content-Type" content="text/html" charset="UTF-8">
<link rel="import" href="../se/TodasAsImports.html">
<title>:::: teste CONSULTAR LIVRO::::</title>
</head>
<body>
	<%
                Resultado resultado = (Resultado) session.getAttribute("resultado");
                InitPagina init = (InitPagina) session.getAttribute("init");
                Administracao usuario = (Administracao)session.getAttribute("usuario");
	%>
        <%	
	if(init==null||usuario==null)
        {
		request.getRequestDispatcher("ConsultaCliente?operacao=CONSULTAR").forward(request, response);
	}
        if(!usuario.isLogado())
        {
            request.getRequestDispatcher("TelaLoginAdmin?operacao=CONSULTAR").forward(request, response);
        } 
	%>
        <%//out.print(menu); não uso mais porque o menu jsp ta funcionando%>
        <div id="menucliente"></div> 
        <div class="container-fluid">
	<form action="ClienteOperacao" method="post">
		<label for="txtId">Id:</label> 
                <input type="text" id="txtId" name="txtId" /></br> 
		<label for="txtTitulo">Nome:</label> 
                <input type="text" id="txtNome" name="txtNome" /> </br>  
                <input type="submit" id="operacao" name="operacao" value="CONSULTAR" />
	</form>
         <a href="CadastroCliente.jsp">Cadastrar Cliente</a>

	<%	
	if(resultado !=null && resultado.getMsg() != null){
		out.print(resultado.getMsg());
	}        
	%>
<BR>

<TABLE BORDER="5"    WIDTH="50%"   CELLPADDING="4" CELLSPACING="3">
   <TR>
      <TH COLSPAN="3"><BR>
      	<H3>Clientes</H3>
      </TH>
   </TR>
   
   <TR>
      <TH>ID:</TH>
      <TH>Nome:</TH>
      <TH>Telefone:</TH>
   </TR>  
   <%   
   if (resultado != null) {
      
		List<EntidadeDominio> entidades = resultado.getEntidades();
		StringBuilder sbRegistro = new StringBuilder();
		StringBuilder sbLink = new StringBuilder();	
		if(entidades.get(0).getClass()==Cliente.class){
			for (int i = 0; i < entidades.size(); i++) {
				Cliente c = (Cliente) entidades.get(i);
				sbRegistro.setLength(0);
				sbLink.setLength(0);
				
			//	<a href="nome-do-lugar-a-ser-levado">descrição</a>
				
				sbRegistro.append("<TR ALIGN='CENTER'>");
				
				
				sbLink.append("<a href=ClienteOperacao?");
					sbLink.append("txtId=");
					sbLink.append(c.getId());						
					sbLink.append("&");
					sbLink.append("operacao=");
					sbLink.append("VISUALIZAR");
					
				sbLink.append(">");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(c.getId());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(c.getNome());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(c.getTelefone());
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