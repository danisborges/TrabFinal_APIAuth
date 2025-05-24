package application.repository;

import application.model.Modulo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    Set<Modulo> findByCursoId(Long cursoId);
}