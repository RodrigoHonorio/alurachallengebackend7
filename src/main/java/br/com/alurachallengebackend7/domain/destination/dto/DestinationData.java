package br.com.alurachallengebackend7.domain.destination.dto;

import br.com.alurachallengebackend7.domain.destination.Destination;
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

