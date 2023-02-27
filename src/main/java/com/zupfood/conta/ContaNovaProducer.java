package com.zupfood.conta;

import com.zupfood.config.KafkaTemplateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContaNovaProducer extends KafkaTemplateConfig {

    Logger logger = LoggerFactory.getLogger(ContaNovaProducer.class);

    @Value("${spring.kafka2.producer.topic.nova-conta}")
    private String topicName;

    @Async
    public void send(Conta conta) {
        NovaContaEvent evento = new NovaContaEvent(conta.getId(),
                conta.getAgencia(), conta.getNumero(), conta.getSaldo());

        kafkaTemplateNovaContaEvent.send(topicName, evento);

        logger.info("Evento NOVA_CONTA gerado com sucesso : {} ", evento.toString());
    }
}