package projeto_app_college.plataforma_estudantil.Controller;

import projeto_app_college.plataforma_estudantil.Entities.AlunoEntity;
import projeto_app_college.plataforma_estudantil.Service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    // Injeção via construtor (melhor prática)
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // ✅ 1. Listar todos os alunos
    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarTodos() {
        List<AlunoEntity> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    // ✅ 2. Buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> buscarPorId(@PathVariable Long id) {
        AlunoEntity aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    // ✅ 3. Buscar aluno por nome (exemplo: /alunos?nome=pedro)
    @GetMapping(params = "nome")
    public ResponseEntity<List<AlunoEntity>> buscarPorNome(@RequestParam String nome) {
        List<AlunoEntity> alunos = alunoService.buscarPorNome(nome);
        return ResponseEntity.ok(alunos);
    }

    // ✅ 4. Criar um novo aluno
    @PostMapping
    public ResponseEntity<AlunoEntity> criar(@RequestBody AlunoEntity aluno) {
        AlunoEntity novoAluno = alunoService.salvarAluno(aluno);
        URI uri = URI.create("/alunos/" + novoAluno.getId());
        return ResponseEntity.created(uri).body(novoAluno);
    }

    // ✅ 5. Atualizar aluno existente
    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> atualizar(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        AlunoEntity alunoAtualizado = alunoService.atualizarAluno(id, aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    // ✅ 6. Deletar aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
    }