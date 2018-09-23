$(".add").click(function() {
    var add = $(this).parent().children("input.qtde");
    add.val(parseInt(add.val())+1);
    TotalPedido($(this));
    TotalCarrinho();
});
//asdasd
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
/*$(".retirar").click(function() {
     $(this).parents("tr").remove();
}); não funciona com linhas novas*/
$(".retirarEnderecos").click(function(){
        $(".tbEndereco").find('input[name="record"]').each(function()
        {
            if($(this).is(":checked"))
            {
                $(this).parents("tr").remove();
            }
        });
});
//asd>
$(".adicionarEndereco").click(function() {
var num = $('input.IdEndereco').length;
var id = 0;
    $('input.IdEndereco').each(function(i){
        id = id+1;
        $(this).val(id);
    }); 
    id = 0;
    $('input.entrega').each(function(i){
        id = id+1;
        $(this).val(id);
    });
// ta funcionando!!!
var tr = "<TR ALIGN='CENTER' id='lnEndereco"+(num+1)+"' class='lnEndereco'><TD><input type= 'text' id='IdEndereco' class='IdEndereco' name='IdEndereco'value='"+(num+1)+"'/>"+
"</TD><TD><input type= 'text' id='txtCep' name='txtCep' value=''/></TD><TD><input type= 'text' id='txtNumero' name='txtNumero' value=''/>"+
"</TD><TD><input type= 'text' id='txtComplemento' name='txtComplemento' value='' </TD> <TD><input type='radio' class='entrega' value='"+(num+1)+"' name='entrega'/></TD>"+
"<TD><input type='checkbox' name='record' /></TD></TR>"
$("#tbEndereco").append(tr);

    // o apendto manda o html escolhido por id ou classe para outro html
});

//comandos de adicionar e remover cartoes
$(".adicionarCartao").click(function() {
var num = $('input.IdCartao').length;
var id = 0;
    $('input.IdCartao').each(function(i){
        id = id+1;
        $(this).val(id);
    });
// ta funcionando!!!
var tr = "<TR ALIGN='CENTER' id='lnCartao"+(num+1)+"' class='lnCartao'><TD><input type= 'text' id='IdCartao' class='IdCartao' name='IdCartao' value='"+(num+1)+"' readonly = 'readonly'/>"+
                        "</TD><TD><input type= 'text' id='txtNumeroCartao' name='txtNumeroCartao' value=''/></TD><TD><input type= 'text' id='txtBandeira' name='txtBandeira' value=''/>"+
                        "</TD><TD><input type= 'text' id='txtValidade' name='txtValidade' value='' </TD>"+
                        "<TD><input type='checkbox' name='record' /></TD></TR>"
$("#tbCartao").append(tr);
    // o apendto manda o html escolhido por id ou classe para outro html
});
$(".retirarCartao").click(function(){
        $(".tbCartao").find('input[name="record"]').each(function()
        {
            if($(this).is(":checked"))
            {
                $(this).parents("tr").remove();
            }
        });
});