$(".add").click(function() {
    var add = $(this).parent().children("input.qtde");
    if((parseInt(add.val())+1)>parseInt($(this).parent().parent().children("TD.qtdeEstoque").children("input.qtdeEstoque").val()))
    {
        alert("Estoque indisponível para esta quantidade");
    }else
    {
        add.val(parseInt(add.val())+1);
    }
    TotalPedido($(this));
    TotalCarrinho();
});

$(".sub").click(function() {
    var sub = $(this).parent().children("input.qtde");
    if(sub.val()<2)
    {
          sub.val(1);
    }
    else{
       sub.val(sub.val()-1);
    }
    //retiraa
    TotalPedido($(this));
    TotalCarrinho();
});
function TotalPedido(a){
    var totalPedido = a.parent().parent().children("TD.totalPedido");
    // não ta pegando o preco unitario porque ele nao reconhece como numero
    var PrecoUnitario =  parseInt(a.parent().parent().children("TD.precoUnitario").children("input.precounitario").val());
    var qtde = parseInt(a.parent().children("input.qtde").val());
    totalPedido.children("input.totalPedido").val(qtde*PrecoUnitario);
}
function TotalCarrinho(){
    var total = 0;
    $('input.totalPedido').each(function(i){
        var valor = parseFloat($(this).val());
            total += valor;
    });   
    $('#totalCarrinho').val(total); 
}
$(".retirar").click(function() {
    $(this).parent().parent().remove();
    TotalCarrinho();
});