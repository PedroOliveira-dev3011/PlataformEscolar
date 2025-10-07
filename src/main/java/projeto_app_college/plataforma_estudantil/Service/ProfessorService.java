package projeto_app_college.plataforma_estudantil.Service;

import projeto_app_college.plataforma_estudantil.Entities.ProfessorEntity;
import projeto_app_college.plataforma_estudantil.Repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorEntity> listarProfessores() {
        return professorRepository.findAll();
    }


    public ProfessorEntity buscarPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    public List<ProfessorEntity> buscarPorNome(String nome) {
        return professorRepository.findByNome(nome);
    }


    public ProfessorEntity salvarProfessor(ProfessorEntity professor) {
        return professorRepository.save(professor);
    }


    public ProfessorEntity atualizarProfessor(Long id, ProfessorEntity professorAtualizado) {
        ProfessorEntity professor = buscarPorId(id);

        professor.setNome(professorAtualizado.getNome());
        professor.setDisciplina(professorAtualizado.getDisciplina());

        return professorRepository.save(professor);
    }

    public void deletarProfessor(Long id) {
        ProfessorEntity professor = buscarPorId(id);
        professorRepository.delete(professor);
    }
}

