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
    @Setter
    private  String titulo;
    @Setter
    private  String mensaje;
    @Column(name = "fecha_creacion") // <--- ¡AÑADE ESTA ANOTACIÓN!
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore // <--- ¡AÑADE ESTA ANOTACIÓN!
    private Usuario autor;
    @Setter
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



    public void actualizarInformaciones(@Valid DatosActualizarTopico datos, Curso cursoUpdates) {
        // Actualizar campos directos
        if(datos.titulo() != null && !datos.titulo().equals(this.titulo)) {
            System.out.println("entro al modificar titulo");
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null && !datos.mensaje().equals(this.mensaje)) {
            System.out.println("entro al modificar mensage");
            this.mensaje = datos.mensaje();
        }
        System.out.println("no entro a modificar titulo ni mensage");
        // Actualizar el curso embebido
        if(cursoUpdates != null) {

            if(this.curso == null) {
                this.curso = new Curso(); // Inicializar si es null
            }

            if(cursoUpdates.getNombreCurso() != null) {
                System.out.println("entro al modificar curso");
                this.curso.setNombreCurso(cursoUpdates.getNombreCurso());
            }
            if(cursoUpdates.getCategoriaCurso() != null) {
                this.curso.setCategoriaCurso(cursoUpdates.getCategoriaCurso());
            }
        }

    }

    public void eliminar() {
        this.state=false;
    }
}
