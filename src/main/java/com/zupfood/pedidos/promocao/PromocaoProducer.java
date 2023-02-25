package com.zupfood.pedidos.promocao;

import com.zupfood.pedidos.config.KafkaTemplateConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PromocaoProducer extends KafkaTemplateConfig {

    @Value("${spring.kafka3.producer.topic}")
    private String topico;

    @Async
    public void enviar(Promocao promocao) {
        kafkaTemplatePromocao.send(topico, promocao.getId().toString(), promocao);
    }
}
