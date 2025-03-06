package test.tcs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import test.tcs.entity.Cliente;
import test.tcs.repository.ClienteRepository;
import test.tcs.service.ClienteService;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Jose Lema");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setIdentificacion("0102030405");
        cliente.setDireccion("Otavalo sn y principal");
        cliente.setTelefono("098254785");
        cliente.setClienteId("123456");
        cliente.setContraseña("1234");
        cliente.setEstado(true);

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente resultado = clienteService.guardarCliente(cliente);

        assertNotNull(resultado);
        assertEquals("Jose Lema", resultado.getNombre());
        assertEquals("123456", resultado.getClienteId());
    }

    @Test
    public void testObtenerClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Jose Lema");
        cliente.setClienteId("123456");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        Cliente resultado = clienteService.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Jose Lema", resultado.getNombre());
    }

    @Test
    public void testObtenerClientePorIdNoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clienteService.obtenerPorId(1L);
        });

        assertEquals("Cliente no encontrado", exception.getMessage());
    }
}
