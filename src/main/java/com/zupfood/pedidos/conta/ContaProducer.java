package com.zupfood.pedidos.conta;

import com.zupfood.pedidos.config.KafkaTemplateConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContaProducer extends KafkaTemplateConfig {
    @Value("${spring.kafka2.producer.topic}")
    private String topico;

    @Async
    public void enviar(Conta conta) {
        kafkaTemplateConta.send(topico, conta.getId().toString(), conta);
    }
}
