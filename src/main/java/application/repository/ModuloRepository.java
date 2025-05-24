package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    public Modulo findByTituloDoModulo(String tituloDoModulo);
}
