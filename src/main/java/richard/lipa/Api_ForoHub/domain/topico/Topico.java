package richard.lipa.Api_ForoHub.domain.topico;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import richard.lipa.Api_ForoHub.domain.curso.Curso;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

//anotaciones JPA
@Table(name = "topicos")
@Entity(name = "Topico")
//anotaciones del plugin lombok
@Getter // me genera todos los geter y seters ala hora de la ejecucion del la aplicacion
@NoArgsConstructor//genera un constructor vacio
@AllArgsConstructor // genera un construcctor con todos los atributos de la entidad
@EqualsAndHashCode(of = "id", exclude = {"autor"}) // Mantén el exclude para EqualsAndHashCode
@ToString(exclude = {"autor"}) // <--- ¡AÑADE ESTA LÍNEA!//evita que se llame infinitamente strig y genere errores //pero se puede seguir accediendo a el con getAutor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String titulo;
    private  String mensaje;
    @Column(name = "fecha_creacion") // <--- ¡AÑADE ESTA ANOTACIÓN!
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore // <--- ¡AÑADE ESTA ANOTACIÓN!
    private Usuario autor;
    @Embedded
    private Curso curso;
    private Boolean state;

    public Topico(@Valid String titulo, String mensaje, Usuario usuario, Curso curso) {
        this.id = null;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();
        this.autor = usuario;
        this.curso = curso;
        this.state = true;
    }


}
