package br.com.alurachallengebackend7.domain.testimonial;

import javax.validation.constraints.NotNull;

public record DataUpdateTestimonial(
    @NotNull
    Long id,
    String name,

    String testimonial,

    String picture){
}
