
<%@page import="Dominio.Usuario"%>
<%@page import="Dominio.Emprestimo"%>
<%@page import="java.util.List"%>
<%@page import="Dominio.Cliente"%>
<%@page import="Dominio.InitPagina"%>
<%@page import="CoreAplicacao.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="import" href="../TodasAsImports.html">
        <title>Visualizar Pedidos</title>
    </head>
    <body>
         <%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Cliente cliente = null;
	%>
        <%
        if(usuario == null)
        {
            request.getRequestDispatcher("TelaLogin?operacao=CONSULTAR").forward(request, response);
        }
        if(!usuario.isLogado())
        {
            request.getRequestDispatcher("TelaLogin?operacao=CONSULTAR").forward(request, response);
        } 
        cliente = (Cliente)usuario;
        %>
        <div id="menucliente"></div>
        <%
            if(resultado!=null){
            if(resultado.getMsg()!=null)
            out.print(resultado.getMsg());
        }%>
        <form action="PedidosOperacao" method="get">
        <table class="table-striped tbPedido" CELLPADDING="4" CELLSPACING="3" id="tbPedido">
            <TR><TH COLSPAN="7"><BR><H3>Pedidos</H3></TH></TR>
            <TR>
               <TH>ID:</TH>
               <TH>Livro:</TH>
               <TH>Quantidade:</TH>
               <TH>Valor Unitario:</TH>
               <th>Total:</th>
               <TH>Estado:</TH>
               <th></th>
            </TR>  
            <select name="teste">
                <option>123</option>
                <option>232</option>
            </select>
            <%
              String a = null;
              List<Emprestimo> lPedido = cliente.getlPedido();	
                    if(lPedido != null)
                    for (int i = 0; i < lPedido.size(); i++)
                    {
                        String botao="";
                        Pedido p = lPedido.get(i);
                        if(p.getEstado().equals("entregue"))
                        {
                            botao="<select name ='Acao'> <option>Concluir_"+p.getId()+"</option> "
                                    + "<option>Devolver_"+p.getId()+" </option> </select >";
                         }
                        else {
                            botao = "";
                        }
                        a = "<TR ALIGN='CENTER' id='lPedido' class='lPedido'>"
                        +"<TD>"+p.getId()+"</td>"
                        +"<TD>"+p.getLivro().getTitulo()+"</td>"
                        +"<TD>"+p.getQuantidade()+"</td>"
                        +"<TD>"+p.getLivro().getPrecoVenda()+"</td>"
                        +"<TD>"+(p.getLivro().getPrecoVenda()*p.getQuantidade())+"</td>"
                        +"<TD>"+p.getEstado()+"</td>"+
                        "<TD>"+botao+"</td>"+
                        "</TR>";
                        out.print(a);
                    }
            
            %>
        </TABLE>
        <button  type="submit" value="ALTERAR" name="operacao">Aplicar</button>
        </form>
        </br>
        </br>
        <div id="rodape"></div>
    </body>
    <script src="../jscript/menuunico.js"></script>
</html>
