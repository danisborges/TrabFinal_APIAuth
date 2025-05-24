package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import application.model.Aluno;
import application.record.AlunoDTO;
import application.record.AlunoInsertDTO;
import application.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AlunoDTO create(AlunoInsertDTO alunoInsertDTO) {
        Aluno aluno = new Aluno();
        aluno.setNomeDoAluno(alunoInsertDTO.nomeDoAluno());
        aluno.setEmail(alunoInsertDTO.email());
        aluno.setSenha(passwordEncoder.encode(alunoInsertDTO.senha()));
        
        aluno = alunoRepo.save(aluno);
        return new AlunoDTO(aluno);
    }
}