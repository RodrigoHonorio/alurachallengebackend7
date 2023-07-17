package br.com.alurachallengebackend7.domain.testimonial.dto;

import br.com.alurachallengebackend7.domain.testimonial.Testimonial;

public record DataDetailTestimonial(Long id, String name, String picture, String testemonial) {
    public DataDetailTestimonial(Testimonial testimonial){
        this(testimonial.getId(), testimonial.getName(), testimonial.getPicture(), testimonial.getTestimonial());

    }
}
