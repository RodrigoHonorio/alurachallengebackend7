package br.com.alurachallengebackend7.infra.config.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIRestTemplateConfig {
    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Bean
    @Qualifier("openaiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        // Create a new instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Add an interceptor to the RestTemplate to include the API key in the request headers
        restTemplate.getInterceptors().add((request, body, execution) -> {
            // Add the "Authorization" header with the API key in the format "Bearer {apiKey}"
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });

        return restTemplate;
    }
}
