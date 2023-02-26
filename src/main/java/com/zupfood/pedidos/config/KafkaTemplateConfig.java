package com.zupfood.pedidos.config;

import com.zupfood.pedidos.conta.Conta;
import com.zupfood.pedidos.conta.NovaContaEvent;
import com.zupfood.pedidos.pedido.NovoPedidoEvent;
import com.zupfood.pedidos.pedido.PedidoCanceladoEvent;
import com.zupfood.pedidos.promocao.Promocao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class KafkaTemplateConfig {
    @Autowired
    protected KafkaTemplate<String, NovoPedidoEvent> kafkaTemplatePedido;

    @Autowired
    protected KafkaTemplate<String, PedidoCanceladoEvent> kafkaTemplatePedidoCanceladoEvent;
    @Autowired
    protected KafkaTemplate<String, NovaContaEvent> kafkaTemplateNovaContaEvent;
    @Autowired
    protected KafkaTemplate<String, Promocao> kafkaTemplatePromocao;
}
