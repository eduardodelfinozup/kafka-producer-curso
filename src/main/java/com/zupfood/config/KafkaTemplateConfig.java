package com.zupfood.config;

import com.zupfood.conta.NovaContaEvent;
import com.zupfood.pedido.NovoPedidoEvent;
import com.zupfood.pedido.PedidoCanceladoEvent;
import com.zupfood.promocao.Promocao;
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
