package projeto_app_college.plataforma_estudantil.Controller;

import projeto_app_college.plataforma_estudantil.Entities.ProfessorEntity;
import projeto_app_college.plataforma_estudantil.Service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

    @RestController
    @RequestMapping("/professores") // Prefixo das rotas
    public class ProfessorController {

        private final ProfessorService professorService;

        // Construtor para injeção do service
        public ProfessorController(ProfessorService professorService) {
            this.professorService = professorService;
        }

        // ✅ 1. Listar todos os professores
        @GetMapping
        public ResponseEntity<List<ProfessorEntity>> listarTodos() {
            List<ProfessorEntity> professores = professorService.listarProfessores();
            return ResponseEntity.ok(professores);
        }

        // ✅ 2. Buscar professor por ID
        @GetMapping("/{id}")
        public ResponseEntity<ProfessorEntity> buscarPorId(@PathVariable Long id) {
            ProfessorEntity professor = professorService.buscarPorId(id);
            return ResponseEntity.ok(professor);
        }

        // ✅ 3. Buscar professor por nome (ex: /professores?nome=Maria)
        @GetMapping(params = "nome")
        public ResponseEntity<List<ProfessorEntity>> buscarPorNome(@RequestParam String nome) {
            List<ProfessorEntity> professores = professorService.buscarPorNome(nome);
            return ResponseEntity.ok(professores);
        }

        // ✅ 4. Criar novo professor
        @PostMapping
        public ResponseEntity<ProfessorEntity> criar(@RequestBody ProfessorEntity professor) {
            ProfessorEntity novoProfessor = professorService.salvarProfessor(professor);
            URI uri = URI.create("/professores/" + novoProfessor.getId());
            return ResponseEntity.created(uri).body(novoProfessor);
        }

        // ✅ 5. Atualizar professor existente
        @PutMapping("/{id}")
        public ResponseEntity<ProfessorEntity> atualizar(@PathVariable Long id, @RequestBody ProfessorEntity professor) {
            ProfessorEntity professorAtualizado = professorService.atualizarProfessor(id, professor);
            return ResponseEntity.ok(professorAtualizado);
        }

        // ✅ 6. Deletar professor
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            professorService.deletarProfessor(id);
            return ResponseEntity.noContent().build();
        }
    }

