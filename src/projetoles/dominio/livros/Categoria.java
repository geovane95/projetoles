package projetoles.dominio.livros;

import projetoles.dominio.EntidadeDominio;

public class Categoria extends EntidadeDominio {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
