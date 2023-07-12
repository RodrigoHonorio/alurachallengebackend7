package br.com.alurachallengebackend7.domain.testimonial;

import br.com.alurachallengebackend7.domain.testimonial.dto.DataListTestimonials;
import br.com.alurachallengebackend7.domain.testimonial.validation.ValidaListaHasThreeTestimonials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;





@Service
public class TestimonialActions {

    private TestimonialRepository repository;
    private ValidaListaHasThreeTestimonials validation;

    @Autowired
    public TestimonialActions(TestimonialRepository repository, ValidaListaHasThreeTestimonials validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public List<DataListTestimonials> generateShuffledListWithThreeTestimonials() throws Exception {
        var testimonial = repository.findAllByActiveTrue();
        ValidaListaHasThreeTestimonials validation = new ValidaListaHasThreeTestimonials();

        Collections.shuffle(testimonial);
        List<DataListTestimonials> testimonialDTOS = testimonial.stream()
                .limit(3)
                .map(DataListTestimonials::new)
                .toList();
        validation.validate(testimonialDTOS);
        return testimonialDTOS;
    }
}