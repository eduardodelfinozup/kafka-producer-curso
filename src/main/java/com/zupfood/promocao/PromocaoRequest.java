package com.zupfood.promocao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.zupfood.produto.ProdutoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromocaoRequest {

    private Long idProduto;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate inicio;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate fim;

    private BigDecimal valor;

    private String regras;

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public Promocao toModel(ProdutoRepository produtoRepository) {
        var produto = produtoRepository.findById(this.idProduto)
                .orElseThrow(IllegalArgumentException::new);

        return new Promocao(produto, this.inicio, this.fim, this.valor, this.regras);
    }
}