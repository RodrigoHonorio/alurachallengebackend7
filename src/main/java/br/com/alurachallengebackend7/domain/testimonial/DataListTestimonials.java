package br.com.alurachallengebackend7.domain.testimonial;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DataListTestimonials(Long id, String name, String testimonial, String picture) {

    public DataListTestimonials(Testimonial testimonial){
        this(testimonial.getId(), testimonial.getName(), testimonial.getPicture(), testimonial.getTestmonial());
    }

}
