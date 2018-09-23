/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function carregarItens(){
    //variáveis
    var url = "livro";

    //Capturar Dados Usando Método AJAX do jQuery
    $.ajax({
        type: "GET", 
        url: url,
        timeout: 3000,
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function() {
            $("h2").html("Carregando..."); //Carregando
        },
        error: function() {
            $("h2").html("O servidor não conseguiu processar o pedido");
        },
        success: function(retorno) {
                // Interpretando retorno JSON...
                var clientes = retorno;

                // Listando cada cliente encontrado na lista...
                $.each(clientes,function(i, cliente){
                    var item = "<li><h2>"+cliente.NOME+"</h2><p><b>Fone.:</b> "+cliente.TELEFONE+"</p><p><b>Email:</b> "+cliente.EMAIL+"</p></li>";
                    $("#listaClientes").append(item);
                });
                    //Limpar Status de Carregando 
                    $("h2").html("Carregado"); 
        } 
    });  
}

