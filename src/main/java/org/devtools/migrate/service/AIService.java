package org.devtools.migrate.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

  public String askLLM(String prompt) {
    // Hardcoded sample response for now
    return "Sample AI response for prompt: \"" + prompt + "\"";
  }
}
