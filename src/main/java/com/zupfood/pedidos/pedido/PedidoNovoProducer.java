package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.config.KafkaTemplateConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PedidoNovoProducer extends KafkaTemplateConfig {

    @Value("${spring.kafka.producer.topic}")
    private String topico;

    @Async
    public void enviar(Pedido pedido) {
        kafkaTemplatePedido.send(topico, pedido.getId().toString(), pedido);
    }
}