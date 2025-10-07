package projeto_app_college.plataforma_estudantil.Controller;

import projeto_app_college.plataforma_estudantil.Entities.UsuarioEntity;
import projeto_app_college.plataforma_estudantil.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios") // prefixo das rotas
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Construtor para injeção do service
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ✅ 1. Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioService.listarTodosUsuario();
        return ResponseEntity.ok(usuarios);
    }

    // ✅ 2. Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarPorId(@PathVariable Long id) {
        UsuarioEntity usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
        return ResponseEntity.ok(usuario);
    }

    // ✅ 3. Buscar usuário por nome (ex: /usuarios?nome=Pedro)
    @GetMapping(params = "nome")
    public ResponseEntity<List<UsuarioEntity>> buscarPorNome(@RequestParam String nome) {
        List<UsuarioEntity> usuarios = usuarioService.buscarPorNome(nome);
        return ResponseEntity.ok(usuarios);
    }

    // ✅ 4. Buscar usuário por email (ex: /usuarios/email?email=teste@teste.com)
    @GetMapping("/email")
    public ResponseEntity<UsuarioEntity> buscarPorEmail(@RequestParam String email) {
        UsuarioEntity usuario = usuarioService.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com email: " + email));
        return ResponseEntity.ok(usuario);
    }

    // ✅ 5. Criar novo usuário
    @PostMapping
    public ResponseEntity<UsuarioEntity> criar(@RequestBody UsuarioEntity usuario) {
        UsuarioEntity novoUsuario = usuarioService.criarUsuario(usuario);
        URI uri = URI.create("/usuarios/" + novoUsuario.getId());
        return ResponseEntity.created(uri).body(novoUsuario);
    }

    // ✅ 6. Atualizar usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> atualizar(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        UsuarioEntity usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // ✅ 7. Deletar usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
