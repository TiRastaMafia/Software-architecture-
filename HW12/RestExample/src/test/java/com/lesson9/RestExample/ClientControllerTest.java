package com.lesson9.RestExample;

import com.lesson9.RestExample.model.Client;
import com.lesson9.RestExample.service.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class ClientControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    ClientServiceImpl clientServiceImpl;

    private List<Client> getClients() {
        Client client1 = new Client();
            client1.setId(1);
            client1.setName("ivan");
            client1.setEmail("ivan@mail");
            client1.setPhone("777099374");
        Client client2 = new Client();
            client2.setId(2);
            client2.setName("Igor");
            client2.setEmail("igor@mail");
            client2.setPhone("888038422");
        return List.of(client1, client2);
    }


    @Test
    void getOneTest() throws Exception {
        Mockito.when(this.clientServiceImpl.read(1)).thenReturn(getClients().get(0));

        mvc.perform(get("/clients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("ivan"))
                .andExpect(jsonPath("$.email").value("ivan@mail"))
                .andExpect(jsonPath("$.phone").value("777099374"));



        mvc.perform(get("/clients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));


    }


    @Test
    void findAllClientsTest() throws Exception {
        Mockito.when(this.clientServiceImpl.readAll()).thenReturn(getClients());

        mvc.perform(get("/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

    }


}


