package projeto_app_college.plataforma_estudantil.Service;

import org.springframework.beans.factory.annotation.Autowired;
import projeto_app_college.plataforma_estudantil.Entities.AlunoEntity;
import projeto_app_college.plataforma_estudantil.Repository.AlunoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Service
public class AlunoService {
    @Autowired
     private AlunoRepository alunoRepository;

    public List<AlunoEntity> listarAlunos(){
        return alunoRepository.findAll();
    }
    public List<AlunoEntity> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }
    public AlunoEntity buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
    }

    public AlunoEntity atualizarAluno(Long id, AlunoEntity alunoAtualizado) {
        AlunoEntity aluno = buscarPorId(id);
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setClasse(alunoAtualizado.getClasse());
        return alunoRepository.save(aluno);
    }

    public AlunoEntity salvarAluno(AlunoEntity aluno) {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do aluno é obrigatorio");
        }
        return alunoRepository.save(aluno);
    }
    public void deletarAluno(Long id) {
        AlunoEntity aluno = buscarPorId(id);
        alunoRepository.delete(aluno);
    }


    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }


}
