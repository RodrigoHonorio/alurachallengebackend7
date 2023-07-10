package br.com.alurachallengebackend7.domain.testimonial;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record TestimonialData(

        @NotBlank
        String name,
        @NotNull
        String testimonial,
        @NotNull
        String picture

){}
