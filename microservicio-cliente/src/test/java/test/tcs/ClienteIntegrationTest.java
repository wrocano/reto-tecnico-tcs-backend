package test.tcs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import test.tcs.repository.ClienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testCrearCliente() throws Exception {
        String clienteJson = "{ \"nombre\": \"Jose Lema\", \"genero\": \"Masculino\", \"edad\": 30, \"identificacion\": \"0102030405\", \"direccion\": \"Otavalo sn y principal\", \"telefono\": \"098254785\", \"clienteId\": \"123456\", \"contraseña\": \"1234\", \"estado\": true }";

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                .contentType("application/json")
                .content(clienteJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Jose Lema"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clienteId").value("123456"));
    }
}