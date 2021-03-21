package com.spring.rabbitmq.demo.controller;

import com.spring.rabbitmq.RabbitController;
import com.spring.rabbitmq.rabbitcomponent.RabbitMQSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RabbitControllerTest {

    @InjectMocks
    private RabbitController rabbitController;
    private MockMvc mockMvc;

    @Mock
    RabbitMQSender rabbitMQSender;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rabbitController).build();
    }

    @Test
    public void sendTest() throws Exception {
        mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
