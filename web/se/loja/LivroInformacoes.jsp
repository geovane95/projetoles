<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="CoreAplicacao.Resultado, Dominio.*, java.util.*, CoreImplUtil.ConverteDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' type='text/css' href='cssmenu.css'>
<link rel="import" href="../TodasAsImports.html">
<title>Livro Informacoes</title>
</head>
<body>

        <%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
                InitPagina init = (InitPagina) session.getAttribute("init");
                Livro livro = (Livro) resultado.getEntidades().get(0);
	%>
        <%
        if(livro == null){
                request.getRequestDispatcher("Loja?operacao=CONSULTAR").forward(request, response);
            }  
        if(init == null){
                    request.getRequestDispatcher("LivroInformacoes?operacao=CONSULTAR").forward(request, response);
                }   
        %>
        <div id="menucliente"></div>
        <div class="container-fluid">
                </br> 		
		<label for="txtDescricao">Titulo: <%out.print(livro.getTitulo());%></label>
		</br>
                <label for="txtPreco">Preco:</label>
                    <input type="text" name="txtPreco" id ="txtPreco" value="R$<%out.print(livro.getPrecoVenda());%>" readonly="readonly" />
                </br>
                <label for="txtISBN">ISBN: <%out.print(livro.getISBN());%></label>
		</br>
		 <label for="txtAutor">Autor: <%out.print(livro.getAutor());%></label>
		</br>
                 <label for="txtEdicao">Edicao: <%out.print(livro.getEdicao());%></label>
		</br>
		 <label for="txtAno">Ano: <%out.print(livro.getAno());%></label>
		</br>
                <label for="txtSinopse">Sinopse: <%out.print(livro.getSinopse());%></label>
                    </br>
                 <label for="txtnPaginas">Numero de páginas: <%out.print(livro.getnPaginas());%></label>
		</br>
                <label for="txtAltura">Altura: <%out.print(livro.getAltura());%>cm</label>
		</br>
                <label for="txtLargura">Largura: <%out.print(livro.getLargura());%>cm</label>
		</br>
		<label for="txtProfundidade">Profundidade: <%out.print(livro.getProfundidade());%>cm</label>
		</br>
		<label for="txtPeso">Peso:<%out.print(livro.getQuantidade());%>g</label>
                </br>
                   <label for="txtStatus">Status atual: </br>
                       <%   
                       if(livro.getStatus())
                       {
                            out.print("Ativo");
                       }
                       else{
                            out.print("Inativo");
                       }
                       %>
                        </label>
                        </br>
                </br>
                </br>
		<label for="txtEditora">
                    Editora:
                </label>
                </br>
                
                <%// só tem uma editora por livro
                    for(LEditora c : init.getEditora()){
                            if (livro.getEditora().getId() == c.getId()) {
                                    out.print(c.getNome());
                                }
                    }	        
                  %>

		</br>
		<label for="txtCategoria">
                    Categoria:
                </label>
                </br>
                <%
                    for(LCategoria c : init.getCategoria()){
                        for(LCategoria lc : livro.getCategoria()){
                            if (lc.getId() == c.getId()) {
                                    out.print(c.getCategoria()+" ");
                                }
                        }
                    }	        
                %>
                <br><a href="LivroInformacoesOperacao?operacao=VISUALIZAR&txtId=<%out.print(livro.getId());%>">ADICIONAR AO CARRINHO</a>
        </div>
           <div id="rodape"></div>

</body>
<script src="../jscript/menuunico.js"></script>
</html>