<%-- 
    Document   : menucliente
    Created on : 08/05/2018, 15:30:17
    Author     : nicolas
--%>

<%@page import="Dominio.Emprestimo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dominio.Administracao"%>
<%@page import="Dominio.Carrinho"%>
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
        <!--esse menu so funciona se o id for igual o id da div da onde a funcao onload esta requisitando-->
        <div id="menucliente">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="teste">
        <!--<div id="menuunico" class="float-left"></div>-->
         <div class="collapse navbar-collapse" id="navbarTogglerDemo01" >
              <a class="navbar-brand" href="http://localhost:8080/Livraria/Loja/Loja.jsp">Livraria</a>
                 <ul class="navbar-nav mr-auto">
                   <li class="nav-item active">
                     <a class="nav-link" href="#">MenuTeste<span class="sr-only">(current)</span></a>
                   </li>
                 </ul>
                 <ul class="navbar-nav">
                 <%
                 Administracao adm = (Administracao)request.getSession().getAttribute("usuario");
                 if(adm!=null){
                     if(adm.isLogado())
                    {
                       out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/ConsultaEmprestimo.jsp'>Emprestimos</a></li>");
                       out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/ConsultaLivro.jsp'>Livros</a></li>");
                       out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/ConsultaCliente.jsp'>Clientes</a></li>"); 
                       out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/AnaliseLinhas.jsp'>Análise</a></li>");                       
                       out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/AdmGeral.jsp'>"+adm.getNome()+"</a></li>");
                       out.print("<li class='nav-item'><a class='nav-link' href='sair?operacao=CONSULTAR'>Sair</a></li>");
                    }
                     else
                     out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/TelaLoginAdmin.jsp'>Login</a></li>");
                 }
                 else
                 out.print("<li class='nav-item'><a class='nav-link' href='http://localhost:8080/Livraria/Admin/TelaLoginAdmin.jsp'>Login</a></li>");
                 %>
             </ul>
         </div>
     </nav>
        </div>
    </body>
</html>
