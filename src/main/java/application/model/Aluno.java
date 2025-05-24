package application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import application.record.AlunoDTO;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoAluno;
    private String email;
    private String senha;  // Será criptografada via Spring Security

    @ManyToMany(mappedBy = "alunos")  // Relacionamento N:M com Curso (lado inverso)
    private Set<Curso> cursos = new HashSet<>();

    // Construtor para DTO
    public Aluno(AlunoDTO alunoDTO) {
        this.id = alunoDTO.id();
        this.nomeDoAluno = alunoDTO.nomeDoAluno();
        this.email = alunoDTO.email();
    }
}