package br.com.alurachallengebackend7.controller;

import br.com.alurachallengebackend7.domain.testimonial.Testimonial;
import br.com.alurachallengebackend7.domain.testimonial.TestimonialActions;
import br.com.alurachallengebackend7.domain.testimonial.TestimonialRepository;
import br.com.alurachallengebackend7.domain.testimonial.dto.DataListTestimonials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



@RequestMapping("depoimentos-home")
@RestController
public class TestemunialHomeController {

        @Autowired
        private TestimonialRepository repository;

        @Autowired
        private TestimonialActions action;



        @GetMapping()
        public ResponseEntity<List<DataListTestimonials>> getThreeRandomTestimonials() throws Exception {
            List<DataListTestimonials> testimonialDTOS = action.generateShuffledListWithThreeTestimonials();
            return ResponseEntity.ok(testimonialDTOS);
        }
}

