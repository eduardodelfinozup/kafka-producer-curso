package com.zupfood.pedido;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zupfood.item.ItemEvent;

import java.time.LocalDateTime;
import java.util.List;

public class NovoPedidoEvent {

    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize
    private LocalDateTime dataCriado;

    private List<ItemEvent> itens;

    private StatusPedido status;

    public NovoPedidoEvent(Long id, Long idCliente, Long idRestaurante, LocalDateTime dataCriado, List<ItemEvent> itens, StatusPedido status) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.dataCriado = dataCriado;
        this.itens = itens;
        this.status = status;
    }

    public NovoPedidoEvent() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public List<ItemEvent> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "NovoPedidoEvent{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                ", dataCriado=" + dataCriado +
                '}';
    }
}