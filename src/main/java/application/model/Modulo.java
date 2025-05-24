package application.model;

import application.record.ModuloDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "modulos")
@Getter
@Setter
@NoArgsConstructor
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tituloDoModulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;  // Relacionamento N:1 com Curso

    // Construtor para DTO
    public Modulo(ModuloDTO moduloDTO) {
        this.id = moduloDTO.id();
        this.tituloDoModulo = moduloDTO.tituloDoModulo();
        this.descricao = moduloDTO.descricao();
    }
}

/// ----------------------------------------------------------------------------------
// package application.model;

// import application.record.ModuloDTO;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Table(name = "modulos")
// @Getter
// @Setter
// @NoArgsConstructor
// public class Modulo {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;
//     @Column(name = "titulo_do_modulo", nullable = false, unique = true)
//     private String tituloDoModulo;
//     @Column(name = "descrição", nullable = false)
//     private String descricao;

//     // @ManyToOne
//     // @JoinColumn(name = "curso_id", nullable = false)
//     // private Curso curso;

//     public Modulo(ModuloDTO dto) {
//         this.id = dto.id();
//         this.tituloDoModulo = dto.tituloDoModulo();
//         this.descricao = dto.descricao();
//     }
// }