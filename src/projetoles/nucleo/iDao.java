package projetoles.nucleo;

import projetoles.dominio.EntidadeDominio;

import java.sql.SQLException;
import java.util.List;

public interface iDao {
    public void salvar(EntidadeDominio entidadeDominio) throws SQLException;
    public void alterar(EntidadeDominio entidadeDominio) throws SQLException;
    public void deletar(EntidadeDominio entidadeDominio) throws SQLException;
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) throws SQLException;
}
