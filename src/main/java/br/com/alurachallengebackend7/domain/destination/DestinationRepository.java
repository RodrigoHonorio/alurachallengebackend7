package br.com.alurachallengebackend7.domain.destination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    Page<Destination> findAllByActiveTrue(Pageable pagination);

    Destination findByIdAndActiveTrue(Long id);

    Page<Destination> findAllByNameAndActiveTrue(String name, Pageable pagination);
    List<Destination>findAllByNameAndActiveTrue(String name);
}
