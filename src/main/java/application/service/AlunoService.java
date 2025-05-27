package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import application.model.Aluno;
import application.record.AlunoDTO;
import application.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

}