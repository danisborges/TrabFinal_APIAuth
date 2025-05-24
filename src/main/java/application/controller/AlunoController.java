package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.record.AlunoDTO;
import application.record.GenericResponse;
import application.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public GenericResponse insert(@RequestBody AlunoDTO aluno) {
        // if(aluno.nomeDoAluno().trim().length() == 0) {
        //     throw new ResponseStatusException(
        //         HttpStatus.BAD_REQUEST, "Nome de aluno não definido."
        //     );
        // }
        
        // if(aluno.senha().trim().length() == 0) {
        //     throw new ResponseStatusException(
        //         HttpStatus.BAD_REQUEST, "Senha de usuário não definido"
        //     );
        // }
        
        String returnMessage = "";
        if(aluno.nomeDoAluno().trim().length() == 0) {
            returnMessage = "Nome de aluno não cadastrado.";
        }
        if(aluno.senha().trim().length() == 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, returnMessage
            );
        }
        return alunoService.insert(aluno);    
    }
}
