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
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matricula")
    private Long id;
    @Column(name = "Nome do Aluno")
    private String nome;
    @Column(name = "Classe")
    private String classe;

    @OneToOne
    @JoinColumn(name = "usuarios_id")
    private UsuarioEntity usuario;
}
