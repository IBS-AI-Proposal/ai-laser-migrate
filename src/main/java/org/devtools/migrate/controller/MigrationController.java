package org.devtools.migrate.controller;

import org.devtools.migrate.service.AIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MigrationController {

  private final AIService aiService;

  public MigrationController(AIService aiService) {
    this.aiService = aiService;
  }

  @GetMapping("/ask")
  public String ask(@RequestParam String prompt) throws Exception {
    return aiService.askLLM(prompt);
  }
}
