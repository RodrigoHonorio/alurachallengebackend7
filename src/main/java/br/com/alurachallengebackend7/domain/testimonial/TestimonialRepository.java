package br.com.alurachallengebackend7.domain.testimonial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

   Page<Testimonial> findAllByActiveTrue(Pageable pagination);

}
