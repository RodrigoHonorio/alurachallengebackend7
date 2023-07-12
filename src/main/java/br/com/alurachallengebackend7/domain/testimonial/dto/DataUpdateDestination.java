package br.com.alurachallengebackend7.domain.testimonial.dto;

import javax.validation.constraints.NotNull;

public record DataUpdateDestination(
        @NotNull
        Long id,
        String picture,
        String name,
        Double price
) {
}
