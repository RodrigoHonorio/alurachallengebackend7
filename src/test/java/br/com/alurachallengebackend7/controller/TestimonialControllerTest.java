package br.com.alurachallengebackend7.controller;

import br.com.alurachallengebackend7.domain.testimonial.Testimonial;
import br.com.alurachallengebackend7.domain.testimonial.TestimonialRepository;
import br.com.alurachallengebackend7.domain.testimonial.dto.DataDetailTestimonial;
import br.com.alurachallengebackend7.domain.testimonial.dto.TestimonialData;
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
class TestimonialControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private TestimonialRepository repository;
    @Autowired
    private JacksonTester<TestimonialData> testimonialDataJson;

    @Autowired
    private JacksonTester<DataDetailTestimonial> dataDetailTestimonialJson;



    @Test
    @DisplayName("Should return http code 400 when information is invalid!")
    @WithMockUser
    void createScenario01() throws Exception {

        var response = mvc
                .perform(post("/testimonial"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
    @Test
    @DisplayName("Should return http code 200 when information is valid!")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {

        var testimonialData = new TestimonialData(
                "London",
                "picture1",
                "Nice place"
        );
        var dataDetailTestimonial = new DataDetailTestimonial(
                null,
                 testimonialData.name(),
                testimonialData.picture(),
                testimonialData.testimonial()
        );

        var jsonExpected = dataDetailTestimonialJson.write(dataDetailTestimonial).getJson();

        when(repository.save(any())).thenReturn(new Testimonial(testimonialData));

        var response = mvc.perform(post("/testimonial")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testimonialDataJson.write(testimonialData).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonExpected);
    }
}