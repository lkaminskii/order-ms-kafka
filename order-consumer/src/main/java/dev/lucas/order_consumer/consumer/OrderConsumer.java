package dev.lucas.order_consumer.consumer;

import dev.lucas.order_consumer.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

        @KafkaListener(topics = "orders", groupId = "order-consumers")
        public void consumeOrder(Order order) {
            System.out.println("========================================");
            System.out.println("NEW ORDER RECEIVED!");
            System.out.println("ID: " + order.getId());
            System.out.println("Product: " + order.getProduct());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Amount: $" + order.getAmount());
            System.out.println("========================================");
        }

}
