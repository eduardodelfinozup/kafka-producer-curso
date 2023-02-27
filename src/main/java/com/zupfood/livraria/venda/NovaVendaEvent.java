package com.zupfood.livraria.venda;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NovaVendaEvent {

    private Long id;

    private Long idLivro;

    private Long idAutor;

    private Long idCategoria;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataCompra;

    private BigDecimal valor;

    private TipoPagamento tipoPagamento;

    private String emailCliente;
    private String tituloLivro;

    public NovaVendaEvent(Venda venda) {
        this.id = venda.getId();
        this.idLivro = venda.getLivro().getId();
        this.idAutor = venda.getLivro().getAutor().getId();
        this.idCategoria = venda.getLivro().getCategoria().getId();
        this.dataCompra = venda.getCompradoEm();
        this.valor = venda.getValor();
        this.tipoPagamento = venda.getTipoPagamento();
        this.emailCliente = venda.getEmailCliente();
        this.tituloLivro = venda.getLivro().getTitulo();
    }

    public Long getId() {
        return id;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    @Override
    public String toString() {
        return "NovaVendaEvent{" +
                "id=" + id +
                ", idLivro=" + idLivro +
                ", idAutor=" + idAutor +
                ", idCategoria=" + idCategoria +
                ", dataCompra=" + dataCompra +
                ", valor=" + valor +
                ", tipoPagamento=" + tipoPagamento +
                ", emailCliente='" + emailCliente + '\'' +
                '}';
    }
}
