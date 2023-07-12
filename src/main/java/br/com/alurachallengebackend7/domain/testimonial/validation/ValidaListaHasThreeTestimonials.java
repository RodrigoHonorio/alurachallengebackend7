package br.com.alurachallengebackend7.domain.testimonial.validation;

import br.com.alurachallengebackend7.domain.ValidationException;
import br.com.alurachallengebackend7.domain.testimonial.dto.DataListTestimonials;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidaListaHasThreeTestimonials {

    public void validate(List<DataListTestimonials> list) {
        if(list.size()<3){
            throw new ValidationException("List contains less than 3 testimonials");
        }
    }
}
