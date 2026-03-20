package dev.lucas.order_producer.controller;

import dev.lucas.order_producer.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

        private KafkaTemplate<String, Object> kafkaTemplate;
        private static final String TOPIC = "orders";

        public OrderController(KafkaTemplate<String, Object> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        @PostMapping
        public String createOrder(@RequestBody Order order) {
            order.setId(UUID.randomUUID().toString());
            kafkaTemplate.send(TOPIC, order);
            return "Order sent successfully! ID: " + order.getId();
        }

}
