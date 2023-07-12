package br.com.alurachallengebackend7.domain.destination;

import br.com.alurachallengebackend7.domain.destination.dto.DestinationData;
import br.com.alurachallengebackend7.domain.testimonial.dto.DataUpdateDestination;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "destination")
@Entity(name = "Destination")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picture;
    private String name;
    private Double price;
    private boolean active;


    public Destination(DestinationData data) {
        this.picture = data.picture();
        this.name = data.name();
        this.price = data.price();
        this.active = true;
    }

    public void updateInformation(DataUpdateDestination data) {
        if(data.picture()!=null){
            this.picture = data.picture();
        }
        if(data.name()!=null){
            this.name = data.name();
        }
        if(data.price()!=null){
            this.price = data.price();
        }
    }

    public void delete() {
        this.active = false;
    }
}
