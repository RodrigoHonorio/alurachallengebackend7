package br.com.alurachallengebackend7.domain.testimonial;

public record DataDetailTestimonial(Long id, String picture, String testemonial, String name) {
    public DataDetailTestimonial(Testimonial testimonial){
        this(testimonial.getId(), testimonial.getPicture(), testimonial.getTestmonial(), testimonial.getName());

    }
}
