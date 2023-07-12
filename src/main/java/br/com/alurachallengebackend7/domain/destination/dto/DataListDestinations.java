package br.com.alurachallengebackend7.domain.destination.dto;

import br.com.alurachallengebackend7.domain.destination.Destination;

public record DataListDestinations(Long id, String picture, String name, Double price) {
    public DataListDestinations(Destination destination){
        this(destination.getId(), destination.getPicture(), destination.getName(), destination.getPrice());
    }
}
