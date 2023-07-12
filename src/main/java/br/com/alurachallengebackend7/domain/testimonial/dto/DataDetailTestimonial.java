package br.com.alurachallengebackend7.domain.testimonial.dto;

import br.com.alurachallengebackend7.domain.testimonial.Testimonial;

public record DataDetailTestimonial(Long id, String picture, String testemonial, String name) {
    public DataDetailTestimonial(Testimonial testimonial){
        this(testimonial.getId(), testimonial.getPicture(), testimonial.getTestimonial(), testimonial.getName());

    }
}
