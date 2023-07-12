package br.com.alurachallengebackend7.controller;

import br.com.alurachallengebackend7.domain.destination.Destination;
import br.com.alurachallengebackend7.domain.destination.DestinationRepository;
import br.com.alurachallengebackend7.domain.destination.dto.DataDetailDestination;
import br.com.alurachallengebackend7.domain.destination.dto.DataListDestinations;
import br.com.alurachallengebackend7.domain.destination.dto.DestinationData;

import br.com.alurachallengebackend7.domain.testimonial.dto.DataUpdateDestination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("destinations")
@RestController
public class DestinationController {

    @Autowired
    private DestinationRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DestinationData data, UriComponentsBuilder uriBuilder) {
        var destination = new Destination(data);
        repository.save(destination);
        var uri = uriBuilder.path("/destination/{id}").buildAndExpand(destination.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailDestination(destination));
    }

    @GetMapping
    public ResponseEntity <Page<DataListDestinations>>list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        var page = repository.findAllByActiveTrue(pagination).map(DataListDestinations::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public  ResponseEntity update(@RequestBody @Valid DataUpdateDestination data){
        var destination = repository.findByIdAndActiveTrue(data.id());
        destination.updateInformation(data);
        return ResponseEntity.ok(new DataDetailDestination(destination));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        System.out.println("Passei por aqui!");
        var destination = repository.findByIdAndActiveTrue(id);
        destination.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var destination =  repository.findByIdAndActiveTrue(id);
        return ResponseEntity.ok(new DataDetailDestination(destination));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<DataListDestinations>> listSameName(@RequestParam String name) {
        var pagination = PageRequest.of(0, 10, Sort.by("name"));
        var page = repository.findAllByNameAndActiveTrue(name, pagination).map(DataListDestinations::new);
        if (page.isEmpty()) {
            return ResponseEntity.noContent().header("X-Error-Message", "no results found").build();
        } else {
            return ResponseEntity.ok(page);
        }
    }
}
