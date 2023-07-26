package br.com.alurachallengebackend7.domain.textGenerator.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    private String role;
    private String content;
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

}
