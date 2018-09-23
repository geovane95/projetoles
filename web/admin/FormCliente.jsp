<%-- 
    Document   : FormCliente
    Created on : 10/05/2018, 11:41:15
    Author     : Daniel Seiji Seguchi
--%>

<%@page import="Dominio.Administracao"%>
<%@page import="Dominio.Usuario"%>
<%@page import="Dominio.Cartao"%>
<%@page import="java.util.List"%>
<%@page import="Dominio.Endereco"%>
<%@page import="Dominio.Cliente"%>
<%@page import="Dominio.InitPagina"%>
<%@page import="CoreAplicacao.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="import" href="../se/TodasAsImports.html">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Resultado resultado = (Resultado) session.getAttribute("resultado");
            Administracao usuario = (Administracao) session.getAttribute("usuario");
            Cliente cliente = new Cliente();
	%>
        <%
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
        <%
            if(resultado!=null){
                if(resultado.getMsg()!=null)
                out.print(resultado.getMsg());
                else
                cliente = (Cliente)resultado.getEntidades().get(0);
            }
        %>
         <div class="container-fluid">
         <form action="ClienteOperacao">
            <!-- area de campos do form -->
            <div class="form-group col-6">
                      <label for="txtId">ID:</label>
                      <input type="text" class="form-control" id="txtId" name="txtId" value="<%		
			out.print(cliente.getId());%>" readonly="readonly">
                      
                    </div>
                    <div class="form-group col-6">
                      <label for="txtNome">Nome</label>
                      <input type="text" class="form-control" id="txtNome" name="txtNome" value="<%		
			out.print(cliente.getNome());%>">
                      
                    </div>
                    <div class="form-group col-4">
                      <label for="txtTel">Telefone</label>
                      <input type="text" class="form-control" id="txtTel" name="txtTelefone" value="<%		
			out.print(cliente.getTelefone());%>">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtCpf">Cpf</label>
                      <input type="text" class="form-control" id="txtCpf" name="txtCpf" value="<%		
			out.print(cliente.getCpf());%>">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtEmail">Email</label>
                      <input type="email" class="form-control" id="txtEmail" name="txtEmail" value="<%		
			out.print(cliente.getEmail());%>">
                    </div>
                    <div class="form-group col-4">
                      <label for="txtRg">RG</label>
                      <input type="text" class="form-control" id="txtRg" name="txtRg" value="<%		
			out.print(cliente.getRg());%>">
                    </div>
                    <div class="form-group col-4">
                        Genero:
                        <%   
                        if(cliente.getGenero().equals("Masculino"))
                        {
                             out.print("Masculino <input type='radio' name='txtGenero' value='Masculino' checked='checked'/>");	
                             out.print("Feminino <input type='radio' name='txtGenero' value='Feminino'/>");
                        }
                        else{
                             out.print("Masculino <input type='radio' name='txtGenero' value='Masculino'/>");	
                             out.print("Feminino <input type='radio' name='txtGenero' value='Feminino' checked='checked'/>");
                        }
                        %>
                    </div>
            <!--Endereco-->
        <TABLE class="table-striped tbEndereco" id="tbEndereco" CELLPADDING="4" CELLSPACING="3">
        <TR><TH COLSPAN="6"><BR><H3>Endereco</H3></TH></TR>
        <TR>
            <TH>ID:</TH>
           <TH>CEP:</TH>
           <TH>Numero:</TH>
           <TH>Complemento:</TH>
           <TH>End. Entrega:</TH>
           <TH><input type="button" value="Excluir" class="retirarEnderecos" id="retirar" name="retirar" /></TH>
        </TR>  
        <%   
        if (cliente.getEndereco()!=null)    
        if (cliente.getEndereco().size() != 0) 
        {
                     List<Endereco> entidades = cliente.getEndereco();
                     StringBuilder sbRegistro = new StringBuilder();
                     StringBuilder sbLink = new StringBuilder();	
                     if(entidades != null){
                             for (int i = 0; i < entidades.size(); i++) {
                                     Endereco end = entidades.get(i);
                                     sbRegistro.setLength(0);
                                     sbLink.setLength(0);
                                     sbRegistro.append("<TR ALIGN='CENTER' id='lnEndereco"+(i+1)+"' class='lnEndereco'>");
                                     sbRegistro.append("<TD>");
                                     sbRegistro.append("<input type= 'text' id='IdEndereco' class='IdEndereco' name='IdEndereco'");
                                     sbRegistro.append("value='");
                                     sbRegistro.append(i+1);
                                     sbRegistro.append("' readonly='readonly'");
                                     sbRegistro.append("/>");		
                                     sbRegistro.append("</TD>");
                                     sbRegistro.append("<TD>");
                                     sbRegistro.append("<input type= 'text' id='txtCep' name='txtCep'");
                                     sbRegistro.append("value='");
                                     sbRegistro.append(end.getCep());
                                     sbRegistro.append("'");
                                     sbRegistro.append("/>");		
                                     sbRegistro.append("</TD>");
                                     sbRegistro.append("<TD>");				
                                     sbRegistro.append("<input type= 'text' id='txtNumero' name='txtNumero'");
                                     sbRegistro.append("value='");
                                     sbRegistro.append(end.getNumero());
                                     sbRegistro.append("'");
                                     sbRegistro.append("/>");			
                                     sbRegistro.append("</TD>");
                                     sbRegistro.append("<TD>");	
                                     sbRegistro.append("<input type= 'text' id='txtComplemento' name='txtComplemento'");
                                     sbRegistro.append("value='");
                                     sbRegistro.append(end.getComplemento());
                                     sbRegistro.append("'");
                                     sbRegistro.append("/>");		
                                     sbRegistro.append("</TD>");
                                     sbRegistro.append("<TD>");
                                     sbRegistro.append("<input type='radio' value='"+(i+1)+"' name='entrega'");
                                        if(end.isEndereco_entrega()){
                                            sbRegistro.append(" checked='checked'");
                                        }
                                     sbRegistro.append("/></TD>");
                                     sbRegistro.append("<TD>");
                                     sbRegistro.append("<input type='checkbox' name='record' />");
                                     sbRegistro.append("</TD>");
                                     sbRegistro.append("</TR>");          

                                     out.print(sbRegistro.toString());
                             }
                     }
             }
        %>
        </TABLE>
        </br>
        </br>
        <button type="button" class="btn btn-outline-secondary adicionarEndereco" id="AdicionarEndereco">Adicionar Endereco</button>
        </br>
        </br>
        <div class="col-md-12">
            <button type="submit" class="btn btn-primary" name="operacao" value="ALTERAR">Salvar</button>
            <button type="submit" class="btn btn-primary" name="operacao" value="EXCLUIR">Excluir Conta</button>
        </div>
      </form>
      </div>
           <div id="rodape"></div>
    </body>
    <script src="../se/jscript/FormCliente.js"></script>
</html>
