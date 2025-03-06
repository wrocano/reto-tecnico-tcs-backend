package test.tcs.amqservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @RabbitListener(queues = "clienteQueue")
    public void recibirClienteCreado(String mensaje) {
        System.out.println("Cliente recibido en microservicio-cuenta: " + mensaje);
        
        // Aquí podríamos crear automáticamente una cuenta para el cliente recibido
    }
}

