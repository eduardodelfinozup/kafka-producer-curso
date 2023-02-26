package com.zupfood.pedidos.pedido;


import com.zupfood.pedidos.config.KafkaTemplateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PedidoCanceladoProducer extends KafkaTemplateConfig {

    Logger logger = LoggerFactory.getLogger(PedidoCanceladoProducer.class);


    @Value("${spring.kafka.producer.topic.pedido-cancelado}")
    private String topico;

    @Async
    public void enviar(Pedido pedido) {
        PedidoCanceladoEvent evento = new PedidoCanceladoEvent(
                pedido.getId(), pedido.getIdCliente(), pedido.getIdRestaurante());

        kafkaTemplatePedidoCanceladoEvent.send(topico, pedido.getId().toString(), evento);

        logger.info("Evento de Pedido Cancelado gerado com sucesso : {} ", evento.toString());
    }
}