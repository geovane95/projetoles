<%@page import="Dominio.Administracao"%>
<%@page import="Dominio.Usuario"%>
<%@page import="Dominio.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="Dominio.Cliente"%>
<%@page import="Dominio.InitPagina"%>
<%@page import="CoreAplicacao.Resultado"%>
<%@page import="CoreAplicacao.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="import" href="../se/TodasAsImports.html">
        <title>Análise de vendas</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = new google.visualization.DataTable();
      data.addColumn('number', 'análise');
      data.addColumn('number', 'Senhor dos Aneis');
      data.addColumn('number', '123');
      data.addColumn('number', '60 Estrategias praticas para ganhar mais tempo');

      data.addRows([
        [1,  37.8, 80.8, 41.8],
        [2,  30.9, 69.5, 32.4],
        [3,  25.4,   57, 25.7],
        [4,  11.7, 18.8, 10.5],
        [5,  11.9, 17.6, 10.4],
        [6,   8.8, 13.6,  7.7],
        [7,   7.6, 12.3,  9.6],
        [8,  12.3, 29.2, 10.6],
        [9,  16.9, 42.9, 14.8],
        [10, 12.8, 30.9, 11.6],
        [11,  5.3,  7.9,  4.7],
        [12,  6.6,  8.4,  5.2],
        [13,  4.8,  6.3,  3.6],
        [14,  4.2,  6.2,  3.4]
      ]);

      var options = {
        chart: {
          title: 'Livraria online',
          subtitle: 'numero de vendas'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }
  </script>
</head>
<body>
    <div id="menucliente"></div>
    <h2>Análise vendas</h2>
    <div id="line_top_x"></div>
 
        <div id="rodape"></div>
    </body>
    <script src="../se/jscript/menuunico.js"></script>
</html>
