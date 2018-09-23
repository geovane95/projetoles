package projetoles.nucleo;

import projetoles.dominio.EntidadeDominio;
import projetoles.nucleo.aplicacao.Resultado;

public interface iFachada {
    public Resultado salvar(EntidadeDominio entidade);
    public Resultado alterar(EntidadeDominio entidade);
    public Resultado deletar(EntidadeDominio entidade);
    public Resultado consultar(EntidadeDominio entidade);
    public Resultado visuzalizar(EntidadeDominio entidade);
}
