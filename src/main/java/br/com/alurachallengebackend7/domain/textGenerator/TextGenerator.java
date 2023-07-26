package br.com.alurachallengebackend7.domain.textGenerator;

import br.com.alurachallengebackend7.domain.textGenerator.modal.ChatRequest;
import br.com.alurachallengebackend7.domain.textGenerator.modal.ChatResponse;
import br.com.alurachallengebackend7.domain.textGenerator.modal.Prompt;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Service
public class TextGenerator {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String generateText(@NotNull @NotBlank String name){
        ChatRequest request = new ChatRequest(model, new Prompt().generatePrompt(name));
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        return response.getChoices().get(0).getMessage().getContent();
    }
}
