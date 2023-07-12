package br.com.alurachallengebackend7.domain.testimonial;

import br.com.alurachallengebackend7.domain.testimonial.dto.DataUpdateTestimonial;
import br.com.alurachallengebackend7.domain.testimonial.dto.TestimonialData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "testimonial")
@Entity(name = "Testimonial")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picture;
    private String testimonial;
    private String name;
    private boolean active;

    public Testimonial(TestimonialData data) {
        this.name = data.name();
        this.picture = data.picture();
        this.testimonial = data.testimonial();
        this.active=true;
    }

    public void updateInfomation(DataUpdateTestimonial data) {

        if(data.name() != null){
            this.name = data.name();
        }
        if(data.picture() != null){
            this.picture = data.picture();
        }
        if (data.testimonial() != null){
            this.testimonial = data.testimonial();
        }
    }

    public void delete() {
        this.active = false;
    }
}
