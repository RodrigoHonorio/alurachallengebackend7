package br.com.alurachallengebackend7.controller;

import br.com.alurachallengebackend7.domain.testimonial.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
@RequestMapping("testimonial")
@RestController
public class TestimonialController {

    private TestimonialRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TestimonialData data, UriComponentsBuilder uriBuilder) {
        var testimunial = new Testimonial(data);
        repository.save(testimunial);
        var uri = uriBuilder.path("/testimonial/{id}").buildAndExpand(testimunial.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailTestimonial(testimunial));
    }

    @GetMapping
    public ResponseEntity<Page<DataListTestimonials>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(DataListTestimonials::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateTestimonial data) {
        var testimunial = repository.getReferenceById(data.id());
        testimunial.updateTheInfomation(data);
        return ResponseEntity.ok(new DataDetailTestimonial(testimunial));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var testimunial = repository.getReferenceById(id);
        testimunial.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var testimunial = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailTestimonial(testimunial));
    }
}
