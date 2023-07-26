package br.com.alurachallengebackend7.domain.destination;

import br.com.alurachallengebackend7.domain.destination.dto.DestinationData;
import br.com.alurachallengebackend7.domain.testimonial.dto.DataUpdateDestination;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @NotBlank
    private String picture1;
    @NotNull
    @NotBlank
    private String picture2;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String meta;
    @Setter
    private String descriptiveText;
    @NotNull
    @NotBlank
    private Double price;
    private boolean active;


    public Destination(DestinationData data) {
        this.picture1 = data.picture1();
        this.picture2 = data.picture2();
        this.name = data.name();
        this.meta = data.meta();
        this.descriptiveText = data.descriptiveText();;
        this.price = data.price();
        this.active = true;
    }

    public void updateInformation(DataUpdateDestination data) {
        if(data.picture1()!=null){
            this.picture1 = data.picture1();
        }
        if(data.picture2()!=null){
            this.picture1 = data.picture2();
        }
        if(data.name()!=null){
            this.name = data.name();
        }
        if(data.meta()!=null){
            this.meta = data.meta();
        }
        if (data.descriptiveText()!=null){
            this.descriptiveText = data.descriptiveText();
        }
        if(data.price()!=null){
            this.price = data.price();
        }
    }

    public void delete() {
        this.active = false;
    }
}
