package test.tcs.amqservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.tcs.entity.Cliente;

@Service
public class RabbitMQSender {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "clienteExchange";
    private static final String ROUTING_KEY = "clienteQueue";

    public void enviarClienteCreado(Cliente cliente) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String mensaje = objectMapper.writeValueAsString(cliente);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, mensaje);
            System.out.println("Mensaje enviado: " + mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
