package br.com.alurachallengebackend7.domain.destination.dto;

import br.com.alurachallengebackend7.domain.destination.Destination;

public record DataDetailDestination(Long id,
                                    String picture1,
                                    String picute2,
                                    String name,
                                    String meta,
                                    String descriptiveText,
                                    Double price) {

    public DataDetailDestination(Destination destination) {
        this(
                destination.getId(),
                destination.getPicture1(),
                destination.getPicture2(),
                destination.getName(),
                destination.getMeta(),
                destination.getDescriptiveText(),
                destination.getPrice());
    }
}
