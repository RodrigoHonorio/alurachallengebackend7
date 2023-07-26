package br.com.alurachallengebackend7.domain.textGenerator.modal;

public class Prompt {

  public String generatePrompt(String name){
      return "Write a summary about "+ name +" emphasizing why this place is amazing. " +
              "Use informal language and up to 100 characters maximum in each paragraph. " +
              "Create 2 paragraphs in this summary.";
  }
}
