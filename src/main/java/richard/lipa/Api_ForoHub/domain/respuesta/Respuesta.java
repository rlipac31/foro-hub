package richard.lipa.Api_ForoHub.domain.respuesta;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import richard.lipa.Api_ForoHub.domain.topico.Topico;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.Optional;

//anotaciones JPA
@Table(name = "respuestas")
@Entity(name = "Respuesta")
//anotaciones del plugin lombok
@Getter // me genera todos los geter y seters ala hora de la ejecucion del la aplicacion
@NoArgsConstructor//genera un constructor vacio
@AllArgsConstructor // genera un construcctor con todos los atributos de la entidad
@EqualsAndHashCode(of = "id") // Mantén el exclude para EqualsAndHashCode
public class Respuesta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String mensaje;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "topico_id")
private Topico topico;
@Column(name = "fechaCreacion") // <--- ¡AÑADE ESTA ANOTACIÓN!
private LocalDateTime fechaCreacion;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "usuario_id")
private Usuario autor;
private  String solucion;
private Boolean state;



    public Respuesta(@NotBlank String mensaje, String solucion, Usuario usuario, Topico topico) {
        this.id = null;
        this.mensaje = mensaje;
        this.topico = topico;
        this.fechaCreacion = LocalDateTime.now();
        this.autor = usuario;
        this.solucion = solucion;
        this.state = true;
    }

    public void actualizarInformaciones( DatosActualizarRespuesta datos) {
        if(datos.mensaje() !=null){
            this.mensaje =datos.mensaje();
        }
        if(datos.solucion() != null){
            this.solucion= datos.solucion();
        }
    }

    public void eliminar(){
        this.state = false;
    }
}
