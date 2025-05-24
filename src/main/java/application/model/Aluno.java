package application.model;

import application.record.AlunoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome_do_aluno", nullable = false, unique = true)
    private String nomeDoAluno;
    @Column(name = "email_do_aluno", nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;

    public Aluno(AlunoDTO dto) {
        this.id = dto.id();
        this.nomeDoAluno = dto.nomeDoAluno();
        this.email = dto.email();
        this.senha = dto.senha();
    }
}
