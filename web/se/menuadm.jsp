<%-- 
    Document   : menu
    Created on : 08/05/2018, 15:30:17
    Author     : nicolas
--%>

<%@page import="Dominio.Usuario"%>
<%@page import="Dominio.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menuadministrador">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="teste">
        <!--<div id="menuunico" class="float-left"></div>-->
         <div class="collapse navbar-collapse" id="navbarTogglerDemo01" >
              <a class="navbar-brand" href="http://localhost:8080/projetoexemplo/Admin/AdmGeral.jsp">Geral</a>
                 <ul class="navbar-nav mr-auto">
                   <li class="nav-item active">
                     <a class="nav-link" href="http://localhost:8080/projetoexemplo/Admin/ConsultaCliente.jsp">Clientes<span class="sr-only">(current)</span></a>
                   </li>
                   <li class="nav-item active">
                     <a class="nav-link" href="http://localhost:8080/projetoexemplo/Admin/ConsultaLivro.jsp">Livros<span class="sr-only">(current)</span></a>
                   </li>
                 </ul>
                 <ul class="navbar-nav">
                 <li class="nav-item">
                 <%
                 Usuario u = (Usuario)request.getSession().getAttribute("usuario");
                 if(u.isLogado())
                 out.print("<a class='nav-link' href=#>"+u.getNome()+"</a>");
                 else
                 out.print("<a class='nav-link' href=#>Nao esta logado</a>");
                 %>
                 
                 </li>
                 <li class="nav-item ">
                 <a class="nav-link " href="http://localhost:8080/projetoexemplo/Loja/carrinho.jsp">Carrinho</a>
                 </li>
             </ul>
         </div>
     </nav>
        </div>
    </body>
</html>
