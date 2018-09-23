package projetoles.nucleo.dao;


import projetoles.dominio.EntidadeDominio;
import projetoles.nucleo.iDao;
import projetoles.nucleo.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DaoAbs implements iDao {

    protected Connection connection;
    protected String table;
    protected String idTable;
    protected boolean ctrlTransaction = true;

    public DaoAbs(Connection connection, String table, String idTable) {
        this.table = table;
        this.idTable = idTable;
        this.connection = connection;
    }

    protected DaoAbs(String table, String idTable) {
        this.table = table;
        this.idTable = idTable;
    }

    @Override
    public void deletar(EntidadeDominio entidade) throws SQLException{
        openConnection();
        PreparedStatement pst = null;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(table);
        sb.append(" WHERE ");
        sb.append(idTable);
        sb.append("=");
        sb.append("?");
        try {
            connection.setAutoCommit(false);
            pst = connection.prepareStatement(sb.toString());
            pst.setInt(1, entidade.getId());

            pst.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            runRollback(e);
            e.printStackTrace();
        } finally {
            closeConnection(pst, ctrlTransaction);
        }
    }

    protected void openConnection() {
        try {
            if (connection == null || connection.isClosed())
                connection = Conexao.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.print("Erro ao tentar abrir o banco!");
        }
    }

    protected void closeConnection(PreparedStatement pst, boolean close) {
        try{ // Ocorreu um erro de SQLException
            pst.close(); // Nao sera mais utilizado. Fecha o
            if (close) {
                connection.close(); // Fecha a conex�o com o BD
            }
        } catch (SQLException e){ // Ocorreu um erro no fechamento da conexao
            e.printStackTrace(); // Exibe uma mensagem com a excecao
            System.out.print("Erro ao fechar o banco!");
        }
    }

    protected void runRollback(SQLException e) {
        try {
            connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.print("Erro ao tentar efetuar rollback no banco!");
        }
        e.printStackTrace();
        System.out.print("Erro ao tentar executar algo no banco!");
    }

}
