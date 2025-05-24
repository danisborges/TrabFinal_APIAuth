package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import application.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}