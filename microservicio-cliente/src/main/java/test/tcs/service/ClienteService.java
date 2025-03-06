package test.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tcs.amqservice.RabbitMQSender;
import test.tcs.entity.Cliente;
import test.tcs.repository.ClienteRepository;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = obtenerPorId(id);
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setGenero(clienteActualizado.getGenero());
        cliente.setEdad(clienteActualizado.getEdad());
        cliente.setIdentificacion(clienteActualizado.getIdentificacion());
        cliente.setDireccion(clienteActualizado.getDireccion());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setContraseña(clienteActualizado.getContraseña());
        cliente.setEstado(clienteActualizado.isEstado());
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente guardarCliente(Cliente cliente) {
        Cliente nuevoCliente = clienteRepository.save(cliente);
        rabbitMQSender.enviarClienteCreado(nuevoCliente);
        return nuevoCliente;
    }
}
