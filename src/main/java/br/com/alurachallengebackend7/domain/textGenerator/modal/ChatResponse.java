package br.com.alurachallengebackend7.domain.textGenerator.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChatResponse {
    private List<Choice> choices;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Choice {

        private int index;
        private Message message;

        public Choice(int index, Message message) {
            this.index = index;
            this.message = message;
        }
    }
}
