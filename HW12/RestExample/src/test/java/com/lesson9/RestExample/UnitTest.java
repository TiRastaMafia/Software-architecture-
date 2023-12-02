package com.lesson9.RestExample;

import com.lesson9.RestExample.model.Client;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

public class UnitTest {
    Client client1 = new Client();

    {
        client1.setId(1);
        client1.setName("ivan");
        client1.setEmail("ivan@mail");
        client1.setPhone("777099374");
    }

    Client client2 = new Client();

    {
        client2.setId(2);
        client2.setName("Igor");
        client2.setEmail("igor@mail");
        client2.setPhone("888038422");
    }

    @Test
    public void testNotNull() {
        Assert.notNull(client1.getId(), "нет айди");
        Assert.notNull(client1.getName(), "нет имени");
        Assert.notNull(client1.getEmail(), "нет почты");
        Assert.notNull(client1.getPhone(), "нет телефона");
        }

    @Test
    public void testIdIsInt() {
        Assert.state(client1.getId().getClass() == Integer.class , "тип не соответствует");
    }

}
