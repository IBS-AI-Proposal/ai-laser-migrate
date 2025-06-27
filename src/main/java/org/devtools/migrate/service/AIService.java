package org.devtools.migrate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AIService {

  @Value("${openai.api.key}")
  private String apiKey;

  private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

  public String askLLM(String prompt) {

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(apiKey);

    Map<String, Object> request = Map.of(
        "model", "gpt-3.5-turbo",
        "messages", List.of(
            Map.of("role", "user", "content", prompt)
        )
    );

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

    ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, entity, String.class);

    return response.getBody();
  }
}
