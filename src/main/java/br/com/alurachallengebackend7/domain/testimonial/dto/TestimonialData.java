package br.com.alurachallengebackend7.domain.testimonial.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record TestimonialData(

        @NotBlank
        @NotNull
        String name,
        @NotBlank
        @NotNull
        String picture,
        @NotBlank
        @NotNull
        String testimonial


){}
