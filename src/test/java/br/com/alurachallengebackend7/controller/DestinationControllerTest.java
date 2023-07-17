package br.com.alurachallengebackend7.controller;

import br.com.alurachallengebackend7.domain.destination.Destination;
import br.com.alurachallengebackend7.domain.destination.DestinationRepository;
import br.com.alurachallengebackend7.domain.destination.dto.DataDetailDestination;
import br.com.alurachallengebackend7.domain.destination.dto.DestinationData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DestinationControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DestinationRepository repository;

    @Autowired
    private JacksonTester<DestinationData> destinationDataJson;
    @Autowired
    private JacksonTester<DataDetailDestination> dataDetailDestinationJson;

    @Test
    @DisplayName("Should return http code 400 when information is invalid!")
    @WithMockUser
    void createScenario01() throws Exception {

        var response = mvc
                .perform(post("/destinations"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
    @Test
    @DisplayName("Should return http code 200 when information is valid!")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {

        var destinationData = new   DestinationData(
                "foto2",
                "Rodrigo",
                "Londres",
                2.09
        );
        var dataDetailDestination = new DataDetailDestination(
                null,
                destinationData.picture(),
                destinationData.name(),
                destinationData.price()
        );
        var jsonExpected = dataDetailDestinationJson.write(dataDetailDestination).getJson();

        when(repository.save(any())).thenReturn(new Destination(destinationData));

        var response = mvc.perform(post("/destinations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(destinationDataJson.write(destinationData).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonExpected);
    }
}