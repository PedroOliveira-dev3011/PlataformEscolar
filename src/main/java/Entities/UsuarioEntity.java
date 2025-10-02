package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario")
    private String nome;
    @Column(name = "sobrenome_usuario")
    private String sobrenome;
    @Column(name = "email_usuario")
    private String email;
    @Column(name = "senha_usuario")
    private String senha;
    @Column(name = "cep_usuario")
    private String cep;
    @Column(name = "tel_usuario")
    private String telefone;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ProfessorEntity professor;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private AlunoEntity aluno;

}
