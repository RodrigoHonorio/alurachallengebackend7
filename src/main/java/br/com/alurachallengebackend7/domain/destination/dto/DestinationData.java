package br.com.alurachallengebackend7.domain.destination.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DestinationData(

        @NotNull
        @NotBlank
        String picture1,
        @NotNull
        @NotBlank
        String picture2,
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String meta,

        String descriptiveText,

        @NotNull
        @NotBlank
        Double price){

}

