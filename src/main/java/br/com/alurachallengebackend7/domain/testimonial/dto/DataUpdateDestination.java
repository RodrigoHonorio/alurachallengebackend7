package br.com.alurachallengebackend7.domain.testimonial.dto;

import javax.validation.constraints.NotNull;

public record DataUpdateDestination(
        Long id,
        String picture1,
        String picture2,
        String name,
        String meta,
        String descriptiveText,
        Double price
) {
}
