package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import application.model.Aluno;
import application.record.AlunoDTO;
import application.record.GenericResponse;
import application.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public GenericResponse insert(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNomeDoAluno(dto.nomeDoAluno());
        aluno.setEmail(dto.email());
        aluno.setSenha(passwordEncoder.encode(dto.senha()));
        alunoRepo.save(aluno);
        return new GenericResponse("Usuário adicionado.");
    }
}
