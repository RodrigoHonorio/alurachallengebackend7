package br.com.alurachallengebackend7.domain.destination.dto;


import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DestinationData(

        @NotBlank
        String picture,
        @NotNull
        String name,
        @NotNull
        String destination,
        @NotNull
        Double price){


}

