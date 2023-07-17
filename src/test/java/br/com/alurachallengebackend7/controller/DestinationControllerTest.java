package br.com.alurachallengebackend7.controller;

import br.com.alurachallengebackend7.domain.destination.dto.DataDetailDestination;
import br.com.alurachallengebackend7.domain.destination.dto.DestinationData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class DestinationControllerTest {
    @Autowired
    private MockMvc mvc;

    //@Autowired
    //private JacksonTester<DestinationData> destinationDataJson;
    //@Autowired
    //private JacksonTester<DataDetailDestination> dataDetailDestinationJson;

    @Test
    @DisplayName("Should return http code 400 when information is invalid!")
    @WithMockUser
    void create_scenar_scenario1() throws Exception {

        var response = mvc
                .perform(post("/destinations"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

}