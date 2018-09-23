package projetoles.nucleo.dao;

import projetoles.dominio.EntidadeDominio;
import projetoles.dominio.livros.Autor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutorDao extends DaoAbs{

    protected AutorDao() {
        super("autor", "id");
    }

    @Override
    public void salvar(EntidadeDominio entidadeDominio) throws SQLException {
        openConnection();
        PreparedStatement pst = null;
        Autor autor = (Autor) entidadeDominio;

        try {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO autor(nome)" +
                    " VALUES (?)";
            pst = connection.prepareStatement(sql // campo a ser inserido
                    , Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, autor.getNome());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
            }
            autor.setId(id);

            connection.commit();
        } catch (SQLException e) {
            runRollback(e);
        } finally {
            closeConnection(pst, ctrlTransaction);
        }
    }

    @Override
    public void alterar(EntidadeDominio entidadeDominio) throws SQLException {
        openConnection();
        PreparedStatement pst = null;
        Autor autor = (Autor) entidadeDominio;

        try {
            connection.setAutoCommit(false);

            String sql = "UPDATE autor SET nome=?" +
                    " WHERE id = ?";
            pst = connection.prepareStatement(sql);

            pst.setString(1, autor.getNome());
            pst.setInt(2, autor.getId());
            pst.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            runRollback(e);
        } finally {
            closeConnection(pst, ctrlTransaction);
        }
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) throws SQLException {
        PreparedStatement pst = null;
        Autor autor = (Autor) entidadeDominio;

        String sql = "SELECT * FROM autor";

        try {
            openConnection();
            pst = connection.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            List<EntidadeDominio> autores = new ArrayList<EntidadeDominio>();
            while (rs.next()) {
                Autor p = new Autor();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));

                autores.add(p);
            }
            return autores;
        } catch (SQLException e) {
            runRollback(e);
        } finally{ // Executa o bloco abaixo independente do que ocorreu
            closeConnection(pst,ctrlTransaction);
        }
        return null;
    }
}
