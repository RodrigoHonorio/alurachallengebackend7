package br.com.alurachallengebackend7.domain.testimonial.dto;

import br.com.alurachallengebackend7.domain.testimonial.Testimonial;

public record DataListTestimonials(Long id, String name, String testimonial, String picture) {

    public DataListTestimonials(Testimonial testimonial){
        this(testimonial.getId(), testimonial.getName(), testimonial.getPicture(), testimonial.getTestimonial());
    }

}
