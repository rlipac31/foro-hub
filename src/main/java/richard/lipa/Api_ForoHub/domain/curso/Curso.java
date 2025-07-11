package richard.lipa.Api_ForoHub.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // me genera todos los geter y seters ala hora de la ejecucion del la aplicacion
@NoArgsConstructor//genera un constructor vacio
@AllArgsConstructor // genera un construcctor con todos los atributos de la entidad

@Embeddable// para indicar que esa entidad sera embebida en la Tabla medicos
public class Curso {
    @Column(name = "nombreCurso") // <--- ¡AÑADE ESTA ANOTACIÓN!
    private  String nombreCurso;
    @Column(name = "categoriaCurso") // <--- ¡AÑADE ESTA ANOTACIÓN!
    private  String categoriaCurso;

    public Curso(DatosCurso datos) {
        this.nombreCurso = datos.nombreCurso();
        this.categoriaCurso = datos.categoriaCurso();
    }
}
