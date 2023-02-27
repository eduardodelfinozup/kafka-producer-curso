package com.zupfood.livraria.categoria;

public class CategoriaInexistenteException extends RuntimeException{

    public CategoriaInexistenteException() {
        super("Não existe categoria cadastrada com esse id");
    }
}