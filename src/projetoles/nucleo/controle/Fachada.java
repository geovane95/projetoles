package projetoles.nucleo.controle;

import projetoles.dominio.EntidadeDominio;
import projetoles.dominio.livros.Autor;
import projetoles.nucleo.aplicacao.Resultado;
import projetoles.nucleo.iDao;
import projetoles.nucleo.iFachada;
import projetoles.nucleo.iStrategy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fachada implements iFachada {
    private static final String SALVAR = "SALVAR";
    private static final String ALTERAR = "ALTERAR";
    private static final String CONSULTAR = "CONSULTAR";
    private static final String DELETAR = "DELETAR";


    /**
     * Mapa para conter as regras de neg�cio de todas opera��es por entidade; O
     * valor � um mapa que de regras de neg�cio indexado pela opera��o
     */
    private Map<String, Map<String, List<iStrategy>>> rns;

    /**
     * Mapa de DAOS, ser� indexado pelo nome da entidade O valor � uma inst�ncia do
     * DAO para uma dada entidade;
     */
    private Map<String, iDao> daos;

    private Resultado resultado;

    public Fachada() {
        ///* Int�nciando o Map de Regras de Neg�cio */
        rns = new HashMap<String, Map<String, List<iStrategy>>>();
        ///*
        //ComplementarDtCadastro compDtCad = new ComplementarDtCadastro();
        //ValidadorDOAutor VDOAutor = new ValidadorDOAutor();
        //ValidarCamposCategoria valCampCat = new ValidarCamposCategoria();
        //ValidarCamposLivro valCampLivro = new ValidarCamposLivro();
        //GeradorCodigoLivro gerCodLivro = new GeradorCodigoLivro();
        //GeradorPrecoLivro gerPrecLivro = new GeradorPrecoLivro();
        //AtivadorLivroPrimeiroCadastro ativLivroPrimCad = new AtivadorLivroPrimeiroCadastro();
        //ValidarCamposLogin valCampLogin = new ValidarCamposLogin();
        //ValidarCamposCliente valCampCli = new ValidarCamposCliente();
        //AtivadorClientePrimeiroCadastro ativCliPrimCad = new AtivadorClientePrimeiroCadastro();
        //ValidarCamposEndereco valCampEnd = new ValidarCamposEndereco();
        //ValidarCamposCartaoCredito valCampCarCred = new ValidarCamposCartaoCredito();
        //VerificarExistenciaCliente verExistCli = new VerificarExistenciaCliente();
        //AdicionarLivroCarrinho adcLivCar = new AdicionarLivroCarrinho();
        //VerificarPedidoFinalizado verPedFin = new VerificarPedidoFinalizado();
        //AlterarQuantidadeItemCarrinho altQuantItemCar = new AlterarQuantidadeItemCarrinho();
        //ExcluirLivroCarrinho excLivCar = new ExcluirLivroCarrinho();
        //ConsultarClienteCarrinho conCliCar = new ConsultarClienteCarrinho();
        //CalcularFrete calcFrete = new CalcularFrete();
        //ValidarConsistenciaFrete valConsistFrete = new ValidarConsistenciaFrete();
        //CalcularValorTotalPedido calcValTotalPedido = new CalcularValorTotalPedido();
        //AdicionarCartoesPagamento adicCartPag = new AdicionarCartoesPagamento();
        //AdicionarCupomPromocionalPagamento adicCupomPromoPag = new AdicionarCupomPromocionalPagamento();
        //ExcluirCupomPagamento excluirCupomPag = new ExcluirCupomPagamento();
        //AdicionarCuponsTrocaPagamento adicCupomTrocaPag = new AdicionarCuponsTrocaPagamento();
        //RemoverValeComprasCarrinho remValeCarrinho = new RemoverValeComprasCarrinho();
        //RemoverCartaoCreditoCarrinho remCarCredCarrinho = new RemoverCartaoCreditoCarrinho();
        //ValidarFormaPagamento valFormaPag = new ValidarFormaPagamento();
        //VerificarDisponibilidadeLivros verDispLivros = new VerificarDisponibilidadeLivros();
        //AlterarStatusAtualPedido altStatusAtualPed = new AlterarStatusAtualPedido();
        //VerificarAcesso verAcesso = new VerificarAcesso();
        //ValidarTroca valTroca = new ValidarTroca();
        //AlterarStatusCompraEmTroca altStatusCompTroca = new AlterarStatusCompraEmTroca();
        //AlterarStatusAtualTroca altStatusAtualTroc = new AlterarStatusAtualTroca();
        //GerarGraficoAnalise gerarGraficoAnalise = new GerarGraficoAnalise();
        //AutenticarUsuario autUsuario = new AutenticarUsuario();*/
        //
        ///**
        // * /* Criando inst�ncias de regras de neg�cio a serem utilizados */
        // *
        // *ValidadorDadosObrigatoriosFornecedor vrDadosObrigatoriosFornecedor = new ValidadorDadosObrigatoriosFornecedor();
        // *ValidadorCnpj vCnpj = new ValidadorCnpj();
        // *ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
        // *ValidadorCpf vCpf = new ValidadorCpf();
        // *        // ValidadorQtdLivro vQtd = new ValidadorQtdLivro();
        // *
        // *        /*
        // * 		 * Criando uma lista para conter as regras de neg�cio de fornencedor quando a
        // * 		 * opera��o for salvar
        // * 		 */
        List<iStrategy> rnsSalvarAutor = new ArrayList<iStrategy>();
        // *        /* Adicionando as regras a serem utilizadas na opera��o salvar do fornecedor */
        //rnsSalvarAutor.add(VDOAutor);
        //rnsSalvarAutor.add(compDtCad);
        // *
        // *        /*
        // * 		 * Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica
        // * 		 * por opera��o do fornecedor
        // * 		 */
        Map<String, List<iStrategy>> rnsAutor = new HashMap<String, List<iStrategy>>();
        // *        /*
        // * 		 * Adiciona a listra de regras na opera��o salvar no mapa do fornecedor (lista
        // * 		 * criada na linha 70)
        // * 		 */
        rnsAutor.put("Salvar", rnsSalvarAutor);
        // *
        // *        /*
        // * 		 * Adiciona o mapa(criado na linha 79) com as regras indexadas pelas opera��es
        // * 		 * no mapa geral indexado pelo nome da entidade
        // * 		 */
        rns.put(Autor.class.getName(), rnsAutor);
        // *
        // *        /*
        // * 		 * Criando uma lista para conter as regras de neg�cio de cliente quando a
        // * 		 * opera��o for salvar
        // * 		 */
        // *List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
        // *        /* Adicionando as regras a serem utilizadas na opera��o salvar do cliente */
        // *rnsSalvarCliente.add(cDtCadastro);
        // *rnsSalvarCliente.add(vCpf);
        // *
        // *        /*
        // * 		 * Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica
        // * 		 * por opera��o do cliente
        // * 		 */
        // *Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
        // *        /*
        // * 		 * Adiciona a listra de regras na opera��o salvar no mapa do cliente (lista
        // * 		 * criada na linha 93)
        // * 		 */
        // *rnsCliente.put("SALVAR", rnsSalvarCliente);
        // *        /*
        // * 		 * Adiciona o mapa(criado na linha 101) com as regras indexadas pelas opera��es
        // * 		 * no mapa geral indexado pelo nome da entidade. Observe que este mapa (rns) � o
        // * 		 * mesmo utilizado na linha 88.
        // * 		 */
        // *rns.put(Cliente.class.getName(), rnsCliente);
        // *
        // *        /*
        // * 		 * Criando uma lista para conter as regras de neg�cio de livro quando a opera��o
        // * 		 * for salvar
        // * 		 */
        // *List<IStrategy> rnsSalvarLivro = new ArrayList<IStrategy>();
        // *        /* Adicionando as regras a serem utilizadas na opera��o salvar do livro */
        // *rnsSalvarLivro.add(cDtCadastro);
        // *        // rnsSalvarLivro.add(vQtd);
        // *
        // *        /*
        // * 		 * Criando uma lista para conter as regras de neg�cio de livro quando a opera��o
        // * 		 * for alterar
        // * 		 */
        // *List<IStrategy> rnsAlterarLivro = new ArrayList<IStrategy>();
        // *        /* Adicionando as regras a serem utilizadas na opera��o alterar do livro */
        // *        // rnsAlterarLivro.add(vQtd);
        // *
        // *        /*
        // * 		 * Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica
        // * 		 * por opera��o do livro
        // * 		 */
        // *Map<String, List<IStrategy>> rnsLivro = new HashMap<String, List<IStrategy>>();
        // *        /*
        // * 		 * Adiciona a listra de regras na opera��o salvar no mapa do livro (lista criada
        // * 		 * na linha 114)
        // * 		 */
        // *rnsLivro.put("SALVAR", rnsSalvarLivro);
        // *        /*
        // * 		 * Adiciona a listra de regras na opera��o alterar no mapa do livro (lista
        // * 		 * criada na linha 122)
        // * 		 */
        // *rnsLivro.put("ALTERAR", rnsAlterarLivro);
        // *
        // *        /*
        // * 		 * Adiciona o mapa(criado na linha 129) com as regras indexadas pelas opera��es
        // * 		 * no mapa geral indexado pelo nome da entidade. Observe que este mapa (rns) � o
        // * 		 * mesmo utilizado na linha 88.
        // * 		 */
        rns.put(Autor.class.getName(), rnsAutor);
        // **/
        //
        ///* Int�nciando o Map de DAOS */
        daos = new HashMap<String, iDao>();
        ///* Adicionando cada dao no MAP indexando pelo nome da classe */
        ///*
        //daos.put(Fornecedor.class.getName(), forDAO);
        //daos.put(Cliente.class.getName(), new DaoCliente());
        //daos.put(Autor.class.getName(), new DaoAutor());
        //daos.put(Livro.class.getName(), livroDAO);
        //
        //daos.put(Categoria.class.getName(), new CategoriaDAO());
        //daos.put(Livro.class.getName(), new DaoLivro());
        //daos.put(GrupoPrecificacao.class.getName(), new GrupoPrecificacaoDAO());
        //daos.put(Login.class.getName(), new LoginDAO());
        //daos.put(Cliente.class.getName(), new DaoCliente());
        //daos.put(Endereco.class.getName(), new EnderecoDAO());
        //daos.put(CartaoCredito.class.getName(), new CartaoCreditoDAO());
        //daos.put(Bandeira.class.getName(), new BandeiraDAO());
        //daos.put(TipoEndereco.class.getName(), new TipoEnderecoDAO());
        //daos.put(TipoTelefone.class.getName(), new TipoTelefoneDAO());
        //daos.put(Carrinho.class.getName(), new PedidoDAO());
        //daos.put(Pedido.class.getName(), new PedidoDAO());
        //daos.put(StatusPedido.class.getName(), new StatusPedidoDAO());
        //daos.put(Troca.class.getName(), new TrocaDAO());
        //daos.put(StatusTroca.class.getName(), new StatusTrocaDAO());*/
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        String msg = executarRegras(entidade, SALVAR);
        if (msg == null) {
            iDao dao = daos.get(nmClasse);
            try {
                dao.salvar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");
            }
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        String msg = executarRegras(entidade, ALTERAR);
        if (msg == null) {
            iDao dao = daos.get(nmClasse);
            try {
                dao.alterar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");
            }
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }

    @Override
    public Resultado deletar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        String msg = executarRegras(entidade, DELETAR);
        if (msg == null) {
            iDao dao = daos.get(nmClasse);
            try {
                dao.deletar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");
            }
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        String msg = executarRegras(entidade, CONSULTAR);
        if (msg == null) {
            iDao dao = daos.get(nmClasse);
            try {
                resultado.setEntidades(dao.consultar(entidade));
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a consulta!");
            }
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }

    @Override
    public Resultado visuzalizar(EntidadeDominio entidade) {
        resultado = new Resultado();
        resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
        resultado.getEntidades().add(entidade);
        return resultado;
    }

    private String executarRegras(EntidadeDominio entidade, String operacao) {
        String nmClasse = entidade.getClass().getName();
        StringBuilder msg = new StringBuilder();
        Map<String, List<iStrategy>> regrasOperacao = rns.get(nmClasse);
        if (regrasOperacao != null) {
            List<iStrategy> regras = regrasOperacao.get(operacao);
            if (regras != null) {
                for (iStrategy s : regras) {
                    String m = s.processar(entidade);
                    if (m != null) {
                        msg.append(m);
                        msg.append("\n");
                    }
                }
            }
        }
        if (msg.length() > 0)
            return msg.toString();
        else
            return null;
    }
}
